package exception;

// 只针对异常的情况下才使用异常
public class th69 {
    // 1 异常应该只用于异常的情况下, 不应用于正常的程序控制流程, 不强迫客户端为了正常的控制流程而使用异常。

    // 状态测试方法：不适合并发/测试代价太高情况，可读性好
    // optional返回值：缺乏描述性
    // 可识别的返回值：容易导致忘记检查识别码，引起BUG
}