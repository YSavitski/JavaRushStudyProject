package com.javarush.test.level07.lesson06.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
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

        String temp = null;
        for(int i=0; i<13; i++)
        {
            temp = myList.get(myList.size()-1);
            myList.remove(myList.size()-1);
            myList.add(0, temp);
        }

        for (String str:
             myList)
        {
            System.out.println(str);
        }

    }
}
