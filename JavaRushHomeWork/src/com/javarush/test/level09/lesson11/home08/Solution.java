package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Random;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        ArrayList<int[]> newList = new ArrayList<int[]>();
        newList.add(AddRandomNumbers(new int[5]));
        newList.add(AddRandomNumbers(new int[2]));
        newList.add(AddRandomNumbers(new int[4]));
        newList.add(AddRandomNumbers(new int[7]));
        newList.add(AddRandomNumbers(new int[0]));
        return newList;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }

    public static int[] AddRandomNumbers(int[] array)
    {
        final Random random = new Random();
        for(int i=0; i<array.length; i++)
        {
            array[i] = random.nextInt();
        }
        return array;
    }
}
