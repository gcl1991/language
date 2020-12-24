package serialization;

/**
 * 非常谨慎地实现 Serializable
 * 1 类中私有的包以及私有实例字段将成为其导出API的一部分,需要使用@serial对私有字段进行文档化,以及@serialData对writeObject等方法文档化。
 * 2 反序列化都是一个隐藏构造函数,依赖于默认的反序列化机制,会让对象轻易地遭受不变性破坏和非法访问
 * 3 各版本之间序列化-反序列化测试负担较重
 * 4 为继承而设计的类很少情况适合实现序列化，其存在2个风险，同时会给扩展类或实现接口的任何人带来很大的负担。
 * 5 内部类不应该实现序列化，其合成字段的默认序列化形式是不确定的。
 * */
public class th86 {
}
