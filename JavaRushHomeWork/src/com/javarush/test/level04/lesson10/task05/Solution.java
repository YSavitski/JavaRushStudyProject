package com.javarush.test.level04.lesson10.task05;

import java.io.*;

/* Таблица умножения
Вывести на экран таблицу умножения 10х10 используя цикл while.
Числа разделить пробелом.
1 2 3 4 5 6 7 8 9 10
2 4 6 8 10 12 14 16 18 20
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[][] matrix = new int[10][10];
        /*int i=0, j=0;

        while(i<10)
        {

            while(j<10)
            {
                matrix[i][0]=i+1;
                matrix[0][j]=j+1;
            }

            i++;
        }

       *//* i=0; j=0;
        while (i<10)
        {
            while (j<10)
            {
                matrix[i][j] = matrix[i][0] * matrix[0][j];
                j++;
            }
            i++;
        }*//*

        i=0; j=0;
        while(i<10)
        {
            while(j<10)
            {
                System.out.print(matrix[i][j] + " ");
                j++;
            }
            System.out.println();
            i++;
        }*/

        int i = 1;
        int j = 1;
        while (i <= 10)
        {
            j = 1;
            while (j <= 10)
            {
                if (j == 10)
                    System.out.println(i * j + " ");
                else
                    System.out.print(i * j + " ");
                j++;
            }
            i++;
        }



    }
}
