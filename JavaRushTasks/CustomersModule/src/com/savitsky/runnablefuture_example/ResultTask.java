package com.savitsky.runnablefuture_example;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.logging.Logger;

/**
 * Created by 07ers on 3/23/2017.
 */
public class ResultTask extends FutureTask<String> {
    private static final Logger logger = Logger.getLogger("ResultTask");

    private String name;

    public ResultTask(Callable<String> callble){
        super(callble);
        this.name = ((ExecutableTask) callble).getName();
    }

    @Override
    protected void done(){
        if(this.isCancelled()){
            logger.info(this.name + " has been canceled");
        } else if(this.isDone()){
            logger.info(this.name + " has finished");
        }
    }
}
