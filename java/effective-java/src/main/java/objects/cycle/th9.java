package objects.cycle;


// 使用try-with-resources替代try-finally释放AutoCloseable资源，因为try-finally将造成异常覆盖和异常丢失
import java.io.*;
public class th9 {
    private static final int BUFFER_SIZE = 1024;
    // 最终异常1和2将被异常3覆盖，造成异常1和2丢失
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            //  抛出异常1
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                // 抛出异常2
                out.close();
            }
        }
        finally {
            // 抛出异常3
            in.close();
        }
    }
}
