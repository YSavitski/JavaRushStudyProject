package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutput1 = new FileOutputStream(reader.readLine());
        FileInputStream fileInput2 = new FileInputStream(reader.readLine());
        FileInputStream fileInput3 = new FileInputStream(reader.readLine());

        readAndWrite(fileInput2, fileOutput1);
        readAndWrite(fileInput3, fileOutput1);


        reader.close();
        fileOutput1.close();
        fileInput2.close();
        fileInput3.close();
    }

    public static synchronized void readAndWrite(FileInputStream input, FileOutputStream output) throws IOException
    {
        while (input.available()>0){
            byte[] buffer = new byte[input.available()];
            int count = input.read(buffer);
            output.write(buffer, 0, count);
        }
    }
}
