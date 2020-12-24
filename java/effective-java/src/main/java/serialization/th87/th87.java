package serialization.th87;

/**
 * 考虑使用自定义的序列化形式
 * 1 如果对象的物理表示与其逻辑内容相同，则默认的序列化形式可能是合适的，否则不要使用默认序列化（存在4个缺点）。
 * 即使你认为默认的序列化形式是合适的，你通常也必须提供 readObject 方法来确保不变性和安全性。
 * 2 writeObject做的第一件事是调用defaultWriteObject,readObject做的第一件事是调用defaultReadObject,以保留向后和向前兼容性
 * 3 哈希序列化与反序列化不能保证反序列后生成原始对象的无差错副本(哈希函数的桶位)
 * 4 transient：派生字段，与JVM的一个特定运行相关联，比如表示指向本机数据结构指针的long字段，
 * non-transient必须是对象逻辑状态的一部分，当反序列化实例时transient字段将初始化为默认值。
 * 如果这些transient字段的值都是不可接受的，则必须提供一个 readObject方法，然后将transient字段恢复为可接受的值
 * 5 线程安全的类需要对writeObject等方法进行同步
 * 6 无论选择哪种序列化形式，都要在编写的每个可序列化类中声明显式的序列版本UID
 */
public class th87 {
}


