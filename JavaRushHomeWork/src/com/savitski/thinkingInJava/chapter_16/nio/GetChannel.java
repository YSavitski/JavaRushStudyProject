package com.savitski.thinkingInJava.chapter_16.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by esavitski on 20.01.2017.
 */
public class GetChannel {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();

        FileChannel fc = new FileOutputStream(fileName).getChannel();


        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        fc = new RandomAccessFile(fileName, "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("New text".getBytes()));
        fc.close();

        fc = new FileInputStream(fileName).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()){
            System.out.print((char)buff.get());
        }
        fc.close();


    }
}
