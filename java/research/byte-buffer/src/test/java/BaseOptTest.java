import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class BaseOptTest {
    int capacity = 10;
    byte[] bytes = {1,2,3,4,5,6,7,8};
    @Test
    public void testConstructor(){
        ByteBuffer buffer1 = ByteBuffer.allocate(capacity);
        BaseOpt.printDetailInfo(buffer1);

        ByteBuffer buffer2 = ByteBuffer.allocateDirect(capacity);
        BaseOpt.printDetailInfo(buffer2);

        ByteBuffer buffer3 = ByteBuffer.wrap(bytes,2,4);
        BaseOpt.printDetailInfo(buffer3);
        System.out.println(Arrays.toString(bytes));
    }

    @Test
    public void testClear(){
        ByteBuffer buffer1 = ByteBuffer.wrap(bytes,2,4);
        BaseOpt.printDetailInfo(buffer1);
        buffer1.clear();
        BaseOpt.printDetailInfo(buffer1);
    }

    @Test
    public void testFlip(){
        ByteBuffer buffer1 = ByteBuffer.wrap(bytes,2,4);
        BaseOpt.printDetailInfo(buffer1);
        buffer1.flip();
        BaseOpt.printDetailInfo(buffer1);
    }

    @Test
    public void testRewind(){
        ByteBuffer buffer1 = ByteBuffer.wrap(bytes,2,4);
        BaseOpt.printDetailInfo(buffer1);
        buffer1.rewind();
        BaseOpt.printDetailInfo(buffer1);
    }

    @Test
    public void testMark(){
        ByteBuffer buffer1 = ByteBuffer.wrap(bytes,2,4);
        BaseOpt.printDetailInfo(buffer1);
        buffer1.mark();
        BaseOpt.printDetailInfo(buffer1);
    }

    @Test
    public void testReset(){
        ByteBuffer buffer1 = ByteBuffer.wrap(bytes,2,4);
        BaseOpt.printDetailInfo(buffer1);
        buffer1.reset();
        BaseOpt.printDetailInfo(buffer1);
    }
}
