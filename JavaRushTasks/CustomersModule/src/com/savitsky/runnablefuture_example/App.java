package com.savitsky.runnablefuture_example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by 07ers on 3/23/2017.
 */
public class App {
    private static final Logger logger = Logger.getLogger("App");

    public static void main(String[] args){
        ExecutorService executorService = (ExecutorService) Executors.newCachedThreadPool();
        ResultTask[] resultTasks = new ResultTask[5];

        for (int i=0; i<resultTasks.length; i++){
            ExecutableTask executableTask = new ExecutableTask(String.format("Task %d",i));
            resultTasks[i] = new ResultTask(executableTask);
            executorService.submit(resultTasks[i]);
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, e.getLocalizedMessage());
            e.printStackTrace(System.err);
        }
/*
        for (ResultTask task:
             resultTasks) {
            task.cancel(true);
        }*/

        for (int i = 0; i < resultTasks.length; i++) {
            resultTasks[i].cancel(true);
        }


        for(int i=0; i<resultTasks.length; i++){
            try {
                if (resultTasks[i].isCancelled()) {
                    logger.info("Task" + i + " was cancelled.");
                } else if (resultTasks[i].isDone()) {
                    logger.info(resultTasks[i].get().toString());
                }
            } catch (InterruptedException | ExecutionException e) {
                logger.log(Level.SEVERE, e.getLocalizedMessage());
                e.printStackTrace(System.err);
            }
        }

        executorService.shutdown();
    }
}
