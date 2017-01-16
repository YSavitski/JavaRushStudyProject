package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static volatile int id = 0;
    public static void main(String[] args) throws Exception {
        if(args.length<4){
            return;
        }
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();
        id = getMaxId(fileName);
        System.out.println(id);
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
        if(args[0].equals("-c")){
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append(buildString(String.valueOf(++id), 8));
            strBuilder.append(buildString(args[1], 30));
            strBuilder.append(buildString(args[2], 8));
            strBuilder.append(buildString(args[3], 4));
            printWriter.println(strBuilder.toString());
        }
        printWriter.close();
    }

    public static synchronized int getMaxId(String fileName) throws IOException
    {
        int id = 0;
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        ArrayList<Integer> listWithID = new ArrayList<>();
        while (fileReader.ready()){
            listWithID.add(Integer.parseInt(fileReader.readLine().substring(0, 8).replaceAll(" ", "")));
        }
        fileReader.close();
        Collections.sort(listWithID);
        id = listWithID.get(listWithID.size()-1);
        return id;
    }

    public static String buildString(String defaultStr, int maxLength){
        if(defaultStr.length()>maxLength){
            return defaultStr.substring(0,maxLength);
        }
        else if(defaultStr.length() == maxLength){
            return defaultStr;
        }
        else{
            StringBuilder builder = new StringBuilder(defaultStr);
            for(int i=0; i<(maxLength - defaultStr.length()); i++){
                builder.append(" ");
            }
            return builder.toString();
        }
    }

}
