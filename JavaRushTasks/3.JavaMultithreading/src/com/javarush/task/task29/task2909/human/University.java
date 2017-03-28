package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {

    private String name;
    private int age;
    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        this.students = new ArrayList<>();
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        return this.students.stream()
                .filter((s)->s.getAverageGrade()==averageGrade)
                .findFirst().get();
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        return this.students.stream().max((s1, s2) ->
                Double.compare(s1.getAverageGrade(), s2.getAverageGrade())).get();
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        return this.students.stream().min((s1, s2) ->
                Double.compare(s1.getAverageGrade(), s2.getAverageGrade())).get();
    }

    public void expel(Student student){
        this.students.remove(student);
    }
}