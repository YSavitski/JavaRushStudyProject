package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by esavitski on 28.12.2016.
 */
public class Thread_4 extends Thread implements Message
{
    @Override
    public void showWarning(){
        this.interrupt();
        try
        {
            this.join();
        }
        catch (InterruptedException ex){}
    }

    @Override
    public void run(){
        while(!this.isInterrupted()){}
    }
}
