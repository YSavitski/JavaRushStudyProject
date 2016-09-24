package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int size10 = 10, size20 = 20;

        int[] int20 = new int[size20];
        int[] int10A = new int[size10];
        int[] int10B = new int[size10];

        for(int i=0; i<size20; i++)
        {
            try
            {
                int20[i] = Integer.parseInt(reader.readLine());
            }
            catch (Exception ex){ System.out.println(ex.getMessage()); }
        }

        for(int i=0; i<size10; i++)
        {
            int10A[i] = int20[i];
            int10B[i] = int20[size10+i];
            System.out.println(int10B[i]);
        }
    }
}
