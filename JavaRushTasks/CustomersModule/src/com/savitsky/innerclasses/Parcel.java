package com.savitsky.innerclasses;

/**
 * Created by 07ers on 2/19/2017.
 */
public class Parcel {

    private class PContents implements Contents{
         private int i =11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination{
        private String label;
        private PDestination(String label){
            this.label = label;
        }
        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s){
        return new PDestination(s);
    }

    public Contents contents(){
        return new PContents();
    }
}
