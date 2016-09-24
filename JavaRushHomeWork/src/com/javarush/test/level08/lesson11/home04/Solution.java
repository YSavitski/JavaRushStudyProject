package com.javarush.test.level08.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум
        int min = array.get(0);
        for (Integer elem:
             array)
        {
            if(min > elem)
            {
                min = elem;
            }
        }
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        //Тут создать и заполнить список
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> result = new ArrayList<Integer>();
        int N = 0;
        try
        {
            N = Integer.parseInt(reader.readLine());

            for (int i =0; i<N; i++)
            {
                result.add(Integer.parseInt(reader.readLine()));
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getStackTrace() + ":\n" + new Date().toString() + "\t" + ex.getMessage());
        }

        return result;
    }
}
