package com.savitsky.blinovBook.chapter_04.variant_A;

/**
 * Created by esavitski on 17.04.2017.
 */
public class RunnerClass {
    public static void main(String[] args){
        Computer computer1 = new Computer();
        computer1.show_computer_info();

        System.out.println();
        Computer computer2 = new Computer(new Winchester(100));
        computer2.show_computer_info();

    }
}
