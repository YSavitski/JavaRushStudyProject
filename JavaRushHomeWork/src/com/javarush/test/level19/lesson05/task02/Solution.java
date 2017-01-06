package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        StringBuilder sBuilder = new StringBuilder();

        while (fileReader.ready()){
            sBuilder.append((char)fileReader.read());
        } fileReader.close();

        int cntWords = 0;
        for (String item:
                sBuilder.toString().split("\\p{P}?[ \\t\\n\\r]+"))
        {
            if(item.toLowerCase().equals("world")){
                cntWords++;
            }
        }

        System.out.println(cntWords);
    }
}
