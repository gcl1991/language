import java.io.*;

public class Serials {
    public static <T> T read(String filePath){
        T obj = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))){
            obj = (T) in.readObject();
        } catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return obj;
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
