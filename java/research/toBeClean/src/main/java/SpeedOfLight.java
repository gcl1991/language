package learn_java;

public class SpeedOfLight {
    public static void main(String[] args) {
        int speed = 2_9979_2458;
        int second;
        int distance;

        second = 24*60*60;
        distance = second*speed;
        System.out.println("光在一天中可以传播"+distance+"米");
        System.out.println("光在一天中可以传播"+(long)second*speed+"米");
    }
}
