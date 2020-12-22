package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 考虑使用自定义的序列化形式
 * 1 如果对象的物理表示与其逻辑内容相同，则默认的序列化形式可能是合适的，否则不要使用默认序列化（存在4个缺点）。
 * 即使你认为默认的序列化形式是合适的，你通常也必须提供 readObject 方法来确保不变性和安全性。
 * 2 writeObject 做的第一件事是调用 defaultWriteObject , readObject 做的第一件事是调用 defaultReadObject
 */
public class th87 {

}

// 1 如果对象的物理表示与其逻辑内容相同
class Name implements Serializable {
    /**
     * Last name. Must be non-null.
     *
     * @serial
     */
    private final String lastName;
    /**
     * First name. Must be non-null.
     *
     * @serial
     */
    private final String firstName;
    /**
     * Middle name, or null if there is none.
     *
     * @serial
     */
    private final String middleName;

    public Name() {
        firstName = "";
        middleName = "";
        lastName = "";
    }
}

// 1 具有合理的自定义序列化格式的StringList
final class StringList implements Serializable {
    private transient int size = 0;
    private transient Entry head = null;
    // 不再可序列化！

    private static class Entry {
        String data;
        Entry next;
        Entry previous;
    }

    // Appends the specified string to the list
    // 将指定的字符串追加到列表
    public final void add(String s) {

    }

    /**
     * Serialize this {@code StringList} instance.
     * 序列化此{@code StringList}实例。
     *
     * @serialData The size of the list (the number of strings
     * it contains) is emitted ({@code int}), followed by all of
     * its elements (each a {@code String}), in the proper
     * sequence.
     * @serialData 发布列表(包含的字符串数)的大小({ @ code int }),
     * 紧跟其所有元素(each {@code String}), 按适当的顺序。
     */
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);
        // Write out all elements in the proper order.
        // 按照正确的顺序写出所有元素。
        for (Entry e = head; e != null; e = e.next)
            s.writeObject(e.data);
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();
        // Read in all elements and insert them in list
        // 读取所有元素并将它们插入列表
        for (int i = 0; i < numElements; i++)
            add((String) s.readObject());
    }
}
