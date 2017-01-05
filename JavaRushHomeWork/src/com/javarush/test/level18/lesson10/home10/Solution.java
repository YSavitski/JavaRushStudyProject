package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFileName;
        Map<Integer, String> treeMap = new TreeMap<>();
        while (!(inputFileName = reader.readLine()).equals("end")){
            if(inputFileName!=null){
                treeMap.put(Integer.parseInt(inputFileName.substring(inputFileName.indexOf("Lion.avi.part") + 13,
                        inputFileName.indexOf(".txt"))),
                        inputFileName);

            }
        } reader.close();

        String tempFileName = treeMap.entrySet().iterator().next().getValue();
        String resultFilePath = tempFileName.substring(0, tempFileName.indexOf("Lion.avi.part")) + "Lion.avi.txt";
        new File(resultFilePath);
        WriteInfoIntoResultFile(new FileOutputStream(resultFilePath, true), treeMap);
    }

    public static void WriteInfoIntoResultFile(FileOutputStream outStream, Map<Integer, String> mapWithFiles) throws IOException
    {
        FileInputStream inStream;
        for (Map.Entry<Integer, String> entry:
             mapWithFiles.entrySet())
        {
            inStream = new FileInputStream(entry.getValue());
            byte[] buffer;
            while (inStream.available() > 0){
                buffer = new byte[inStream.available()];
                int count = inStream.read(buffer);
                outStream.write(buffer, 0, count);
            }
            inStream.close();
        }
        outStream.close();
    }
}
