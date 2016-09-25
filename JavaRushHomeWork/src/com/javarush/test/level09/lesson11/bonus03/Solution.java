package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        ArrayList<String> listNum = new ArrayList<String>();
        ArrayList<String> listWord = new ArrayList<String>();
        int cntNum = 0, cntWord = 0;
        for (String item:
             array)
        {
            if(isNumber(item))
            {
                //cntNum++;
                listNum.add(item);
            }
            else
                {
                    //cntWord++;
                    listWord.add(item);
                }
        }

        //SortIntList(listNum, 0, listNum.size());
        SortIntList(listNum);
        SortStrList(listWord);

        for(int i=0; i<array.length; i++)
        {
            if(isNumber(array[i]))
            {
                array[i] = listNum.get(cntNum).toString();
                cntNum++;
            }
            else
                {
                    array[i] = listWord.get(cntWord);
                    cntWord++;
                }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }

    public static void SortStrList(ArrayList<String> words)
    {
        String temp = null;
        for (int i=0;i<words.size();i++) {
            for (int j=0;j<words.size()-1;j++) {
                if(isGreaterThan(words.get(j), words.get(j+1)))
                {
                    temp = words.get(j);
                    words.set(j, words.get(j+1));
                    words.set(j+1, temp);
                }
            }
        }
    }

    public static void SortIntList(ArrayList<String> numbers)
    {
        String temp;
        for (int i=0;i<numbers.size();i++) {
            for (int j=1;j<numbers.size()-i;j++) {
                int a = Integer.parseInt(numbers.get(j-1));
                int b = Integer.parseInt(numbers.get(j));
                if(a<b) {
                    temp =numbers.get(j-1);
                    numbers.set(j-1, numbers.get(j));
                    numbers.set(j, temp);
                }
            }
        }
    }

    /*public static void SortIntList(ArrayList<Integer> numbers, int low, int high)
    {
        int i=low;
        int j=high;
        int temp;
        int middle=numbers.get((low+high)/2);

        while(i<j)
        {
            while (numbers.get(i)>middle)
            {
                i++;
            }
            while (numbers.get(j)<middle)
            {
                j--;
            }
            if (j>=i)
            {
                temp=numbers.get(i);
                numbers.set(i, numbers.get(j));
                numbers.set(j, temp);
                i++;
                j--;
            }
        }
        if (low<j)
        {
            SortIntList(numbers, low, j);
        }
        if (i<high)
        {
            SortIntList(numbers, i, high);
        }
    }*/

    /*public static void QuickSortNumDescendingOrder(int[] numbers, int low, int high)
    {
        int i=low;
        int j=high;
        int temp;
        int middle=numbers[(low+high)/2];

        while (i<j)
        {
            while (numbers[i]>middle)
            {
                i++;
            }
            while (numbers[j]<middle)
            {
                j--;
            }
            if (j>=i)
            {
                temp=numbers[i];
                numbers[i]=numbers[j];
                numbers[j]=temp;
                i++;
                j--;
            }
        }
        if (low<j)
        {
            QuickSortNumDescendingOrder(numbers, low, j);
        }
        if (i<high)
        {
            QuickSortNumDescendingOrder(numbers, i, high);
        }
    }*/
}
