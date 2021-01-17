package examples.ch3;

/**
 * CountingSheep
 * <p/>
 * Counting sheep
 *
 * @author Brian Goetz and Tim Peierls
 */
public class CountingSheep {
    static volatile int sheepNum;

    static void tryToSleep() {
        while (true){
            long time = System.nanoTime();
            long ms = time/1000_000;
            long ns = time%1000_000;
            System.out.println(Thread.currentThread().getName()+" read time:"+ms+"ms "+ns+"ns"+" value "+sheepNum);
        }
    }
    // 单个写入线程，多个读取线程，验证volatile变量happen-before规则（写入先于读取）
    // 注意查看时间，若写线程在时间x写入值y，则时间x以后的读线程读取的值应该为y
    public static void main(String[] args) throws InterruptedException {
        Thread write = new Thread(()->{
            while (true){
                long time = System.nanoTime();
                long ms = time/1000_000;
                long ns = time%1000_000;
                System.out.println("write time:"+ms+"ms "+ns+"ns");
                System.out.println("set "+sheepNum+"+1");
                sheepNum++;
            }
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








