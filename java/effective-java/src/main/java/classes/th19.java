package classes;


import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

// 要么设计继承并提供文档说明，要么禁用继承
// 1 必须为可继承方法编写实现文档：说明自用模型，即指明方法调用哪些可重写方法，以何种顺序调用的，以及每次调用的结果又是如何影响后续处理，
// 同时这个类的整个生命周期中都必须遵守该文档，如果没有做到，子类就会依赖父类的实现细节，如果父类的实现发生了变化，它就有可能遭到破坏。
// 2 类必须以精心挑选的protected方法的形式，提供适当的钩子，以便进入其内部工作中，使程序员能够编写出更加有效的子类
// 3 测试为继承而设计的类的唯一方法是编写子类。 如果你忽略了一个关键的受保护的成员，试图编写一个子类将会使得遗漏痛苦地变得明显。
// 相反，如果编写的几个子类，而且没有一个使用受保护的成员，那么应该将其设为私有。 经验表明，三个子类通常足以测试一个可继承的类。
// 4 构造方法绝不能直接或间接调用可重写的方法,因为父类构造器会先于子类构造器运行
// 5 除抽象类/接口骨架实现之外的普通类应禁止继承，如果非要继承，可以使用私有帮助函数机械消除自用性
// 6 clone/readObject都不应直接或间接调用可重写的方法，同时若存在readResolve或writeReplace方法，此两个方法不应是私有的
public class th19 {
    public static class Father1<E>{

        public Father1() {
        }

        public boolean add(E e) {
            return true;
        }

        public boolean addAll(Collection<? extends E> c) {
            for (E i:c){
                add(i);
            }
            return true;
        }

    }

    public static class Son1<E> extends Father1<E>{
        private int addCount = 0;

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount+=c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }
    }


    public static class Father2<E>{

        public Father2() {
        }

        public boolean add(E e) {
            addHelp(e);
            return true;
        }

        public boolean addAll(Collection<? extends E> c) {
            for (E i:c){
                addHelp(i);
            }
            return true;
        }

        private boolean addHelp(E e){
            return true;
        }

    }

    public static class Son2<E> extends Father2<E>{
        private int addCount = 0;

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount+=c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }
    }

    public static class Super {
        // Broken - constructor invokes an overridable method
        public Super() {
            overrideMe();
        }
        public void overrideMe() {
        }
    }

    public final static class Sub extends Super {
        // Blank final, set by constructor
        private final Instant instant;
        Sub() {
            instant = Instant.now();
        }
        // Overriding method invoked by superclass constructor
        @Override
        public void overrideMe() {
            System.out.println(instant);
        }
    }

    public final static class CloneDemo implements Cloneable{
        int intF = 10;
        String stringF = "a";
        int[] intArray = {1,2,3};
        Integer integerF = 10;
        Date dateF = new Date();

        @Override
        protected CloneDemo clone() throws CloneNotSupportedException {
            CloneDemo n = (CloneDemo) super.clone();
            return n;
        }

        @Override
        public String toString() {
            return "CloneDemo{" +
                    "intF=" + intF +
                    ", stringF='" + stringF + '\'' +
                    ", intArray=" + Arrays.toString(intArray) +
                    ", integerF=" + integerF +
                    ", dateF=" + dateF +
                    '}';
        }
    }
}
