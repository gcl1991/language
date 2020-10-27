package examples.ch2;

import org.junit.Test;

public class LockTest {
    long x = 0;

    /**
     * 两线程持同一把锁，对同一变量进行保护
     * t1线程将x从0增加到500，t2线程将x从500增加到1000
     */
    @Test
    public void testLockA() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (this) {
                for (int i = 0; i < 500; i++) {
                    x++;
                    System.out.println(Thread.currentThread().getName() + ":" + x);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (this) {
                for (int i = 0; i < 500; i++) {
                    x++;
                    System.out.println(Thread.currentThread().getName() + ":" + x);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join(); // 必须让线程执行完毕，否则主线程退出t1/t2将来不及执行完毕
        t2.join();
    }

    /**
     * t1线程持有锁对a变量进行访问，其他线程可以不使用锁或使用其他锁对此变量进行更改，将无法保证程序正确性
     */
    @Test
    public void testLockB() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (this) {
                for (int i = 0; i < 500; i++) {
                    x++;
                    System.out.println(Thread.currentThread().getName() + ":" + x);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                x++;
                System.out.println(Thread.currentThread().getName() + ":" + x);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
