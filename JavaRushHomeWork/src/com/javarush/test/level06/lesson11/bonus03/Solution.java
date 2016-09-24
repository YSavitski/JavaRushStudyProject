package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    //private static int[] myArray = new int[5];

    public static void main(String[] args) throws Exception
    {
        int[] myArray = new int[5];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<myArray.length; i++)
        {
            try
            {
                myArray[i] = Integer.parseInt(reader.readLine());
            }
            catch (Exception ex){ System.out.println("Error: " + ex.getMessage()); }
        }

        int low = 0, high = myArray.length-1;
        quickSort(myArray, low, high);

        for (int item:
             myArray)
        {
            System.out.print(item + " ");
        }

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }
}





    /*public static void InputIntArray(int[] array)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<array.length; i++)
        {
            try
            {
                array[i] = Integer.parseInt(reader.readLine());
            }
            catch (Exception ex){ System.out.println("Error: " + ex.getMessage()); }
        }
    }

    public static void sort(int[] array)
    {
        if( array == null || array.length == 0) { return; }
        else
            {
                Solution.QuickSort(0, Solution.myArray.length-1);
            }
    }

    private static void QuickSort(int low, int high)
    {
        int i = low, j = high;
        int pivot = Solution.myArray[low + (high-low)/2];
        while(i<=j)
        {
            while(Solution.myArray[i] < j)
            {
                i++;
            }
            while(Solution.myArray[j] > pivot)
            {
                j--;
            }
            if(i<=j)
            {
                swap(i, j);
                i++;
                j--;
            }
            if(low < j) QuickSort(low, j);
            if(i < high) QuickSort(i, high);
        }
    }

    public static void swap(int a, int b)
    {
        int c=a;
        a=b;
        b=c;
    }
}*/

