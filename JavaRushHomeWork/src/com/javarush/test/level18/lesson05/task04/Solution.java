package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream infileStream = new FileInputStream(reader.readLine());
        FileOutputStream outStram = new FileOutputStream(reader.readLine());
        reader.close();

        while (infileStream.available() >  0){
            byte[] buffer = new byte[infileStream.available()];
            int count = infileStream.read(buffer);
            reverse(buffer);
            outStram.write(buffer, 0, count);
        }
        infileStream.close();
        outStram.close();

    }

    public static void reverse(byte[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        byte tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }
}
