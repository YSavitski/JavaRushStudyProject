package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if(args.length == 0){
            return;
        }

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "UTF-8"));
        TreeMap<String, Double> peopleSalarys = new TreeMap<>();
        String temp = null;
        while((temp = fileReader.readLine()) != null){
            String[] tempArr = temp.split(" ");

            if(peopleSalarys.containsKey(tempArr[0])){
                peopleSalarys.put(tempArr[0], peopleSalarys.get(tempArr[0]) + Double.parseDouble(tempArr[1]));
            }
            else{
                peopleSalarys.put(tempArr[0], Double.parseDouble(tempArr[1]));
            }

        }
        fileReader.close();

        for (Map.Entry<String, Double> entry:
             peopleSalarys.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
