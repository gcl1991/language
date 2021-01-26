package classes;

public class th24 {
    // 静态成员类优于非静态成员类
    // 1 嵌套类应该只为外部类服务。如果嵌套类在其他环境中有用，那么它应该是顶级类。
    // 2 静态成员类的一个常见用法是作为公有的辅助类，只有与它的外部类一起使用时才有意义。
    // 私有静态成员类的一个常见用法是表示由其外部类表示的对象的组件。
    // 3 非静态成员类的一个常见用法是定义一个Adapter,允许外部类的实例被视为某个不相关类的实例。
    // 例如，Map的集合视图，List的迭代器
    // 4 匿名类的另一个常见用法是实现静态工厂方法,动态创建小型函数对象和进程对象(已被lambda代替)
    // 5 局部类基本不怎么使用
}
