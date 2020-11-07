package learn_java;

public class DataTypeConvert {
    public static void main(String[] args) {
        /*
        * 数据类型自动转换 范围小to大
        */
        byte b=10;
        short s=b;
        int i=b;
        i=s;
        long l=b;
        l=s;
        l=i;

        char c='a';
        i=c;
        l=c;

        float f=3.5f;
        double d=f;
        f=b;
        f=s;
        f=i;
        f=l;
        f=c;

        d=b;
        d=s;
        d=i;
        d=l;
        d=c;

        /*
        * 强制类型转换 大to小
         */
        double d2=3.5;
        float f2=(float)d2;
        int i2=(int)d2;
        i=100;
        byte b2=(byte)i;
        i=128;
        b=(byte)i;
    }
}
