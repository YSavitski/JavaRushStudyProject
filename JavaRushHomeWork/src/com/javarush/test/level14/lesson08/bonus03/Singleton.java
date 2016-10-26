package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by ESavitsky on 10/22/2016.
 */
public class Singleton
{
    private Singleton(){}
    /*public static final Singleton INSTANCE = new Singleton();
    public static Singleton getInstance()
    {
        return Singleton.INSTANCE;
    }*/

    private static Singleton instance = null;
    public static Singleton getInstance()
    {
        if(instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
}
