package com.javarush.test.level16.lesson13.bonus02;

import java.util.concurrent.TimeUnit;

/**
 * Created by esavitski on 28.12.2016.
 */
public class Thread_3 extends Thread
{
    @Override
    public void run(){
        while(true){
            try
            {
                System.out.println("Ура");
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException ex) {}
        }
    }
}
