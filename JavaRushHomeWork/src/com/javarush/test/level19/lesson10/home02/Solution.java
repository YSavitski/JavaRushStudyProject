package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.Map;
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
        Double maxSalary = 0.0;
        while((temp = fileReader.readLine()) != null){
            String[] tempArr = temp.split(" ");

            if(peopleSalarys.containsKey(tempArr[0])){
                peopleSalarys.put(tempArr[0], peopleSalarys.get(tempArr[0]) + Double.parseDouble(tempArr[1]));
            }
            else{
                peopleSalarys.put(tempArr[0], Double.parseDouble(tempArr[1]));
            }

            if(maxSalary < peopleSalarys.get(tempArr[0])){
                maxSalary = peopleSalarys.get(tempArr[0]);
            }

        }
        fileReader.close();

        for (Map.Entry<String, Double> entry:
                peopleSalarys.entrySet())
        {
            if(entry.getValue() == maxSalary){
                System.out.print(entry.getKey() + " ");
            }
        }

    }
}
