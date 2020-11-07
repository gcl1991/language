import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TryResource {
    public static void tryResource(boolean active) throws FileNotFoundException{
        try (Scanner in = new Scanner("words.txt")){
            if (active){
                throw new FileNotFoundException();
            }
        }
    }
}
