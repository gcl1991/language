import java.lang.ref.Cleaner;

public class th8 {
    public static void main(String[] args) throws Exception {
        try (Room room1=new Room(7)){
            System.out.println("GoodBye");
        }
        new Room(99);
        System.out.println("Peace Out");
//        System.gc();  // 会增加触发概率
//        System.runFinalization();  // 不会增加触发概率
    }
    public static class Room implements AutoCloseable{
        private final State state;
        private static final Cleaner cleaner= Cleaner.create();
        private final Cleaner.Cleanable cleanable;
        public Room(int numJunkPiles){
            state = new State(numJunkPiles);
            cleanable = cleaner.register(this,state);
        }

        public void close() throws Exception {
            cleanable.clean();
        }

        public static class State implements Runnable{
            int numJunkPiles;
            State(int numJunkPiles){
                this.numJunkPiles  =numJunkPiles;
            }

            @Override
            public void run() {
                System.out.println("Cleaning Room");
                numJunkPiles=0;
            }
        }
    }
}


