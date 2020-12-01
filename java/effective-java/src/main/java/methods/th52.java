package methods;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

// 明智审慎地使用重载（避免重载和重写混淆，构造器无重载和重写混淆）
public class th52 {
    // 1 永远不要导出两个具有相同参数数量且参数协变的重载(避免混淆/依靠强制转换进行方法选择/方法签名不一致的重载是可以的),如果重载，那么应该确保在传递相同的参数时，所有重载的行为都是相同的。
    // 2 注意自动装箱引起的重载set.remove()和list.remove()
    // 3 不要在相同参数位置重载采用不同函数式接口的方法。 不同的函数式接口并没有根本不同。
}
