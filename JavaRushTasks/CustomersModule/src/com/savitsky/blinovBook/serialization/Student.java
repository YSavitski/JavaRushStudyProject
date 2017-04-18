package com.savitsky.blinovBook.serialization;

import java.io.Serializable;

/**
 * Created by esavitski on 18.04.2017.
 */
public class Student implements Serializable {
    protected static String faculty;
    private String name;
    private int id;
    private transient String password;
    private static final long serialVersionUID = 1L;

    public Student(String nameFaculty, String name, int id, String password){
        faculty = nameFaculty;
        this.name = name;
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "\nfaculty " + faculty + "\nname " + name + "\nID " + id + "\npassword " + password;
    }
}
