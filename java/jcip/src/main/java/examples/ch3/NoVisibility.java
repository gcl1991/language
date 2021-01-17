package examples.ch3;

/**
 * NoVisibility
 * <p/>
 * Sharing variables without synchronization
 * 更改程序放大重排序和可见性问题
 *
 * @author Brian Goetz and Tim Peierls
 */

public class NoVisibility {
    private static State state;

    private static class State {
        private boolean ready;
        private int number;
    }

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!state.ready) {
                Thread.yield();
            }
            int number = state.number;
            if (number != 42) {
                System.out.println("number is:" + number);
                System.out.println("read is:" + state.ready);
                System.out.println();
            }
        }
    }

    private static class WriteThread extends Thread {
        @Override
        public void run() {
            state.number = 42;
            state.ready = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            state = new State();
            new WriteThread().start();
            new ReaderThread().start();
            Thread.sleep(10);
        }
    }
}
