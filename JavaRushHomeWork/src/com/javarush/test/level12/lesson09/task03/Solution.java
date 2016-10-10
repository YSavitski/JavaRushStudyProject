package com.javarush.test.level12.lesson09.task03;

/* Fly, Move, Eat для классов Dog, Car, Duck, Airplane
Есть public интерфейсы Fly(летать), Move(передвигаться), Eat(есть).
Добавь эти интерфейсы классам Dog(собака), Car(автомобиль), Duck(утка), Airplane(самолет).
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public interface Fly
    {
        public void fly();
    }

    public interface Move
    {
        public void move();
    }

    public interface Eat
    {
        public void eat();
    }

    public class Dog implements Move, Eat
    {
        public void move()
        {
            System.out.println("Dog is moving now...");
        }
        public void eat()
        {
            System.out.println("Dog is eating now...");
        }
    }

    public class Duck implements Fly, Move, Eat
    {
        public void move()
        {
            System.out.println("Duck is moving now...");
        }
        public void eat()
        {
            System.out.println("Duck is eating now...");
        }
        public void fly()
        {
            System.out.println("Duck is flying now...");
        }
    }

    public class Car implements Move
    {
        public void move()
        {
            System.out.println("Duck is moving now...");
        }
    }

    public class Airplane implements Move, Fly
    {
        public void move()
        {
            System.out.println("Duck is moving now...");
        }
        public void fly()
        {
            System.out.println("Duck is flying now...");
        }
    }
}
