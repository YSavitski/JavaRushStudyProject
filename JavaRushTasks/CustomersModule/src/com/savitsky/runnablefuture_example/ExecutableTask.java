package com.savitsky.runnablefuture_example;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by 07ers on 3/23/2017.
 */
public class ExecutableTask implements Callable<String> {
    private static final Logger logger = Logger.getLogger("ExecutableTask");

    private String name;

    public ExecutableTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String call() throws Exception {
        try{
            long duration = (long)(Math.random()*10);
            logger.info(String.format("%s: Waiting %l seconds for reslt", this.name, duration));
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException ex){
            logger.log(Level.SEVERE, ex.getLocalizedMessage());
            ex.printStackTrace(System.err);
        }

        return String.format("Hello, world. I'm %s", this.name);
    }
}
