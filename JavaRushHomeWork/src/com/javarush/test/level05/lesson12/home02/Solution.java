package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут
        Man man1 = new Man("Zhenia", 22, "Minsk");
        Man man2 = new Man("Maks", 24, "Minsk");
        man1.Show();
        man2.Show();

        Woman woman1 = new Woman("Alesia", 21, "Minsk");
        Woman woman2 = new Woman("Anna", 22, "Minsk");
        woman1.Show();
        woman2.Show();

        //выведи их на экран тут
    }

    public static class Man
    {
        private String name = null;
        private int age = 0;
        private String address = null;

        public Man(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public void Show()
        {
            System.out.println(name + " " + age + " " + address);
        }
    }

    public static class Woman
    {
        private String name = null;
        private int age = 0;
        private String address = null;

        public Woman(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
        public void Show()
        {
            System.out.println(name + " " + age + " " + address);
        }
    }

    //добавьте тут ваши классы
}
