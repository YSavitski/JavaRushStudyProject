package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    Thread externaThread;
    public LoggingStateThread(Thread thread){
        System.out.println(thread.getState());
        externaThread = thread;
        externaThread.setDaemon(true);
    }

    @Override
    public void run(){
        Thread.State state = externaThread.getState();
        while (state!= State.TERMINATED){
            if(state != externaThread.getState()){
                state = externaThread.getState();
                System.out.println(state);
            }
        }
    }
}
