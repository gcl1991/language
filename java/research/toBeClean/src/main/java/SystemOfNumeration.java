package learn_java;

public class SystemOfNumeration {
    public static void main(String[] args){
        int i1=100;
        int i2=010;
        int i3=-010;
        int i4=0x10;
        int i5=-0XFf;
        int i6=0b1010; // java7以后支持
        int i7=-0B1010;

        int i8=1_2345_6789;  // java7 以后支持 编译中会将_抛弃
        int i9=0b1000_1110_1010_1111;
        int i10=0b1000__1110____1010_1111; // ok
//        int i11=0b_1000__1110____1010_1111; // error
//        int i12=0b1000__1110____1010_1111_; // error


    }
}
