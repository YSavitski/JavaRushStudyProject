package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by 07ers on 1/31/2017.
 */
public class Hippodrome {
    private ArrayList<Horse> horses = new ArrayList<>();


    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public static Hippodrome game;
    public static void main(String[] args){
        game = new Hippodrome();

        Horse horse1 = new Horse("Horse_1", 3, 0);
        Horse horse2 = new Horse("Horse_2", 3, 0);
        Horse horse3 = new Horse("Horse_3", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();

    }

    public void move(){
        for (Horse horse:
                getHorses()) {
            horse.move();
        }
    }

    public void print(){
        for (Horse horse:
             getHorses()) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public void run(){
        for(int i=0; i<100; i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        printWinner();
    }

    public Horse getWinner(){
        Horse winner = null;
        double maxDistance = 0;
        for (Horse horse:
             getHorses()) {
            if(horse.getDistance() >= maxDistance){
                maxDistance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }
}
