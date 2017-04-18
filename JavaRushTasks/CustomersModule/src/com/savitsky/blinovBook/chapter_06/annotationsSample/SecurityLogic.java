package com.savitsky.blinovBook.chapter_06.annotationsSample;

import java.lang.reflect.Method;

/**
 * Created by esavitski on 18.04.2017.
 */
public class SecurityLogic {
    public void onInvoke(SecurityLevelEnum level, Method method, Object[] args){
        StringBuilder argsString = new StringBuilder();
        for (Object arg:
             args) {
            argsString.append(arg.toString() + " :");
        }
        argsString.setLength(argsString.length()-1);
        System.out.println(String.format("Method %S was invoked with parameters: %s", method.getName(), argsString.toString()));

        switch (level){
            case LOW:
                System.out.println("Low level of security check: " + level);
                break;
            case NORMAL:
                System.out.println("Normal level of security check: " + level);
                break;
            case HIGH:
                System.out.println("High level of security check: " + level);
                break;
        }
    }
}
