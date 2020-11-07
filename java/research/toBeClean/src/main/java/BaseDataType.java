package learn_java;
public class BaseDataType{
    public static void main(String[] args){
        System.out.println("learing base data type one");
        System.out.println("byte -128~127:-2^7to2^7-1 8bit 用于文件传输");
        System.out.println("short -32768~32767 2*8bit=16bit");
        System.out.println("int 2.1E9 21亿 4×8bit=32bit 整形默认类型");
        System.out.println("long 9.2E18 8*8bit=64bit");
        System.out.println("float 3.4E38F 6~7位有效数字");
        System.out.println("double 1.7E308 15位有效数字运行速度比float快，cpu优化过针对浮点，默认浮点类型");
        System.out.println("char 2*8=16bit Unicode字符集中单个字符");
        System.out.println("以上7种类型互相兼容可以互相转换");
        System.out.println("boolean True or False");
        System.out.println("除上述8种类型之外其他皆为引用类型");
        char_type();
    }
    private static void int_type(){
        System.out.println("learing base data type two");
        byte b1=127;  // 100为int 此处发生隐含转换 默认数字为int
        byte b2=-128;
//        byte b3=128;
//        byte b4=-129;

        short s1=3_2767;
        short s2=-3_2768;
//        short s3=3_2768;
//        short s4=-3_2769;

        int i1=21_4748_3647;
        int i2=-21_4748_3648;

        long l1=21_4748_3647;
//        long l2=21_4748_3648;// error 21_4748_3648 超过int范围 错误发生在对2147483648解释中
        long l3=21_4748_3648L;// ok
    }
    void float_type(){
//        float f1=0.8;//error 默认数字为double,不能将double 赋给float
        float f1=0.8f;//error 不能将double 赋给float
        f1=1.36E+5f;//1.36×10^5
        f1=1.36E-5f;//1.36*10^-5
        f1=.5f;//不推荐使用

        double d1=0.5;
        d1=1.36E+102;
        d1=1.36E-102;

        d1=0X12.2P2;//尾数12.2是16进制 P表示指数，基数为2 2^2
//        d1=0x1.36e; error

        d1=92446__5656__465.54_65;
    }
    private static void char_type(){
        char c1='a';  // 只能表示单个字符
        char c2=65;  // 互转
        System.out.println(c2);
        /*
        * 转义符
        */
        System.out.println("换行符：\n");
        System.out.println("回车符：\r");
        System.out.println("退格符：\b");
        System.out.println("水平制表符：\t");
        System.out.println("换页符：\f");
        System.out.println("单引号:\'");
        System.out.println("双引号:\"");
        System.out.println("反斜杠:\\");
        System.out.println("八进制:\101");  // 0~377 表示 0～255 256个字符
        System.out.println("十六进制:\u4e01");  // 0～65535 \u0000~\uffff范围内字符
    }
    private static void boolean_type(){
        boolean b1=true;
        boolean b2=false; // 不能和其他类型互转
    }
}