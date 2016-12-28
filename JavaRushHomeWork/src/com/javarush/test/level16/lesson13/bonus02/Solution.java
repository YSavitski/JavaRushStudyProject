package com.javarush.test.level16.lesson13.bonus02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new Thread_1());
        threads.add(new Thread_2());
        threads.add(new Thread_3());
        threads.add(new Thread_4());
        threads.add(new Thread_5());
    }

    private static void sleep()
    {
        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){

        Thread th1 = threads.get(0);
        th1.start();


        Thread thread2 = threads.get(1);
        thread2.start();
        sleep();
        thread2.interrupt();

        Thread thread4 = threads.get(3);
        Message message = (Message) thread4;
        thread4.start();
        sleep();
        message.showWarning();
        System.out.println(thread4.isAlive());

        try
        {
            TimeUnit.SECONDS.sleep(3);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(th1.isAlive() + " before calling method stop");
        th1.stop();
        System.out.println(th1.isAlive() + " after calling method stop");

    }
}
