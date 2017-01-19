package com.savitski.thinkingInJava.chapter_16;

import java.io.*;

/**
 * Created by esavitski on 19.01.2017.
 */
public class InputFromFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileInputName = consoleReader.readLine();
        //String fileOutputName = consoleReader.readLine();
        consoleReader.close();

        //InputFromFiles.basicFileOutput(fileInputName, fileOutputName);
        //InputFromFiles.fileOutputShortcut(fileInputName, fileOutputName);
        //InputFromFiles.storingAndRecoveringData(fileInputName);

        //System.out.println(bufferedInputFile(fileName));
        //System.out.println(inputFromMemory(fileName));
        //System.out.println(formattedMemoryInput(fileInputName));
        PrintWriter out = new PrintWriter(System.out, true);
        out.println(fileInputName);
    }


    public static String bufferedInputFile(String fileName) throws IOException {
        StringBuilder sBuilder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String tempStr = null;
        while((tempStr = reader.readLine()) != null){
            sBuilder.append(tempStr);
        }
        reader.close();
        return sBuilder.toString();
    }

    public static String inputFromMemory(String fileName) throws IOException {
        StringBuilder sBuilder = new StringBuilder();
        StringReader reader = new StringReader(InputFromFiles.bufferedInputFile(fileName));
        int tempInt;
        while ((tempInt = reader.read()) != -1){
            sBuilder.append((char)tempInt);
        }
        reader.close();
        return sBuilder.toString();
    }

    public static String formattedMemoryInput(String fileName) throws IOException {
        StringBuilder sBuilder = new StringBuilder();
        DataInputStream inStream = new DataInputStream(new ByteArrayInputStream(InputFromFiles.bufferedInputFile(fileName).getBytes()));
        while (inStream.available() > 0)
            sBuilder.append((char)inStream.readByte());
        return sBuilder.toString();
    }

    public static void basicFileOutput(String fileIn, String fileOut) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileIn));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
        String tempStr = null;
        while ((tempStr = reader.readLine()) != null){
            writer.println(tempStr);;
        }
        reader.close();
        writer.close();
        System.out.println(InputFromFiles.bufferedInputFile(fileOut));
    }

    public static void fileOutputShortcut(String fileIn, String fileOut) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileIn));
        PrintWriter writer = new PrintWriter(fileOut);
        String tempStr = null;
        while ((tempStr = reader.readLine()) != null){
            writer.println(tempStr);
        }
        reader.close();
        writer.close();
        System.out.println(InputFromFiles.inputFromMemory(fileOut));
    }

    public static void storingAndRecoveringData(String fileName) throws IOException {
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
        output.writeDouble(3.1356);
        output.writeUTF("English");
        output.writeUTF("Русский");
        output.close();

        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        System.out.println(input.readDouble());
        System.out.println(input.readUTF());
        System.out.println(input.readUTF());
    }
}
