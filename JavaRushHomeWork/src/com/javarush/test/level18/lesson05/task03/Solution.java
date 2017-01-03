package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inFileStream = new FileInputStream(reader.readLine());
        FileOutputStream outToFile2 = new FileOutputStream(reader.readLine());
        FileOutputStream outToFile3 = new FileOutputStream(reader.readLine());
        reader.close();

        while (inFileStream.available() > 0){
            if(inFileStream.available()%2==0){
                byte[] buffer1 = new byte[inFileStream.available()/2];
                byte[] buffer2 = new byte[inFileStream.available()/2];
                outToFile2.write(buffer1, 0, inFileStream.read(buffer1));
                outToFile3.write(buffer2, 0, inFileStream.read(buffer2));
            }
            else
                {
                    byte[] buffer1 = new byte[inFileStream.available()/2 + 1];
                    byte[] buffer2 = new byte[inFileStream.available()/2];
                    outToFile2.write(buffer1, 0, inFileStream.read(buffer1));
                    outToFile3.write(buffer2, 0, inFileStream.read(buffer2));
                }

        }
        inFileStream.close();
        outToFile2.close();
        outToFile3.close();
    }
}
