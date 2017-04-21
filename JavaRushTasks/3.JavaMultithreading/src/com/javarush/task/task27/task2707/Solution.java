package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }
    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Thread thread = new Thread() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        };

        Object objMax = o1.hashCode() > o2.hashCode() ? o1 : o2;
        Object objMin = o1.hashCode() > o2.hashCode() ? o2 : o1;

        synchronized (objMax){
            synchronized (objMin) {
                thread.start();
                Thread.sleep(10);
                System.out.println(thread.getState().toString());
                return thread.getState()== Thread.State.BLOCKED;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
