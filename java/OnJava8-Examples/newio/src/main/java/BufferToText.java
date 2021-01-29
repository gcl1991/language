package src.main.java;// newio/src.main.java.BufferToText.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Converting text to and from ByteBuffers

import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.*;

public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        try (FileChannel fc = new FileOutputStream("data2.txt").getChannel()) {
            // 将以平台默认编码utf-8写入
            fc.write(ByteBuffer.wrap("Some text".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        try (FileChannel fc = new FileInputStream("data2.txt").getChannel()) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        buff.flip();
        // Doesn't work:因为JAVA使用UTF-16解码
        System.out.println(buff.asCharBuffer());


        // Decode using this system's default Charset:
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buff));


        // Encode with something that prints:
        try (FileChannel fc = new FileOutputStream("data2.txt").getChannel()) {
            fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Now try reading again:
        buff.clear();
        try (FileChannel fc = new FileInputStream("data2.txt").getChannel()) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        buff.flip();
        System.out.println(buff.asCharBuffer());


        // Use a CharBuffer to write through:将以UFT-16编码方式写入
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text");
        try (FileChannel fc = new FileOutputStream("data2.txt").getChannel()) {
            fc.write(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Read and display:
        buff.clear();
        try (FileChannel fc = new FileInputStream("data2.txt").getChannel()) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}
/* Output:
????
Decoded using windows-1252: Some text
Some text
Some textNULNULNUL
*/
