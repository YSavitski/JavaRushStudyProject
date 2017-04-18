package com.savitsky.blinovBook.chapter_07.localeSamples;

import java.util.Locale;

/**
 * Created by esavitski on 18.04.2017.
 */
public class ResourceManagerRun {
    public static void main(String[] args){
        ResourceManager manager = ResourceManager.INSTANCE;
        System.out.println(manager.getString("str1"));

        manager.changeLocale(new Locale("be", "BY"));
        System.out.println(manager.getString("str1"));
    }
}
