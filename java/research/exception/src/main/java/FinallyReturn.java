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
            // 无论触发哪个异常，最终返回皆为3
            return 3;
        }
    }
}
