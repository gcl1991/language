package serialization;

import java.io.*;
import java.util.Date;

/**
 * 保护性的编写readObject方法
 * 1 约束性检查：readObject方法实际上相当于另外一个公有的构造器，必须检查其参数的有效性，避免攻击者创建无效的Period实例。
 * 2 保护性拷贝：可序列化的不可变类，如果它包含了私有的可变字段，那么在它的 readObject 方法中，必须要对这些字段进行保护性拷贝，避免攻击者伪造字节流，创建可变的实例。
 * 3 外部方法：readObject无论是直接方法还是间接方法，都不要调用类中任何可被覆盖的方法。
 */
public class th88 {
    // Immutable class that uses defensive copying
    public final static class Period implements Serializable {
        private Date start;
        private Date end;

        /**
         * @param start the beginning of the period
         * @param end   the end of the period; must not precede start
         * @throws IllegalArgumentException if start is after end
         * @throws NullPointerException     if start or end is null
         */
        public Period(Date start, Date end) {
            this.start = new Date(start.getTime());
            this.end = new Date(end.getTime());
            if (this.start.compareTo(this.end) > 0)
                throw new IllegalArgumentException(start + " after " + end);
        }

        public Date start() {
            return new Date(start.getTime());
        }

        public Date end() {
            return new Date(end.getTime());
        }

        public String toString() {
            return start + " - " + end;
        }

        // readObject method with validity checking - insufficient!
        // 具有有效性检查的readObject方法-不够！
        // readObject method with defensive copying and validity checking
        // readObject方法，具有防御复制和有效性检查
        private void readObject(ObjectInputStream s)
                throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            // Defensively copy our mutable components
            // 防御性地复制我们的可变组件
            start = new Date(start.getTime());
            end = new Date(end.getTime());
            // Check that our invariants are satisfied
            // 检查我们的不变量是否满足
            if (start.compareTo(end) > 0)
                throw new InvalidObjectException(start + " after " + end);
        }
    }

    public static class MutablePeriod {
        // A period instance
        public final Period period;
        // period's start field, to which we shouldn't have access
        public final Date start;
        // period's end field, to which we shouldn't have access
        public final Date end;

        public MutablePeriod() {
            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(bos);
                // Serialize a valid Period instance
                // 序列化有效的Period实例
                out.writeObject(new Period(new Date(), new Date()));
                /*
                 * Append rogue "previous object refs" for internal
                 * Date fields in Period. For details, see "Java
                 * Object Serialization Specification," Section 6.4.
                 * 附加恶意“先前对象引用”Period内部日期字段。
                 * 有关详细信息，请参见“ Java对象序列化规范”的第6.4节。
                 */
                byte[] ref = {0x71, 0, 0x7e, 0, 5};
                // Ref #5
                bos.write(ref);
                // The start field
                ref[4] = 4;
                // Ref # 4
                bos.write(ref);
                // The end field
                // Deserialize Period and "stolen" Date references
                // 反序列化Period和“被盗”的日期引用
                ObjectInputStream in = new ObjectInputStream(
                        new ByteArrayInputStream(bos.toByteArray()));
                period = (Period) in.readObject();
                start = (Date) in.readObject();
                end = (Date) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new AssertionError(e);
            }
        }
    }
}

