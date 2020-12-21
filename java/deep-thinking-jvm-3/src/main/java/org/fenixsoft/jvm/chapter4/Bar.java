package org.fenixsoft.jvm.chapter4;

/**
 * -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly
 * -Xcomp -XX:CompileCommand=dontinline,*Bar.sum -XX:CompileCommand=compileonly,*Bar.sum
 * -XX:+TraceClassLoading -XX:+LogCompilation -XX:LogFile=logfile.log
 */
public class Bar {
    int a = 1;
    static int b = 2;

    public int sum(int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        new Bar().sum(3);
    }
}
