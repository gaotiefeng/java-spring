package com.example.thread;

public class MessageThread extends Thread {

    @Override
    public void run()
    {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

            System.out.println("exception");
        }
        System.out.println("start new thread!");
    }
}
