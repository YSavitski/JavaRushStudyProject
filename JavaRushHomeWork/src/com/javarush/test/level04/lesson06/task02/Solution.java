package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;
import java.util.Date;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] myArray = new int[4];

        for(int i=0; i< myArray.length; i++)
        {
            try
            {
                myArray[i] = Integer.parseInt(reader.readLine());
            }
            catch (Exception ex)
            {
                System.out.println((new Date()).toString() + ": " + ex.getMessage());
            }
        }

        int max = myArray[0];
        for(int i=0; i<myArray.length; i++)
        {
            if(max < myArray[i])
            {
                max = myArray[i];
            }
        }

        System.out.println(max);

    }
}
