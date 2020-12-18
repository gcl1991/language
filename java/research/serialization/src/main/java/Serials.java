import java.io.*;

public class Serials {
    public static <T> void read(String filePath){
        T obj = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))){
            obj = (T) in.readObject();
        } catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        System.out.println("Restored obj: " + obj.toString());
    }

    public static <T> void write(String filePath,T obj){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
            //Write byte stream to file system.
            out.writeObject(obj);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
