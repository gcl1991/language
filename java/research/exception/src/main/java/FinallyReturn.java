import javax.annotation.processing.FilerException;
import java.io.FileNotFoundException;
import java.net.UnknownHostException;

public class FinallyReturn {
    public static int returnOrder(boolean activeExeception){
        try {
            if (activeExeception){
                throw new FileNotFoundException();
            }
            return 1;
        }catch (FileNotFoundException e){
            return 2;
        }
        finally {
            return 3;
        }
    }
}
