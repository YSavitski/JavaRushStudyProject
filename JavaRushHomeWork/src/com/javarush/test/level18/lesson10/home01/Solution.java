package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if(args.length>0){
            FileInputStream inputStream = new FileInputStream(args[0]);

            int countLetters = 0;
            int tempData = 0;
            while (inputStream.available() > 0){
                tempData = inputStream.read();
                if((tempData >= 65 && tempData <= 90) || (tempData >= 97 && tempData <= 122)){
                    countLetters++;
                }
            }
            inputStream.close();
            System.out.println(countLetters);
        }
    }
}
