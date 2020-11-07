import java.io.FileNotFoundException;

public class FinallyExeception {
    public static void execeptionOverride(boolean active) throws FileNotFoundException {
        try {
            if(active){
                throw new FileNotFoundException("1");
            }
        }finally {
            if (active){
                throw new FileNotFoundException("2");
            }
        }
    }
}
