package com.javarush.test.level09.lesson08.task04;

import java.io.IOException;
import java.rmi.RemoteException;

/* Перехват checked исключений
В методе processExceptions обработайте все checked исключения.
Нужно вывести на экран каждое возникшее checked исключение.
Можно использовать только один блок try..
*/

public class Solution {
    public static void main(String[] args) {
        processExceptions(new Solution());

    }

    public static void processExceptions(Solution obj) //throws IOException, NoSuchFieldException
    {
        try
        {
            obj.method1();
            obj.method2();
            obj.method3();
        }
        catch (RemoteException REx)
        {
            System.out.println(REx);
            //throw REx;
        }
        catch (IOException IOEx)
        {
            System.out.println(IOEx);
            //throw IOEx;
        }
        catch (NoSuchFieldException NSFEx)
        {
            System.out.println(NSFEx);
            //throw NSFEx;
        }
    }

    public void method1() throws IOException {
        throw new IOException();
    }

    public void method2() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    public void method3() throws RemoteException {
        throw new RemoteException();
    }
}
