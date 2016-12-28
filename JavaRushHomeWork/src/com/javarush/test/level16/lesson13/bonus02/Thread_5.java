package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by esavitski on 28.12.2016.
 */
public class Thread_5 extends Thread
{
    @Override
    public void run(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        try
        {
            while (!isInterrupted()){
                String strInput = reader.readLine();

                if(strInput.equals("N")){
                    this.interrupt();
                }

                else{
                    sum += Integer.parseInt(strInput);
                }
            }
            throw new InterruptedException();
        }
        catch (IOException ex){}
        catch (InterruptedException ex){
            System.out.println(sum);
        }
    }
}
