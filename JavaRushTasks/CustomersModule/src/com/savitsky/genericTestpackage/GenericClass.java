package com.savitsky.genericTestpackage;

/**
 * Created by esavitski on 17.04.2017.
 */
public class GenericClass <T> {
    private T value;

    public GenericClass(){

    }

    public GenericClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString(){
        if(value == null){
            return null;
        }
        else {
            return String.format("%s : %s", value.getClass().getName(), value);
        }
    }
}
