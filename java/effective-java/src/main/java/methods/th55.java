package methods;

// 明智审慎地返回 Optional
public class th55 {
    // 1 Optional对缺失值进行建模，标识值可能为空，可读性更强，可代替部分受查异常
    // 2 Optional由对象创建和访问成本，存在性能问题。（用null和受查异常代替,Optional不用于包装类（双层包装问题））
    // 3 Optional一般用作返回值类型，不用于K/V（空值歧义）和不包装容器（空容器可自我表示缺失），实例属性慎用Optional
}
