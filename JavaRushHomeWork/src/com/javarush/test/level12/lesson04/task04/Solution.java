package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(Solution.min(1, 2));
        System.out.println(Solution.min(1.0, 2.0));
        System.out.println(Solution.min((long)1, (long)2));

    }

    //Напишите тут ваши методы
    public static int min(int a, int b)
    {
        if(a>b){ return b;}
        else return a;
    }

    public static long min(long a, long b)
    {
        if(a>b){ return b;}
        else return a;
    }

    public static double min(double a, double b)
    {
        if(a>b){ return b;}
        else return a;
    }

}
