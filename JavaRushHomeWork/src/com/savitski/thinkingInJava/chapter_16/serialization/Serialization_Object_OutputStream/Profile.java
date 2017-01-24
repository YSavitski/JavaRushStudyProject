package com.savitski.thinkingInJava.chapter_16.serialization.Serialization_Object_OutputStream;

import java.io.Serializable;

/**
 * Created by esavitski on 24.01.2017.
 */
public class Profile implements Serializable {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
