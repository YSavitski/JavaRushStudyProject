package com.javarush.test.level03.lesson03.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 10 процентов
Реализуйте метод addTenPercent, который увеличивает переданное целое число на 10%.
Исправьте ошибку в сигнатуре метода.
Подсказка: подумайте, какие у этого метода входные и выходные данные.
*/
public class Solution
{
    /*public static double addTenPercent(int i)
    {
        //напишите тут ваш код
        double res =(double)(i+(i*0.1));
        return res;
    }
*/
    public static int fact(int num) {
        return (num == 0) ? 1 : num * fact(num - 1);
    }

    public static void main(String[] args) throws IOException
    {
        //System.out.println(addTenPercent(10));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(fact(Integer.parseInt(reader.readLine())));
    }
}
