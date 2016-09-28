package com.javarush.test.level10.lesson11.home08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() throws IOException
    {
        //напишите тут ваш код
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String>[] newArray = new ArrayList[3];
        //System.out.println(newArray.length);
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();

        for(int i =0; i<5; i++)
        {
            list1.add("111");
            list2.add("222");
            list3.add("333");
        }

        newArray[0] = list1;
        newArray[1] = list2;
        newArray[2] = list3;


        return newArray;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}