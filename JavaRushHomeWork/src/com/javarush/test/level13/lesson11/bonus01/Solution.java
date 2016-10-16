package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
        Scanner sc = new Scanner(new File(reader.readLine()));
        while(sc.hasNext())
        {

            try
            {
                listOfIntegers.add(Integer.parseInt(sc.next()));
            }
            catch (NumberFormatException numEx)
            {
                System.out.println(numEx.getStackTrace());
            }
        }
        sc.close();
        printCollection(sort(listOfIntegers));

    }


    public static ArrayList<Integer> sort(ArrayList<Integer> list)
    {
        ArrayList<Integer> listEvensIntgers = new ArrayList<Integer>();

        for (int integer:
             list)
        {
            if(integer%2==0)
            {
                listEvensIntgers.add(integer);
            }
        }

        Collections.sort(listEvensIntgers);
        return listEvensIntgers;
    }

    public static void printCollection(ArrayList<Integer> collection)
    {
        for (int item:
             collection)
        {
            System.out.println(item);
        }
    }

}
