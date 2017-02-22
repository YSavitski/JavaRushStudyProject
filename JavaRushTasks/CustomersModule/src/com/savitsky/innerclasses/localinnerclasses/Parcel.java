package com.savitsky.innerclasses.localinnerclasses;

/**
 * Created by 07ers on 2/19/2017.
 */
public class Parcel {
    public Destination destination(String str){
        class PDestination implements Destination{
            private String label;
            private PDestination(String label){
                this.label = label;
            }
            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(str);
    }

    public void showResult(String str){
        System.out.println(destination(str).readLabel());
    }
}
