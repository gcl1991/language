通过实现Serializable接口，可以启用类的可序列化性。未实现此接口的类将不可进行序列化和反序列化。可序列化类的所有子类型都是可序列化的。序列化接口没有方法或字段，仅用于标识可序列化。

为了将不可序列化类A的子类型B进行序列化，父A类型必须具有可访问的无参数构造器以初始化类A的状态。且该子类型B仅可以保存和恢复超类型的public, protected和（如果可访问）package fields。除此之外，声明一个可序列化的类是错误的。

反序列化期间，将使用该类的公共或受保护的无参数构造函数初始化非序列化类的字段。无参数构造函数对可序列化的子类必须是可访问的。子类将从流中还原这些非序列化类的字段。

在遍历图形时，可能会遇到不支持Serializable接口的对象。在这种情况下，将抛出NotSerializableException并标识不可序列化对象的类。

在序列化和反序列化过程中需要特殊处理的类必须实现具有以下确切签名的特殊方法：
```java
private void writeObject(java.io.ObjectOutputStream out)
    throws IOException
private void readObject(java.io.ObjectInputStream in)
    throws IOException, ClassNotFoundException;
private void readObjectNoData()
    throws ObjectStreamException;
```
writeObject方法负责为其特定类写入对象的状态，以便相应的readObject方法可以还原它，保存对象字段的默认机制可以通过调用out.defaultWriteObject来实现。这个方法不需要去关心状态本身是属于超类还是子类，通过将各个字段写入ObjectOutputStream来保存状态，使用writeObject方法或通过使用DataOutput支持的原始数据类型的方法。

readObject方法负责从流中读取并还原类字段。它可以调用in.defaultReadObject来调用还原对象的非静态和非瞬态字段的默认机制。defaultReadObject方法使用流中的信息为流中保存的对象的字段分配当前对象中相应命名的字段。这处理了类中出现添加新字段的情况。这个方法不需要关注状态本身属于其超类或子类。

通过使用writeObject方法将单个字段写入ObjectOutputStream或使用DataOutput支持的原始数据类型的方法来保存状态。

如果序列化流未将给定类列为要反序列化的对象的超类，则readObjectNoData方法负责为其特定类初始化对象的状态。在接收方使用与发送方不同的反序列化实例类的版本的情况下，接收方的版本扩展了发送方的版本未扩展的类，可能会发生这种情况，如果序列化流已被篡改，也会发生这种情况。因此，readObjectNoData对于正确初始化反序列化的对象很有用。尽管原始流“充满敌意”或不完整

需要指定替代对象的可序列化类，在将对象写入流时，应该使用确切的签名实现此特殊方法
ANY-ACCESS-MODIFIER Object writeReplace() throws ObjectStreamException;

如果该writeReplace方法存在，则可以通过序列化调用，并且可以从正在序列化的对象的类中定义的方法访问该方法。因此这个方法可以是 private, protected and package-private 的，子类访问这个方法遵循Java可访问性规则。

从流中读取替代实例时需要指定替代的类，应该使用确切的签名实现此特殊方法。
ANY-ACCESS-MODIFIER Object readResolve() throws ObjectStreamException;

此readResolve方法遵循与writeReplace相同的调用规则和可访问性规则。

序列化运行时与每个可序列化的类关联一个版本号，叫做serialVersionUID，在反序列化过程中使用它来验证序列化对象的发送者和接收者是否已为该对象加载了与序列化兼容的类。如果接收者已为该对象加载了一个与相应发送者类具有不同的serialVersionUID的类，然后反序列化将导致InvalidClassException。

可序列化的类可以通过声明一个名称为“ serialVersionUID”的字段来显式声明其自己的serialVersionUID，该字段必须是 static, final, long

ANY-ACCESS-MODIFIER static final long serialVersionUID = 42L;

如果可序列化的类未明确声明serialVersionUID，那么序列化运行时将根据该类的各个方面为该类计算默认的serialVersionUID值，如Java™对象序列化规范中所述。但是，强烈建议所有可序列化的类显式声明serialVersionUID值，由于默认的serialVersionUID计算对类细节高度敏感，而类细节可能会根据编译器的实现而有所不同，因此可能会在反序列化期间导致意外的InvalidClassExceptions。

因此，为了保证不同Java编译器实现之间的serialVersionUID值一致，可序列化的类必须声明一个显式的serialVersionUID值。强烈建议在可能的情况下，显式serialVersionUID声明使用private修饰符，由于此类声明仅适用于当前声明的类，因此serialVersionUID字段作为继承成员没有用，数组类不能声明显式的serialVersionUID，因此它们始终具有默认的计算值，但是对于数组类，不需要匹配serialVersionUID值。