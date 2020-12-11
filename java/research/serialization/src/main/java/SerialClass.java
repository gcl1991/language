import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class SerialClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date currentTime;

    public SerialClass() {
        currentTime = Calendar.getInstance().getTime();
    }

    public Date getCurrentTime() {
        return currentTime;
    }
}
