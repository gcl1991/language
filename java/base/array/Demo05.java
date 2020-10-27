package learn_java.array;

import java.util.Arrays;

public class Demo05 {
    public static void main(String[] args) {
        int[][] a1 = new int[3][4];
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a1[0]));

        a1[1][2] = 256;
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a1[0]));

        int[][] a2 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(a2));
        int[][] a3 = {{1,2},{3,4,5},{6,7,8,9}};
        System.out.println(Arrays.toString(a3));
        int[][] a4 = {{1,2,3,4,5,6,7,8,9}};
        System.out.println(Arrays.toString(a4));



    }
}
