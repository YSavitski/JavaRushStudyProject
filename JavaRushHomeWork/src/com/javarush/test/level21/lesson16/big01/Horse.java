package com.javarush.test.level21.lesson16.big01;

/**
 * Created by 07ers on 1/31/2017.
 */
public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move(){
        this.distance += speed * Math.random();
    }

    public void print(){
        StringBuilder dotsBuilder = new StringBuilder();
        for(int i=0; i < (int)this.distance; i++){
            dotsBuilder.append(".");
        }
        dotsBuilder.append(this.name);
        System.out.println(dotsBuilder.toString());
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


}
