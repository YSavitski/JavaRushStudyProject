package com.savitsky.reusingclasses.composition;

/**
 * Created by 07ers on 2/19/2017.
 */
public class Car {
    public Engine engine = new Engine();
    public Wheel[] wheels = new Wheel[4];
    public Door leftDoor = new Door(), rightDoor = new Door();

    public Car(){
        for(int i=0; i<wheels.length; i++){
            wheels[i] = new Wheel();
        }
    }

    public static void main(String[] args){
        Car car = new Car();
        car.engine.service();
    }

}

class Engine {
    public void start(){}
    public void rev(){}
    public void stop(){}
    public void service(){
        System.out.println(this.getClass().getSimpleName() + ": " + "sevice()");
    }
}

class Window{
    public void rollup(){}
    public void rolldown(){}
}

class Wheel {
    public void inflate(int psi){}
}

class Door {
    public Window window = new Window();
    public void open(){}
    public void close(){}
}