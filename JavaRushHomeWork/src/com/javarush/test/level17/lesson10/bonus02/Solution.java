package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        String comand = args[0];
        SimpleDateFormat customDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if(args.length < 2){
            return;
        }

        switch (comand){
            case "-c":
                for(int i=1; i<args.length; i+=3){
                    synchronized (Solution.class){
                        try
                        {
                            if(args[i+1].equals("м")){
                                Person.createMale(args[i], customDateFormat.parse(args[i+2]));
                            } else if(args[i+1].equals("ж")){
                                Person.createFemale(args[i], customDateFormat.parse(args[i+2]));
                            }
                        }
                        catch (ParseException ex){
                            ex.printStackTrace();
                        }
                    }
                }
                break;
            case "-u":
                Lock lock = new ReentrantLock();
                for(int i=1; i<args.length; i+=4){
                    try
                    {
                        lock.tryLock();
                        allPeople.get(Integer.parseInt(args[i])).setName(args[i+1]);
                        if(args[i+2].equals("м")){
                            allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                        } else if(args[i+2].equals("ж")){
                            allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
                        }
                        try
                        {
                            allPeople.get(Integer.parseInt(args[i])).setBirthDay(customDateFormat.parse(args[i+3]));
                        }
                        catch (ParseException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    finally
                    {
                        lock.unlock();
                    }
                }
                break;

            case "-d":
                synchronized (Solution.class){
                    for(int i=1; i<args.length; i++){

                        int tempId = Integer.parseInt(args[i]);
                        if(tempId > args.length-1){
                            return;
                        }

                        allPeople.get(tempId).setName("");
                        allPeople.get(tempId).setBirthDay(null);
                        allPeople.get(tempId).setSex(null);
                    }
                }
                break;

            case "-i":
                Person person = null;
                synchronized (Solution.class){
                    for(int i = 1; i<args.length; i++){
                        person = allPeople.get(Integer.parseInt(args[1]));
                        System.out.println(person.getName() + " " +
                                (person.getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                                customDateFormat.format(person.getBirthDay()));
                    }
                }
                break;
        }
    }
}
