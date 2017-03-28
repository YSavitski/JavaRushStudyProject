package com.javarush.task.task29.task2909.human;

/**
 * Created by esavitski on 28.03.2017.
 */
public class Soldier extends Human{
    private boolean isSoldier;
    public Soldier(String name, int age) {
        super(name, age);
        this.isSoldier = true;
    }

    public void live() {
        if (isSoldier)
            fight();
    }

    public void fight() {
    }

    public void setBloodGroup(int code){
        super.setBloodGroup(code);
    }

    public int getBloodGroup(){
        return super.getBloodGroup();
    }
}
