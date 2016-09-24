package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        HashSet<Integer> inputSet = new HashSet<Integer>();
        //Random random = new Random();

        for(int i=0; i<20; i++)
        {
            inputSet.add(i);
        }
        return inputSet;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код
        HashSet<Integer> resultSet = new HashSet<Integer>();
        for (Integer item:
             set)
        {
            if(item <= 10)
            {
                resultSet.add(item);
            }
        }
        return resultSet;
    }

    public static void main(String[] args) throws Exception
    {
        HashSet<Integer> mySet = createSet();
        for (int item:
                mySet)
        {
            System.out.print(item + " ");
        }

        System.out.println();
        mySet = removeAllNumbersMoreThan10(mySet);

        for (int item:
             mySet)
        {
            System.out.print(item + " ");
        }
    }
}
