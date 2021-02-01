package src.main.java;

import java.io.*;
import java.util.stream.*;


public class BufferedInputFile {

    public static void main(String[] args) {
        System.out.print(read("src/main/java/BufferedInputFile.java"));
    }

    public static String read(String filename) {
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            return in.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
