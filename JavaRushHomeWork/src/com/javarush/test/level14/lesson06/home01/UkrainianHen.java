package com.javarush.test.level14.lesson06.home01;

/**
 * Created by ESavitsky on 10/19/2016.
 */
public class UkrainianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 9;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() +
                " Моя страна - " + Country.UKRAINE +
                ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
