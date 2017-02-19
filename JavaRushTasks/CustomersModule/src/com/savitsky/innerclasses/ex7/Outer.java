package com.savitsky.innerclasses.ex7;

/**
 * Created by 07ers on 2/19/2017.
 */
public class Outer {
    private String privteField = "some string";
    private void showPrivateField(){
        System.out.println(privteField);
    }

    public void createInner(){
        Inner inner = new Inner();
        inner.modify();
    }

    class Inner{
        public void modify(){
            Outer.this.privteField = "modified string";
            Outer.this.showPrivateField();
        }
    }
}
