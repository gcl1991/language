public class FinalFiledExample {
    final int x;
    int y;
    static FinalFiledExample f;

    public FinalFiledExample() {
        x = 3;
        y = 4;
    }

    static void writer() {
        f = new FinalFiledExample();
    }

    static void reader() {
        if (f != null) {
            int i = f.x;
            int j = f.y;
            if (i != 3) {
                System.out.println("i is:" + i);
            }
            if (j != 4) {
                System.out.println("j is:" + j);
            }
        }
    }
}
