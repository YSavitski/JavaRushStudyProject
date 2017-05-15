package com.savitsky;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 07ers on 5/8/2017.
 */
public class Product {

    public static void main(String[] args){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1); list1.add(3); list1.add(5);
        list2.add(2); list2.add(4); list2.add(6);

        merge(list1,list2);
        showList(list1);
    }

    public static void showList(ArrayList<Integer> list){
        list.stream().forEach(item -> {
            System.out.print(item + " ");
        });
    }

    public static void merge(ArrayList<Integer> list1, ArrayList<Integer> list2){
        long start = System.nanoTime();


        for (int index1 = 0, index2 = 0; index2 < list2.size(); index1++) {
            if (index1 == list1.size() || list1.get(index1) > list2.get(index2)) {
                list1.add(index1, list2.get(index2++));
            }
        }



        long end = System.nanoTime();
        System.out.println(end-start);
    }
}


