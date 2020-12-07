import java.nio.file.Files;
import java.nio.file.Paths;

public class LearnFiles {
    public static void main(String[] args) {
        System.out.println(Paths.get("src").toAbsolutePath());
        System.out.println(Files.exists(Paths.get("src")));
        System.out.println(Files.isDirectory(Paths.get("src")));

        System.out.println(Files.exists(Paths.get("src1")));
        System.out.println(Files.isDirectory(Paths.get("src1")));

        System.out.println(Files.isRegularFile(Paths.get("pom.xml")));
        System.out.println(Files.isReadable(Paths.get("pom.xml")));
    }
}
