package general;


// 遵守被广泛认可的命名约定
public class th68 {
    // 1 模块名/包名：小写单词和句点组成，每个组件为单个单词，一般用逆序的组织域名：com.google.common.collect
    // 2 类/接口/枚举/注解：大驼峰：Stream, FutureTask, LinkedHashMap,HttpClient
    // 3 方法/字段/局部变量/形参：小驼峰：remove, groupingBy, getCrc
    // 4 常量字段：全部大写+下划线：MIN_VALUE, NEGATIVE_INFINITY
    // 5 5种泛型参数：任意类型T，集合元素类型E，键类型K和值类型V，异常类型X，返回类型R，任意类型序列T/U/V：T, E, K, V, X, R, U, V, T1, T2
    // 6 可实例化类使用单数名词Path，不可实例化的类使用复数名词Paths，
    // 接口名称以单属名词或以able/ible结尾的形容词：Runnable/Accessible，注解类型命名没有太多约束
    // 7 方法：动词短语，布尔值字段：以is/has开头+名词/形容词短语：isDigit/isEnabled
    // 非布尔函数或属性的方法：get+名词/动词短语:hashCode/getTime/getAttribute/setAttribute
    // 转换对象类型的方法：to+名词toArray/toString，返回对象不同视图的方法：as+名词asList/asType
    // 返回对象相同值的基本类型方法：intValue
    // 8 静态工厂方法：from类型转换Date.from(instant)/of聚合Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING)/valueOf
}
