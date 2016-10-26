package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int n)
    {
        System.out.println(n);
    }
    public static void printMatrix(int n, int m)
    {
        System.out.println(n + m);
    }
    public static void printMatrix(int n, int m, int l)
    {
        System.out.println(n + m + l);
    }
    public static void printMatrix(String str1)
    {
        System.out.println(str1);
    }
    public static void printMatrix(String str1, String str2)
    {
        System.out.println(str1 + str2);
    }
    public static void printMatrix(String str1, String str2, String str3)
    {
        System.out.println(str1 + str2 + str3);
    }
    public static void printMatrix(Object obj1)
    {
        System.out.println(obj1);
    }
    public static void printMatrix(Object obj1, Object obj2)
    {
        System.out.println(obj1.toString() + obj2.toString());
    }
}
