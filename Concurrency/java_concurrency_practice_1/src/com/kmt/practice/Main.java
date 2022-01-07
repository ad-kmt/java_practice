package com.kmt.practice;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from the main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.start();
        System.out.println("Hello again from main thread");

        //anonymous class
        new Thread() {
            @Override
            public void run() {
                System.out.println("Hello from anonymous class thread");
            }
        }.start();

        //anonymous class, lambda expression
        new Thread(() -> System.out.println("Hello from anonymous class thread")).start();

        //Thread from Runnable implementation.
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        //Interrupting a thread
//        anotherThread.interrupt();

        //Anonymous runnable thread
        Thread myRunnableThread2 = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println("Hello from the anonymous implementation of Runnable.");
                try {
                    anotherThread.join(2000);
                    System.out.println("Another thread terminated, so I'm running again.");
                } catch (InterruptedException e) {
                    System.out.println("I couldn't wait after all. I was interrupted");
                }
            }
        });

        myRunnableThread2.start();
    }
}
