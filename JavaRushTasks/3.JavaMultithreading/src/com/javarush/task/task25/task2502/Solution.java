package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;


        public Car() {
            //init wheels here
            if(loadWheelNamesFromDB().length!=4){
                throw new IllegalArgumentException();
            }
            else {
                wheels = new ArrayList<Wheel>();
                for(String wheelStr: loadWheelNamesFromDB()){
                    boolean isWheel = false;
                    for(Wheel wheel: Wheel.values()){
                        if(wheel.toString().equals(wheelStr)){
                            isWheel = true;
                            break;
                        }
                    }
                    if(isWheel){
                        wheels.add(Wheel.valueOf(wheelStr));
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {

    }
}
