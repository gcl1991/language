package examples.ch7;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class JoinTest {
    @Test
    public void test() throws InterruptedException {
        final Thread taskThread = new Thread(() -> {
            long start = System.nanoTime();
            while (true) {
                String threadName = Thread.currentThread().getName();
                long now = System.nanoTime();
                System.out.println(threadName + ":" + (now - start) / 1000_000 + "ms");
            }
        });

        taskThread.start();
        // 1s后如果线程未结束，线程将被杀死
        taskThread.join(TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS));
    }
}
