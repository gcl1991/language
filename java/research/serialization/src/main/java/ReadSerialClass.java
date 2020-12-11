import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadSerialClass {
    public static void main(String [] args) {
        String filename = "time.ser";
        SerialClass time = null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            time = (SerialClass)in.readObject();
        } catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        System.out.println("Restored time: " + time.getCurrentTime());
    }
}
