package exception;


// 优先使用标准异常：沟通学习成本低，避免新类加载
public class th72 {
    // 1 不要直接重用Throwable,Error(继承Throwable),Exception(继承Throwable)、RuntimeException(继承Exception)，对待这些类要像对待抽象类一样。
    // 2 这种重用必须建立在语义的基础上，而不是建立在名称的基础之上。

    // 常用标准异常
    // IllegalArgumentException 非 null 的参数值不正确
    // IllegalStateException 不适合方法调用的对象状态
    // NullPointerException 在禁止使用 null 的情况下参数值为 null
    // IndexOutOfBoundsExecption 下标参数值越界
    // ConcurrentModificationException 在禁止并发修改的情况下，检测到对象的并发修改
    // UnsupportedOperationException 对象不支持用户请求的方法
    // ArithmeticException 算数异常
    // NumberFormatException 数字格式化异常
}
