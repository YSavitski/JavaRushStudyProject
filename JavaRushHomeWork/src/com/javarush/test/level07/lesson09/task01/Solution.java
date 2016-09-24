package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<Integer> main = new ArrayList<Integer>();
        ArrayList<Integer> even2 = new ArrayList<Integer>();
        ArrayList<Integer> even3 = new ArrayList<Integer>();
        ArrayList<Integer> others = new ArrayList<Integer>();

        main = InitializeList(main, 20);
        SortingToList(main, even3, even2, others);
        printList(even3); printList(even2); printList(others);
    }

    public static void printList(List<Integer> list)
    {
        //напишите тут ваш код
        for (int item:
             list)
        {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> InitializeList(ArrayList<Integer> list, int cnt)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<cnt; i++)
        {
            try
            {
                list.add(Integer.parseInt(reader.readLine()));
            }
            catch(Exception ex){ System.out.println(ex.getMessage()); }
        }

        return list;
    }

    public static void SortingToList(ArrayList<Integer> main, ArrayList<Integer> even3, ArrayList<Integer> even2, ArrayList<Integer> others)
    {
        if(main.size() > 0)
        {
            for (int item:
                 main)
            {
                if(item%2==0 || item%3==0)
                {
                    if(item%2==0){ even2.add(item); }
                    if(item%3==0){ even3.add(item); }
                }
                else
                    {
                        others.add(item);
                    }
            }
        }
    }
}
