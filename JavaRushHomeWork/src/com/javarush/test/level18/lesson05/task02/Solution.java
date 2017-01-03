package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inFileStream = new FileInputStream(reader.readLine());
        reader.close();

        int countComma = 0;
        while (inFileStream.available() > 0){
            int tempData = inFileStream.read();
            if(tempData == 44){
                countComma++;
            }
        }
        inFileStream.close();
        System.out.println(countComma);
    }
}
