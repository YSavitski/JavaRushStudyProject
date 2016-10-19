package com.javarush.test.level14.lesson08.home05;

/**
 * Created by ESavitsky on 10/20/2016.
 */
public class Computer
{
    private Keyboard keyboard = null;
    private Mouse mouse = null;
    private Monitor monitor = null;

    public Computer()
    {
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();
        this.monitor = new Monitor();
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }
}
