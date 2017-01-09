package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<ArrayList<String>> listOfLines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        reader.close();
        String tempStr= null;
        while((tempStr = fileReader.readLine()) != null){
            ArrayList<String> tempList = new ArrayList<>();
            for (String symbol:
                 tempStr.split(""))
            {
                tempList.add(symbol);
            }
            listOfLines.add(tempList);
        } fileReader.close();

        for (ArrayList<String> innerList:
             listOfLines)
        {
            Collections.reverse(innerList);
            for (String symbol:
                 innerList)
            {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
