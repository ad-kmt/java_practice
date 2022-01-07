package com.kmt.practice;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Hello from another thread.");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            System.out.println("Interrupted: Another thread woke me up.");
            return;
        }
        System.out.println("5 seconds have passed and I'm awake.");
    }
}
