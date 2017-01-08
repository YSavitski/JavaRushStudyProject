package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream savedConsoleStream = System.out;
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(arrayOutputStream));
        testString.printSomething();
        System.setOut(savedConsoleStream);

        String[] allCharacters = arrayOutputStream.toString().split(" ");
        printResultOperation(Integer.parseInt(allCharacters[0]), Integer.parseInt(allCharacters[2]), allCharacters[1]);

    }

    public static void printResultOperation(int num1, int num2, String opSign){
        switch (opSign){
            case "+":
                System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
                break;
            case "-":
                System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
                break;
            case "*":
                System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
                break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 - 6 = ");
        }
    }
}

