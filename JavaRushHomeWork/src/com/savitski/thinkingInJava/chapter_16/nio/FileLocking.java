package com.savitski.thinkingInJava.chapter_16.nio;

import java.io.*;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * Created by esavitski on 24.01.2017.
 */
public class FileLocking {
    private static String fileName = null;
    static{
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName = consoleReader.readLine();
            consoleReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream(fileName);
        FileLock fileLock = fos.getChannel().tryLock();
        if(fileLock != null){
            System.out.println("Locked File");
            System.out.println(fileLock.toString());
            System.out.println(fileLock.isShared());
            TimeUnit.SECONDS.sleep(1);
            fileLock.release();
            System.out.println("Relesed File");
            System.out.println(fileLock.toString());
        } else {
            System.out.println("Unlocked File");
            System.out.println(fileLock.toString());
        }

    }
}
