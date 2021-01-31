package net.sdo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.*;

import net.sdo.stock.StockPriceHistory;
import net.sdo.stock.StockPriceUtils;


@RestController
@RequestMapping(value = "/StockServlet")
public class StockServlet{
    private StockSessionBeanLocal stockSessionBean = new StockSessionBeanImpl();
    private boolean doMock = System.getProperty("MockEntityManager") != null;
    private ThreadLocal<DateFormat> localDf = new ThreadLocal<DateFormat>() {
        @Override
        public DateFormat initialValue() {
            return DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
        }
    };
    Set<SoftReference<StockPriceHistory>> softCache = new HashSet();
    Set<WeakReference<StockPriceHistory>> weakCache = new HashSet();

    @RequestMapping(method = RequestMethod.GET)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    @RequestMapping(method = RequestMethod.POST)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String symbol = request.getParameter("symbol");
            if (symbol == null) {
                symbol = StockPriceUtils.getRandomSymbol();
            }
            String startDate = request.getParameter("startDate");
            if (startDate == null) {
                startDate = "1/1/01";
            }
            String endDate = request.getParameter("endDate");
            if (endDate == null) {
                endDate = "12/31/25";
            }
            String log = request.getParameter("log");
            int impl = StockPriceHistory.STANDARD;
            if ("true".equals(log)) {
                impl = StockPriceHistory.LOGGING;
            }
            StockPriceHistory sph;
            DateFormat df = localDf.get();
            sph = stockSessionBean.getHistory(symbol, df.parse(startDate),df.parse(endDate), doMock, impl);
            String saveSession = request.getParameter("save");
            if (saveSession != null) {
                int saveCount = Integer.parseInt(saveSession);
                HttpSession session = request.getSession(true);
                ArrayList<StockPriceHistory> al =
                        (ArrayList<StockPriceHistory>) session.getAttribute("saveHistory");
                if (al == null) {
                    al = new ArrayList<StockPriceHistory>(100);
                }
                al.add(sph);
                if (al.size() > saveCount) {
                    al.remove(0);
                }
                ArrayList<Date> ald = (ArrayList<Date>) session.getAttribute("date");
                if (ald == null) {
                    ald = new ArrayList<Date>(100);
                }
                ald.add(new Date());
                if (ald.size() > saveCount * 4) {
                    ald.remove(0);
                }
                session.setAttribute("saveHistory", al);
                session.setAttribute("last", ald);
            }
            String doSoftCache = request.getParameter("saveSoft");
            if ("true".equals(doSoftCache)) {
                softCache.add(new SoftReference(sph));
            }
            String doWeakCache = request.getParameter("saveWeak");
            if ("true".equals(doWeakCache)) {
                weakCache.add(new WeakReference(sph));
            }
            request.setAttribute("history", sph);
            String doLong = request.getParameter("long");
            if ("true".equals(doLong)) {
                request.getRequestDispatcher("longhistory.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("history.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("exception", e);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    public String getServletInfo() {
        return "Sample StockPrice Servlet";
    }
}
