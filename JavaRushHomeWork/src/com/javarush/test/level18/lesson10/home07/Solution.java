package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Map<Integer, String> treeMap = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner inFileSC = new Scanner(new File(reader.readLine()));
        inFileSC.useLocale(Locale.US);

        String temp = null;
        while (inFileSC.hasNextLine())
        {
            temp = inFileSC.nextLine();
            treeMap.put(Integer.parseInt(temp.substring(0, temp.indexOf(' '))), temp);
        }
        reader.close();
        inFileSC.close();

        if(args.length<0){
            throw new IllegalArgumentException();
        } else {
            System.out.println(treeMap.get(Integer.parseInt(args[0])));
        }
    }
}
