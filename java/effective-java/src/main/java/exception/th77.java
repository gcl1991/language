package exception;



import java.util.concurrent.*;
import java.util.logging.Logger;

public class th77 {
    public static final Logger log=Logger.getGlobal();
    ExecutorService exec = Executors.newCachedThreadPool();

    // 不要忽略异常，忽略异常要用充足的理由，同时不影响程序的正确性，同时不会隐藏问题。
    public void ignore() {
        Future<Integer> f = exec.submit(() -> 1);
        // 默认值: 保证足以适合任何map
        int numColors = 4;
        try {
            numColors = f.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException ignored) {
            // 使用默认: 最小的着色是可取的, 但部署必须的
            log.warning(ignored.toString());
        }
    }
}
