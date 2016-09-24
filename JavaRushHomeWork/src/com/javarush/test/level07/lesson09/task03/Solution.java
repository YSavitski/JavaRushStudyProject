package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> myList = new ArrayList<String>();
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        myList.add("мама"); myList.add("мыла"); myList.add("раму");

        for(int i=0; i<myList.size(); i++)
        {
            if(!myList.get(i).equals("именно"))
            {
                myList.add(i+1, "именно");
            }
        }

        for (String item:
             myList)
        {
            System.out.println(item);
        }

    }
}
