package com.javarush.test.level20.lesson10.home05;

import com.javarush.test.level14.lesson06.home01.Country;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution implements Serializable{


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("Out.qw");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

        Person person = new Person("Yauheni", "Savitski", "Belarus", Sex.MALE);
        System.out.println(person);
        out.writeObject(person);
        out.close();

        Person new_person = (Person) in.readObject();
        System.out.println(new_person);
        in.close();
    }


    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        final transient String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        public String toString(){
            return this.firstName + " " + this.lastName + " " + this.greetingString + " " + this.country + " " + this.sex + "\n" + this.logger;
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}
