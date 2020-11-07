package p2;

import p1.A;
import p1.C;

public class B extends A{
    void access(A o) {
        System.out.println(o.pF);
    }
}
