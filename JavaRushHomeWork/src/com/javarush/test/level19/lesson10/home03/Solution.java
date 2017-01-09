package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        if(args.length==0){
            return;
        }
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "UTF-8"));
        String temp = null;
        while((temp = fileReader.readLine()) != null){
            String[] tempArr = temp.split(" ");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(tempArr[tempArr.length-1]),
                    Integer.parseInt(tempArr[tempArr.length-2])-1, Integer.parseInt(tempArr[tempArr.length-3]));
            StringBuilder nameBuilder = new StringBuilder();
            for(int i=0; i<tempArr.length-3; i++){
                nameBuilder.append(tempArr[i]);
                if((i+1) < (tempArr.length-3)){
                    nameBuilder.append(" ");
                }
            }
            PEOPLE.add(new Person(nameBuilder.toString(), calendar.getTime()));
        }
        fileReader.close();
    }

}
