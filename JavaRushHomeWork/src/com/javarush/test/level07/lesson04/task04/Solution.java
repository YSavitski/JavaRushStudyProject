package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] intArray = new int[10];

        for(int i=0; i<intArray.length; i++)
        {
            try
            {
                intArray[i] = Integer.parseInt(reader.readLine());
            }
            catch (Exception ex){ System.out.println(ex.getMessage()); }
        }

        int temp;
        for(int i=0; i<intArray.length/2; i++)
        {
            temp = intArray[i];
            intArray[i] = intArray[intArray.length-1-i];
            intArray[intArray.length-1-i] = temp;
        }

        for (int i:
             intArray)
        {
            System.out.println(i);
        }


    }
}
