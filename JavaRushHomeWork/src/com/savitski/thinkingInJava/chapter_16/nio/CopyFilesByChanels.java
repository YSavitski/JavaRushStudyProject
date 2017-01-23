package com.savitski.thinkingInJava.chapter_16.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by esavitski on 23.01.2017.
 */
public class CopyFilesByChanels {
    private static final int BSIZE = 2048;
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = consoleReader.readLine();
        String fileOut = consoleReader.readLine();
        consoleReader.close();


        FileChannel inChannel = new FileInputStream(fileIn).getChannel(),
        outChannel = new FileOutputStream(fileOut).getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(BSIZE);
        //ByteBuffer buffer = ByteBuffer.allocate(10);
        long startTime = System.currentTimeMillis();
        //int countBuffers = 0;
        while (inChannel.read(buffer) != -1){
            buffer.flip();
            /*while (buffer.hasRemaining()){
                System.out.print((char)buffer.get());
            }*/
            outChannel.write(buffer);
            //System.out.println();
            //countBuffers++;
            buffer.clear();
        }
        long endTime = System.currentTimeMillis();
        inChannel.close();
        outChannel.close();
        System.out.println(/*"count buffers: " + countBuffers + "\n" +*/ "operation time: " + (endTime - startTime));
    }
}
