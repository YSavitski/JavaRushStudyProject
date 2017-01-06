package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();
        StringBuilder sBuilder = new StringBuilder();

        while(fileReader.ready()){
            sBuilder.append((char)fileReader.read());
        } fileReader.close();

        for (String strItem:
             sBuilder.toString().split(" "))
        {
            if(strItem.matches("\\d+")){
                fileWriter.write(strItem + " ");
            }
        }fileWriter.close();
    }
}
