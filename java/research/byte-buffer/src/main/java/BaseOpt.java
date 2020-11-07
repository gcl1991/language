import java.nio.ByteBuffer;
import java.util.Arrays;
import static java.lang.System.out;

public class BaseOpt {

    public static void printDetailInfo(ByteBuffer buffer) {
        out.println(String.format("直接字节缓冲区:%s",buffer.isDirect()));
        out.println(String.format("是否只读：%s",buffer.isReadOnly()));
        out.println(String.format("存储方式:%s",buffer.order()));
        out.println("容量: "+buffer.capacity());
        out.println("位置: "+buffer.position());
        out.println("界限: "+buffer.limit());
        out.println("剩余: "+buffer.remaining());
        if(buffer.hasArray()){
            out.println("数组访问: "+Arrays.toString(buffer.array()));
            out.println("偏移量: "+buffer.arrayOffset());
        }else {
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            out.println("不支持数组访问: "+Arrays.toString(bytes));
            out.println("不支持偏移量");
        }
        out.println();
    }
}
