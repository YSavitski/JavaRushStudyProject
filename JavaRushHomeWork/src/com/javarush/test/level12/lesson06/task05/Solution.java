package com.javarush.test.level12.lesson06.task05;

/* Классы Cat и Dog от Pet
Унаследуй классы Cat и Dog от Pet.
Реализуй недостающие методы. Классы Cat и Dog не должны быть абстрактными.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static abstract class Pet
    {
        public abstract String getName() throws IOException;
        public abstract Pet getChild();
    }

    public static class Cat extends Pet
    {
        public String getName() throws IOException
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = null;
            name = reader.readLine();
            return name;
        }

        public Pet getChild()
        {
            return new Cat();
        }
    }

    public static class Dog extends Pet
    {
        public String getName() throws IOException
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = null;
            name = reader.readLine();
            return name;
        }

        public Pet getChild()
        {
            return new Dog();
        }

    }

}
