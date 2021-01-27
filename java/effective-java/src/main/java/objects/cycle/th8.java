package objects.cycle;
import sun.misc.Cleaner;

// 避免使用终结器和清除器
// 1 终结器和清除器的一个缺点是不能保证它们会被立即执行,不能保证它们能运行。
// 2 System.gc/System.runFinalization/System.runFinalizersOnExit可能增加终结器或清除器被运行的几率，但它们不能保证一定运行。
// 3 终结器另一个问题是，在终结期间抛出的未捕获异常将被忽略，同时将finalize方法将终止
//   这可能会使其他对象处于损坏状态,特别是在构造函数和反序列期间，这将导致安全漏洞。
// 4 使用终结器和清除器会严重影响性能。这主要是因为终结器抑制了有效的垃圾收集
// 5 资源应使用AutoCloseable关闭,同时必须跟踪是否已经关闭，如果在对象关闭后调用它们，则必须抛出一个IllegalStateException。
// 6 Cleaner有两个“合理”用途：一种是充当一个安全网,第二个合法使用涉及到与本机对等体的对象
public class th8 {
    // 安全网演示
    // An autocloseable class using a cleaner as a safety net
    // 使用cleaner作为安全网的自动关闭类
    public class Room implements AutoCloseable {
        private static final Cleaner cleaner = Cleaner.create();

        // Resource that requires cleaning. Must not refer to Room!
        // 需要清理的资源，必须是静态类，不能是成员类，防止存储指向外围类引用，阻碍GC
        private static class State implements Runnable {
            int numJunkPiles; // Number of junk piles in this room 这个房间里的垃圾堆数

            State(int numJunkPiles) {
                this.numJunkPiles = numJunkPiles;
            }

            // Invoked by close method or cleaner
            @Override
            public void run() {
                System.out.println("Cleaning room");
                numJunkPiles = 0;
            }
        }

        // The state of this room, shared with our cleanable
        private final State state;
        // Our cleanable. Cleans the room when it’s eligible for gc
        private final Cleaner.Cleanable cleanable;

        public Room(int numJunkPiles) {
            state = new State(numJunkPiles);
            cleanable = cleaner.register(this, state);
        }

        @Override
        public void close() {
            cleanable.clean();
        }
    }
}
