package com.javarush.task.task32.task3209;

/**
 * Created by 07ers on 5/1/2017.
 */
public class ExceptionHandler extends Exception {
    public static void log(Exception e){
        System.out.println(e.toString());
    }
}
