package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grFather1 = new Human("Andrew", true, 65, null, null);
        Human grFather2 = new Human("Vijacheslav", true, 71, null, null);
        Human grMother1 = new Human("Anna", false, 64, null, null);
        Human grMother2 = new Human("Anna", false, 69, null, null);

        Human father = new Human("Nikolay", true, 42, grFather2, grMother2);
        Human mother = new Human("Tatiana", false, 39, grFather1, grMother1);

        Human son1 = new Human("Zhenia", true, 15, father, mother);
        Human son2 = new Human("Max", true, 15, father, mother);
        Human doughter = new Human("Anna", false, 11, father, mother);

        System.out.println(grFather1.toString()); System.out.println(grMother1.toString());
        System.out.println(grFather2.toString()); System.out.println(grMother2.toString());
        System.out.println(father.toString()); System.out.println(mother.toString());
        System.out.println(son1.toString()); System.out.println(son2.toString()); System.out.println(doughter.toString());

    }

    public static class Human
    {
        //напишите тут ваш код
        private String name = null;
        private boolean sex = true;
        private int age = 0;
        private Human father = null;
        private Human mother = null;

        public Human(String _name, boolean _sex, int _age, Human _father, Human _mother)
        {
            this.name = _name;
            this.sex = _sex;
            this.age = _age;
            this.father = _father;
            this.mother = _mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;
            return text;
        }

    }

}
