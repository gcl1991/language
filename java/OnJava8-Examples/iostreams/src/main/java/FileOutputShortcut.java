package src.main.java;

import java.io.*;

public class FileOutputShortcut {
    static String file = "src.main.java.FileOutputShortcut.dat";

    public static void main(String[] args) {
        String content = BufferedInputFile.read("src/main/java/FileOutputShortcut.java");
        try (BufferedReader in = new BufferedReader(new StringReader(content));
             // Here's the shortcut:
             PrintWriter out = new PrintWriter(file)) {
            in.lines().forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(BufferedInputFile.read(file));
    }
}
