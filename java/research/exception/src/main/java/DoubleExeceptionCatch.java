import java.io.FileNotFoundException;
import java.net.UnknownHostException;

public class DoubleExeceptionCatch {
    public static void doubleCatch(boolean isFileException){
        try {
            if (isFileException){
                throw new FileNotFoundException();
            }else {
                throw new UnknownHostException();
            }
        }catch (FileNotFoundException | UnknownHostException e){
            // 由于无法判断运行时候e是那种类型，所以e被变为不可变类型
            // e = new FileNotFoundException();
        }
    }

    public static void catchThrow(int flag){
        try {
            if (flag == 1){
                throw new FileNotFoundException();
            }
        }
        catch (FileNotFoundException ef){
            if (flag == 1){
                // 此处再抛出异常不会被下级Catch捕获
//                throw new UnknownHostException();
            }
        }
//        catch (UnknownHostException eu){

//        }

    }
}
