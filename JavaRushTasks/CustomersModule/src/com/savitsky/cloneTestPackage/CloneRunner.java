package com.savitsky.cloneTestPackage;

/**
 * Created by esavitski on 17.04.2017.
 */
public class CloneRunner {
    private static void mutation(Student p){
        try {
            p = (Student) p.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        p.setId(100);
        System.out.println("->id = " + p.getId());
    }

    public static void main(String[] args){
        Student st = new Student(71);
        System.out.println("id = " + st.getId());

        mutation(st);
        System.out.println("id = " + st.getId());
    }
}
