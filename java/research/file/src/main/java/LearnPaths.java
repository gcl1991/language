import java.nio.file.Files;
import java.nio.file.Paths;

public class LearnPaths {
    public static void main(String[] args) {
        System.out.println(Paths.get("xxx","xxx.json"));
        System.out.println(Paths.get("xxx/","xxx.json"));
        System.out.println(Paths.get("xxx//","xxx.json"));
        System.out.println(Paths.get("xxx\\","xxx.json"));
        System.out.println(Paths.get("xxx\\\\","xxx.json"));

    }
}
