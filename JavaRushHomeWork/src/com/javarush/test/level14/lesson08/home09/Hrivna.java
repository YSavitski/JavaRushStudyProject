package com.javarush.test.level14.lesson08.home09;

/**
 * Created by ESavitsky on 10/22/2016.
 */
public class Hrivna extends Money
{
    public Hrivna(double amount)
    {
        super(amount);
    }
    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }

    @Override
    public double getAmount()
    {
        return super.getAmount();
    }
}
