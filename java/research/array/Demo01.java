package learn_java.array;

import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args){
        byte[] a1 = new byte[5];
        short[] a2 = new short[5];
        int[] a3 = new int[5];
        long[] a4 = new long[5];

        float[] a5 = new float[5];
        double[] a6 = new double[5];

        char[] a7 = new char[5];

        boolean[] a8 = new boolean[5];

        String[] a9 = new String[5];

        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
        System.out.println(Arrays.toString(a4));
        System.out.println(Arrays.toString(a5));
        System.out.println(Arrays.toString(a6));
        System.out.println(Arrays.toString(a7));
        System.out.println(Arrays.toString(a8));
        System.out.println(Arrays.toString(a9));

        int a10[] = new int[10];// 可读性不强 不如 int[]区分高
        System.out.println(Arrays.toString(a10));

    }
}
