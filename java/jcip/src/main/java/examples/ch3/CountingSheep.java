package examples.ch3;

import java.util.Random;

/**
 * CountingSheep
 * <p/>
 * Counting sheep
 *
 * @author Brian Goetz and Tim Peierls
 */
public class CountingSheep {
    static int sheepNum1;
    static int sheepNum2;
    static volatile boolean asleep;
    static Random random = new Random();

    static void tryToSleep() {
        while (true) {
            if (asleep) {
                if (sheepNum1 != sheepNum2){
                    System.out.println(sheepNum1==sheepNum2);
                }
                break;
            }
        }
    }

    // 单个写入线程，多个读取线程，验证volatile变量happen-before规则（写入先于读取）
    // 注意查看时间，若写线程在时间x写入值y，则时间x以后的读线程读取的值应该为y
    public static void main(String[] args) throws InterruptedException {
        while (true){
            Thread write = new Thread(() -> {
                sheepNum1++;
                sheepNum2++;
                asleep = true;
            });
            Thread read1 = new Thread(CountingSheep::tryToSleep);
            Thread read2 = new Thread(CountingSheep::tryToSleep);
            read1.setName("Thread1");
            read2.setName("Thread2");
            write.start();
            read1.start();
            read2.start();
        }
    }


}








