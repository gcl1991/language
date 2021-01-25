package classes;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 组合优于继承
public class th18 {
    // 1 包内继承是安全的，因为在同一人的控制下，专门为了继承而设计，且有文档说明的类继承也是安全的，其他则是危险的
    // 2 继承属于白盒复用，打破了封装性，子类将受到父类自用性的影响
    // 3 父类在以后的版本中增加新方法，有可能会破坏子类的一致性约束，以及出现签名冲突或意外的重写
    // 4 使用组合与转发代替继承，避免父类影响
    // 5 包装类不适合回调框架，对性能和内存基本无影响
    // 6 继承前请慎重考虑，是否真正属于父子关系，父类是否有缺陷，如果只需要部分父类功能，请使用组合，避免多余的功能破坏子类。


    // Broken - Inappropriate use of inheritance!
    // 继承使用不当！
    public static class InstrumentedHashSet<E> extends HashSet<E> {
        // The number of attempted element insertions
        // 尝试插入元素的次数
        private int addCount = 0;

        public InstrumentedHashSet() {
        }

        public InstrumentedHashSet(int initCap, float loadFactor) {
            super(initCap, loadFactor);
        }

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount += c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }
    }

    // 可重复使用的转发类
    public static class ForwardingSet<E> implements Set<E> {
        private final Set<E> s;

        public ForwardingSet(Set<E> s) {
            this.s = s;
        }

        @Override
        public void clear() {
            s.clear();
        }

        @Override
        public boolean contains(Object o) {
            return s.contains(o);
        }

        @Override
        public boolean isEmpty() {
            return s.isEmpty();
        }

        @Override
        public int size() {
            return s.size();
        }

        @Override
        public Iterator<E> iterator() {
            return s.iterator();
        }

        @Override
        public boolean add(E e) {
            return s.add(e);
        }

        @Override
        public boolean remove(Object o) {
            return s.remove(o);
        }

        @Override
        public boolean containsAll(Collection<?> c) {

            return s.containsAll(c);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return s.addAll(c);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return s.removeAll(c);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return s.retainAll(c);
        }

        @Override
        public Object[] toArray() {
            return s.toArray();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return s.toArray(a);
        }

        @Override
        public boolean equals(Object o) {
            return s.equals(o);
        }

        @Override
        public int hashCode() {
            return s.hashCode();
        }

        @Override
        public String toString() {
            return s.toString();
        }
    }

    // 包装器类-使用组合代替继承
    // Wrapper class - uses composition in place of inheritance
    public static class InstrumentedSet<E> extends ForwardingSet<E> {
        private int addCount = 0;

        public InstrumentedSet(Set<E> s) {
            super(s);
        }

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount += c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }
    }
}

