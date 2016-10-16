package com.javarush.test.level13.lesson06.task01;

/* Dog, Cat и Mouse
1. Создать классы Dog, Cat и Mouse.
2. Реализовать интерфейсы в добавленных классах, учитывая что:
- Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
- Мышь(Mouse) может передвигаться и может быть съедена.
- Собака(Dog) может передвигаться и съесть кого-то.
*/

public class Solution
{

    public interface Moveable //может двигаться
    {
        void move();
    }

    public interface Eatable  //может быть съеден
    {
        void eaten();
    }

    public interface Eat  //может кого-нибудь съесть
    {
        void eat();
    }

    public static class Cat implements Moveable, Eatable, Eat
    {
        @Override
        public void move()
        {
            System.out.println("Cat is moving now...");
        }

        @Override
        public void eat()
        {
            System.out.println("Cat could eat " + new Mouse().getClass().getSimpleName());
        }

        @Override
        public void eaten()
        {
            System.out.println("Cat could be eaten by " + new Dog().getClass().getSimpleName());
        }
    }
    public static class Mouse implements Moveable, Eatable
    {
        @Override
        public void move()
        {
            System.out.println("Mouse is moving now...");
        }

        @Override
        public void eaten()
        {
            System.out.println("Mouse could be eaten by " + new Cat().getClass().getSimpleName());
        }
    }
    public static class Dog implements Moveable, Eat
    {
        public void move()
        {
            System.out.println("Dog is moving now...");
        }
        public void eat()
        {
            System.out.println("Dog could eat " + new Cat().getClass().getSimpleName());
        }
    }
}
