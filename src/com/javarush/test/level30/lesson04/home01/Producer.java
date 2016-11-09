package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {

        try
        {
            for (int i = 1; i < 10; i++) {
                if (!Thread.currentThread().isInterrupted()) {
                    System.out.println(String.format("Элемент 'ShareItem-%d' добавлен", i));
                    queue.offer(new ShareItem(String.format("ShareItem-%d", i), i));
                }
                Thread.sleep(100);
                if (queue.hasWaitingConsumer())
                    System.out.println("Consumer в ожидании!");
            }
        }
        catch (InterruptedException e)
        {
            //e.printStackTrace();
        }

    }
}