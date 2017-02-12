package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        StringBuilder loggingResult = new StringBuilder();
        loggingResult.append(Thread.currentThread().getStackTrace()[2].getClassName());
        loggingResult.append(": ");
        loggingResult.append(Thread.currentThread().getStackTrace()[2].getMethodName());
        loggingResult.append(": ");
        loggingResult.append(s);
        System.out.println(loggingResult.toString());
    }
}
