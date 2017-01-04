package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if(args.length == 0){
            throw new IllegalArgumentException();
        }
        FileInputStream inFile = new FileInputStream(args[0]);
        byte[] bufferData;
        Map<Character, Integer> byteAndFrequency = new TreeMap<Character, Integer>();
        char[] charArray = new char[0];

        while(inFile.available() > 0){
            bufferData = new byte[inFile.available()];
            inFile.read(bufferData);
            charArray = new String(bufferData).toCharArray();
        } inFile.close();

        int count;
        for(int i=0; i<charArray.length; i++){
            count = 0;
            for (int j =0; j<charArray.length; j++){
                if(charArray[i]==charArray[j]){
                    count++;
                }
            }
            byteAndFrequency.put(charArray[i], count);
        }

        for (Map.Entry<Character, Integer> entry:
             byteAndFrequency.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
