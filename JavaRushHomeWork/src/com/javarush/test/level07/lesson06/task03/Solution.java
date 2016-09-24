package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> myList = new ArrayList<String>();

        for(int i=0; i<5; i++)
        {
            myList.add(reader.readLine());
        }

        int minLength = myList.get(0).length();
        for(int i=0; i<myList.size(); i++)
        {
            if(minLength > myList.get(i).length())
            {
                minLength = myList.get(i).length();
            }
        }

        for (String str:
                myList)
        {
            if(str.length() == minLength)
            {
                System.out.println(str);
            }
        }


    }
}
