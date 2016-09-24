package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //напишите тут ваш код
        HashSet<String> mySet = new HashSet<String>();
        String defaultStr = "Л";

        for(int i=1; i<=20; i++)
        {
            mySet.add(defaultStr + i);
        }
        return mySet.isEmpty() ? null : mySet;
    }

    /*public static void main(String[] args) throws Exception
    {
        HashSet<String> mySet = createSet();

        if(!mySet.isEmpty())
        {
            for (String item:
                 mySet)
            {
                System.out.println(item);
            }
        }
    }*/
}
