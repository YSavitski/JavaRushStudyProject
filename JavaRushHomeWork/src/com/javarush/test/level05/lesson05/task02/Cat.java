package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat()
    {
    }

    public boolean fight(Cat anotherCat)
    {
        //напишите тут ваш код
        int score_1 = 0, score_2 = 0;

        if(this.age > anotherCat.age)
        {
            score_1++;
        }
        if(anotherCat.age > this.age)
        {
            score_2++;
        }
        if(this.strength > anotherCat.strength)
        {
            score_1++;
        }
        if(anotherCat.strength > this.strength)
        {
            score_2++;
        }
        if(this.weight > anotherCat.weight)
        {
            score_1++;
        }
        if(anotherCat.weight > this.weight)
        {
            score_2++;
        }

        return score_1 > score_2 ? true : false;





    }
}
