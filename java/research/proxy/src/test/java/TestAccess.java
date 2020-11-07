import p1.I1;
import p2.C;
import p2.I3;
import p2.I4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestAccess {
    public static void main(String[] args) {
        C c = new C();
        c.m1();
        c.m2();


        InvocationHandler handler  = new H<C>(new C());
        Proxy proxy= (Proxy) Proxy.newProxyInstance(TestAccess.class.getClassLoader(),new Class[] {I1.class,I3.class},handler);
        Proxy proxy2= (Proxy) Proxy.newProxyInstance(TestAccess.class.getClassLoader(),new Class[] {I1.class,I4.class},handler);
        Proxy proxy3= (Proxy) Proxy.newProxyInstance(A.class.getClassLoader(),new Class[] {I1.class,I4.class},handler);
        Proxy proxy4= (Proxy) Proxy.newProxyInstance(Test.class.getClassLoader(),new Class[] {I1.class,I4.class},handler);


        Method[] ms2=proxy.getClass().getDeclaredMethods();
        for(Method m:ms2){
            System.out.println(m);
        }

        System.out.println();
        Method[] ms3=proxy2.getClass().getDeclaredMethods();
        for(Method m:ms3){
            System.out.println(m);
        }
        System.out.println(proxy.hashCode());
        System.out.println(proxy2.hashCode());
        System.out.println(proxy3.hashCode());
        System.out.println(proxy4.hashCode());
        I1 i1 = (I1) proxy;
        I3 i3 = (I3) proxy;
        i1.m1();
    }
}
