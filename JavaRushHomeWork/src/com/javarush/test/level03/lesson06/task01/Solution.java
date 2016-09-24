 package com.javarush.test.level03.lesson06.task01;
 import java.util.*;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        String s1 = "Мама";
        String s2 = "Мыла";
        String s3 = "Раму";

        String[] myList = {s1, s2, s3};
        ShowPermutation(myList);

        //System.out.println(myList.length);

    }

    public static void ShowPermutation(String[] list)
    {
        for(int i=0; i<list.length; i++)
        {
            for(int j=0; j<list.length-1; j++)
            {
                for(String var : list)
                {
                    System.out.print(var);
                }
                System.out.println();
                String temp = list[j];
                list[j] = list[j+1];
                list[j+1] = temp;


            }
        }
    }
}