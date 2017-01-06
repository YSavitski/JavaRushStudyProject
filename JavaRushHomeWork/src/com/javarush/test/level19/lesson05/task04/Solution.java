package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
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

        fileWriter.write(sBuilder.toString().replace(".", "!"));
        fileWriter.close();
    }
}
