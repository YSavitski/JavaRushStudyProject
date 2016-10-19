package com.javarush.test.level14.lesson08.home05;

/**
 * Created by ESavitsky on 10/20/2016.
 */
public class Mouse implements CompItem
{
    @Override
    public String getName()
    {
        return getClass().getSimpleName();
    }
}
