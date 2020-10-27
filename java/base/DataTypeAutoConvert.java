package learn_java;

public class DataTypeAutoConvert {
    public static void main(String[] args){
        byte b = 10;
        short s;
        int i;
        long l;
        s = b;
        i = s;
        l = i;

        char c = 'a';
        i = c;
        l = c;

        float f=3.5f;
        double d=f;
        f = b;
        f = s;
        f = i;
        f = l;
        f = c;

        d = b;
        d = s;
        d = i;
        d = c;
    }
}
