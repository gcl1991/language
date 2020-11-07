package learn_java.array;

import java.util.Arrays;

public class Demo03 {
    public static void main(String[] args){
        int[] a1 = {10,20,30,40,50};
        System.out.println(Arrays.toString(a1));
        a1[0] = 1;
        System.out.println(Arrays.toString(a1));

    }
}
