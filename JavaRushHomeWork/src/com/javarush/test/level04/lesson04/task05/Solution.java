package com.javarush.test.level04.lesson04.task05;

/* Положительное и отрицательное число
Ввести с клавиатуры число. Если число положительное, то увеличить его в два раза. Если число отрицательное, то прибавить единицу.
Вывести результат на экран.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        try
        {
            number = Integer.parseInt(reader.readLine());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        if(number > 0)
        {
            number *=2;
        }
        else if(number < 0)
        {
            number +=1;
        }

        System.out.println(number);
    }

}