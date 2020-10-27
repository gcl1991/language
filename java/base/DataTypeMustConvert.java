package learn_java;

public class DataTypeMustConvert {
    public static void main(String[] args){
        // 强制类型转换
        double d = 3.5;
//    float f = d;  // this error
        float f = (float)d;
        int i = (int)d;  // 会丢弃小数部分,3.5 to 3
        byte b = (byte)i;

        i = 100;
        b = (byte)i;
        System.out.println(b);

        i = 128;
        b = (byte) i;
        System.out.println(b);
        System.out.println(b%256);
        // 自动类型提升
        short s=1;
        char c = 'a';
        long l = 1;

//        float r1 = b*i+(f+d); // error
        double r1 = b*i+(f+d);
        int r2 = s+b+c; // 所有转为int
    }
}
