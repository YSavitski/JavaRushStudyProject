package com.savitski.thinkingInJava.chapter_16.compression;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.*;

/**
 * Created by esavitski on 24.01.2017.
 */
public class ZipCompress {

    private static List<String> files = new ArrayList<>();
    static{
        BufferedReader consoleReasder = new BufferedReader(new InputStreamReader(System.in));
        String newFileName = null;
        try {
            while(!(newFileName = consoleReasder.readLine()).equals("exit")){
                files.add(newFileName);
            }
            consoleReasder.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(new File("testComp.zip"));
        CheckedOutputStream checkSumOut = new CheckedOutputStream(fileOutputStream, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(checkSumOut);
        BufferedOutputStream buffOutStream = new BufferedOutputStream(zos);
        zos.setComment("A test of Java Zipping");

        for (String fileName:
             files) {
            System.out.println("Writing file " + fileName);
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            zos.putNextEntry(new ZipEntry(fileName));
            int c;
            while ((c=in.read()) != -1){
                buffOutStream.write(c);
            }
            in.close();
            buffOutStream.flush();
        }
        buffOutStream.close();

        // Checksum valid only after the file has been closed!
        /*System.out.println("CheckSum: " + checkSumOut.getChecksum().getValue());
        System.out.println("Reading files...");
        FileInputStream fileInStream = new FileInputStream("testComp.zip");
        CheckedInputStream checkSumIn = new CheckedInputStream(fileInStream, new Adler32());
        ZipInputStream zis = new ZipInputStream(checkSumIn);
        BufferedInputStream buffInStream = new BufferedInputStream(zis);
        ZipEntry zipEntry = null;
        while((zipEntry = zis.getNextEntry()) != null){
            System.out.println("Reading file " + zipEntry);
            int x;
            while((x = buffInStream.read()) != -1){
                System.out.write(x);
            }
        }
        if(files.size() == 1){
            System.out.println("CheckSum: " + checkSumIn.getChecksum().getValue());
        }
        buffInStream.close();*/

        // Alternative way to open and read Zip files:
        System.out.println("Alternative way to open and read Zip files:");
        ZipFile zipFile = new ZipFile("testComp.zip");
        Enumeration enumFiles = zipFile.entries();
        while(enumFiles.hasMoreElements()){
            ZipEntry entry = (ZipEntry)enumFiles.nextElement();
            System.out.println("File: " + entry);
        }
    }

}
