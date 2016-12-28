package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by esavitski on 28.12.2016.
 */
public class Thread_2 extends Thread
{
    @Override
    public void run(){
        try
        {
            while (!isInterrupted()){}
            throw new InterruptedException();
        }
        catch (InterruptedException ex){
            System.out.println("InterruptedException");
        }
    }
}
