package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] myArray = new int[3];
        int cnt=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<myArray.length; i++)
        {
            myArray[i] = Integer.parseInt(reader.readLine());
            if(myArray[i]>0)
            {
                cnt++;
            }
        }
        System.out.println(cnt);



    }
}
