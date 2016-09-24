package com.javarush.test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        int[][]DArray = new int[10][10];
        for(int i=0; i<DArray.length; i++ )
        {
            DArray[i][0] = i+1;
            DArray[0][i] = i+1;
        }

        for(int i=1; i<DArray.length; i++)
        {
            for(int j=1; j<DArray.length; j++)
            {
                DArray[i][j] = DArray[i][0]*DArray[0][j];
            }
        }

        for(int i=0; i<DArray.length; i++)
        {
            for(int j=0; j<DArray.length; j++)
            {
                System.out.print(DArray[i][j] + " ");
            }
            System.out.println();
        }



    }
}