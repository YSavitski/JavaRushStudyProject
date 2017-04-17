package com.savitsky.cloneTestPackage;

/**
 * Created by esavitski on 17.04.2017.
 */
public class Student implements Cloneable{
    private int id;

    public Student(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
