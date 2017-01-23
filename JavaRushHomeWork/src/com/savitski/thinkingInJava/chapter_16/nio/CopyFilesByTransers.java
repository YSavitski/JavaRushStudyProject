package com.savitski.thinkingInJava.chapter_16.nio;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * Created by esavitski on 23.01.2017.
 */
public class CopyFilesByTransers {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = consoleReader.readLine();
        String fileOut = consoleReader.readLine();

        FileChannel inChannel = new FileInputStream(fileIn).getChannel(),
                    outChannel = new FileOutputStream(fileOut).getChannel();

        long startTime = System.currentTimeMillis();
        inChannel.transferTo(0, inChannel.size(), outChannel);
        //outChannel.transferFrom(inChannel, 0, inChannel.size());
        long endTime = System.currentTimeMillis();
        System.out.println("operation time: " + (endTime - startTime));
    }
}
