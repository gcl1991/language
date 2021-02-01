package src.main.java;

import java.io.*;

public class TestEOF {
  public static void main(String[] args) {
    String file = "src/main/java/TestEOF.java";
    try(DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      while(in.available() != 0) {
        System.out.write(in.readByte());
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
}
