import java.nio.file.*;

public class FindFile {
    public static void main(String[] args) throws Exception {
        Path test = Paths.get("src/main/resources/images").toAbsolutePath();
        System.out.println(test);
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.{jpg,png,jpeg}");
        Files.walk(test)
                .filter(matcher::matches)
                .forEach(System.out::println);
        System.out.println("***************");

        PathMatcher matcher2 = FileSystems.getDefault()
                .getPathMatcher("glob:*.{jpg,png,jpeg}");
        Files.walk(test)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
        System.out.println("***************");

        Files.walk(test) // Only look for files
                .filter(Files::isRegularFile)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
    }
}
