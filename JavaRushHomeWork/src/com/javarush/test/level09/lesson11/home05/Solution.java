package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        char[] strToChar = str.toCharArray();
        VowelsConsonantsSeparation(strToChar);

    }

    public static void VowelsConsonantsSeparation(char[] arrayChar)
    {
        ArrayList<Character> vowelsList = new ArrayList<Character>();
        ArrayList<Character> consonantsList = new ArrayList<Character>();

        for(char letter : arrayChar)
        {
            if(isVowel(letter))
                vowelsList.add(letter);
            else
                consonantsList.add(letter);
        }

        printList(vowelsList);
        printList(consonantsList);

    }

    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);
        for(char letter : Solution.vowels)
        {
            if(c == letter)
                return true;
        }
        return false;
    }

    public static void printList(ArrayList<Character> list)
    {
        for(char item : list)
        {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}
