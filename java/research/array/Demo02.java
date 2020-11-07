package learn_java.array;
import java.util.Arrays;

public class Demo02 {
    public static void main(String[] args){
        int[] a1 = new int[] {1,2,3,4,5};
        System.out.println(Arrays.toString(a1));
        int[] a2 = {10,20,30};
        System.out.println(Arrays.toString(a2));
        System.out.println(a1.length);
        System.out.println(a2.length);

//        int[] a3=new int[2147483647];
        int[] a3=new int[0]; // 负值 编译通过，但是运行会出现错误
        System.out.println(Arrays.toString(a3));
    }
}
