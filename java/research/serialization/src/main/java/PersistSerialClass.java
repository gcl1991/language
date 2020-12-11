import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersistSerialClass {
    public static void main(String[] args) {
        String filename = "time.ser";
        //We will write this object to file system.
        SerialClass time = new SerialClass();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            //Write byte stream to file system.
            out.writeObject(time);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
