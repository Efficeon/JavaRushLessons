package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

/**
 * Created by lion on 08.05.16.
 */
public class Consumer implements Runnable
{
    protected BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {

        while (true) {
            String x="";
            try{
                x = (String) queue.take();
                System.out.println(x);
            }
            catch (InterruptedException e){}
        }
    }
}
