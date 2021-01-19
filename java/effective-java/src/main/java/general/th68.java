package general;

public class th68 {
    // 遵守被广泛认可的命名约定
    // 1 模块名/包名：小写单词和句点组成，每个组件为单个单词，一般用逆序的组织域名：com.google.common.collect
    // 2 类/接口/枚举/注解：大驼峰,名词短语
    //（1）可实例化类使用单数名词Path；不可实例化的类使用复数名词Paths，
    //（2）接口名称以单属名词或以able/ible结尾的形容词：Runnable/Accessible
    // 3 方法：小驼峰，动词短语
    //（1）返回布尔值：以is/has开头+名词/形容词短语：isDigit/isEnabled
    //（2）返回非布尔值：get+名词，动词短语：hashCode/getTime
    //（3）转换对象类型：to+名词：toArray/toString
    //（4）对象不同视图：as+名词：asList/asType
    //（5）返回对象相同值的基本类型方法：intValue
    //（6）静态工厂方法：从其他转换from/of/valueOf，实例化对象instance/getInstance/create/newInstance，转为其他类型getType/newType/type
    // 4 字段/局部变量/形参：小驼峰，常量字段：全部大写+下划线
    // 5 泛型参数：任意类型T，集合元素类型E，键类型K和值类型V，异常类型X，返回类型R，任意类型序列T/U/V：T, E, K, V, X, R, U, V, T1, T2
}
