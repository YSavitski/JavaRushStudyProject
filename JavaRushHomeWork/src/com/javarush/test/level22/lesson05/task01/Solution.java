package com.javarush.test.level22.lesson05.task01;

import java.io.BufferedReader;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }


    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null || string.isEmpty()) throw new TooShortStringException();
        String[] ar = string.substring(string.indexOf(" ")+1).split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        if (ar.length < 4){
            throw new TooShortStringException();
        } else {
            for(int i=0; i < (ar.length>4 ? 4 : ar.length); i++){
                stringBuilder.append(ar[i]);
                if(i<3){
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }

    public static class TooShortStringException extends Exception {

    }
}
