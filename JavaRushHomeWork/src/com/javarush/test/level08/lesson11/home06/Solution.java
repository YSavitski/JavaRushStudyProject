package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите  тут ваш код
        Human son_1 = new Human("son_1", true, 13, null);
        Human son_2 = new Human("son_2", true, 15, null);
        Human doughter = new Human("doughter", false, 10, null);

        ArrayList<Human> children = new ArrayList<Human>();
        children.add(son_1); children.add(son_2); children.add(doughter);
        Human mother = new Human("mother", false, 45, children);
        Human father = new Human("father", true, 47, children);

        ArrayList<Human> motherCH = new ArrayList<Human>();
        motherCH.add(mother);
        Human gr_mother1 = new Human("gr_mother1", false, 70, motherCH);
        Human gr_father1 = new Human("gr_father1", true, 71, motherCH);

        ArrayList<Human> fatherCH = new ArrayList<Human>();
        fatherCH.add(father);
        Human gr_mother_2 = new Human("gr_mother2", false, 72, fatherCH);
        Human gr_father_2 = new Human("gr_father2", true, 75, fatherCH);

        ArrayList<Human> family = new ArrayList<Human>();
        family.add(gr_father_2); family.add(gr_mother_2); family.add(gr_father1); family.add(gr_mother1);
        family.add(father); family.add(mother); family.add(son_1); family.add(son_2); family.add(doughter);
        for (Human person:
             family)
        {
            System.out.println(person);
        }

    }

    public static class Human
    {
        //напишите тут ваш код
        private String name = null;
        private boolean sex = true;
        private int age = 0;
        private ArrayList<Human> children = null;

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children != null ? this.children.size() : 0;
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }
            return text;
        }
    }

}
