package org.fenixsoft.jvm.chapter11;

public class DropLoop {
    public static final int NUM = 15000;

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            calcSum();
        }
    }

    public static long calcSum() {
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += doubleValue(i);
        }
        return sum;
    }

    public static int doubleValue(int i) {
        for (int j = 0; j < 100000; j++) {
        }
        return i * 2;
    }
}