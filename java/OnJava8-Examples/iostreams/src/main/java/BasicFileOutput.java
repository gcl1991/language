package src.main.java;


import java.io.*;

public class BasicFileOutput {
    static String file = "src.main.java.BasicFileOutput.dat";

    public static void main(String[] args) {
        String content = BufferedInputFile.read("src/main/java/BasicFileOutput.java");
        try (BufferedReader in = new BufferedReader(new StringReader(content));
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            in.lines().forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
}
