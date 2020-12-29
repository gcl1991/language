package serialization;


import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

// 考虑用序列化代理代替序列化实例
// 优点：1 可以阻止伪字节流的攻击。2 内部字段的盗用攻击。3 支持不可变序列化类。4 可以动态控制更改反序列化对象
// 缺点：1 不能与可以被客户端拓展的类兼容。2 它也不能与对象图中包含循环的某些类兼容。3 会降低性能。
public class th90 {
    public static class Period implements Serializable{
        private final Date start;
        private final Date end;

        public Period(Date start, Date end) {
            if (start.compareTo(end) > 0) {
                throw new IllegalArgumentException(start + " after " + end);
            }
            this.start = start;
            this.end = end;
        }

        // writeReplace method for the serialization proxy pattern
        private Object writeReplace() {
            return new SerializationProxy(this);
        }

        // readObject method for the serialization proxy pattern
        private void readObject(ObjectInputStream stream) throws InvalidObjectException {
            throw new InvalidObjectException("Proxy required");
        }

        // Serialization proxy for Period class
        private static class SerializationProxy implements Serializable {
            private final Date start;
            private final Date end;
            SerializationProxy(Period p) {
                this.start = p.start;
                this.end = p.end;
            }
            private static final long serialVersionUID = 234098243823485285L;
            // Any number will do (Item 87)
            // readResolve method for Period.SerializationProxy
            private Object readResolve() {
                // Uses public constructor
                return new Period(start, end);
            }
        }
    }


}
