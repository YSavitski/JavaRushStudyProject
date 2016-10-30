package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by ESavitsky on 10/30/2016.
 */
public class Plane implements Flyable
{
    public void fly(){

    }
    int countOfPassenger;
    public Plane(int countOfPassenger)
    {
        this.countOfPassenger = countOfPassenger;
    }
}
