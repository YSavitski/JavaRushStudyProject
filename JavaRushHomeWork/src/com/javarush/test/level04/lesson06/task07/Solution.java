package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int a=0, b=0, c=0, temp;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        a=Integer.parseInt(reader.readLine());
        b=Integer.parseInt(reader.readLine());
        c=Integer.parseInt(reader.readLine());

        temp=a;
        if(temp==b && temp!=c)
        {
            System.out.println(3);
        }
        else
            {
                if(temp==c && temp!=b)
                {
                    System.out.println(2);
                }
                else
                    {
                        if(temp !=b && temp !=c && b==c)
                        {
                            System.out.println(1);
                        }
                    }
            }

    }
}
