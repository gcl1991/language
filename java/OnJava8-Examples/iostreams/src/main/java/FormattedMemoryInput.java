package src.main.java;

import java.io.*;

public class FormattedMemoryInput {
    public static void main(String[] args) {
        String content = BufferedInputFile.read("src/main/java/FormattedMemoryInput.java");
        try (DataInputStream in = new DataInputStream(new ByteArrayInputStream(content.getBytes()))) {
            while (true) {
                System.out.write((char) in.readByte());
            }
        } catch (EOFException e) {
            System.out.println("\nEnd of stream");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
