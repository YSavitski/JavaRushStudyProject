package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream savedConsoleStream = System.out;

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        PrintStream newPrintStream = new PrintStream(arrayOutputStream);
        System.setOut(newPrintStream);
        testString.printSomething();
        System.setOut(savedConsoleStream);

        for (String strItem:
             new StringBuilder(arrayOutputStream.toString()).toString().split(""))
        {
            if(strItem.matches("\\d+")){
                System.out.print(strItem);
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
