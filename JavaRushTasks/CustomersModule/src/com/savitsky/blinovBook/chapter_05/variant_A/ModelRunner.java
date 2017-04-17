package com.savitsky.blinovBook.chapter_05.variant_A;

/**
 * Created by esavitski on 17.04.2017.
 */
public class ModelRunner {
    public static void main(String[] args){
        Mobile apple = new Mobile("Apple");

        apple.addModel("iphone_4s", 4.1f, 512, 16);
        apple.addModel("iphone_5s", 4.7f, 1536, 16);

        apple.showAllMobiles();

        Mobile samsung = new Mobile("Samsung");
        samsung.showAllMobiles();
    }
}
