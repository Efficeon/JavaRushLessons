package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * 5. Реализация метода run для Consumer:
 5.1. Усыпить трэд на 0.5 секунды
 5.2. В бесконечном цикле заберите элемент из очереди методом take
 и выведите в консоль "Processing item.toString()".
  */
public class Consumer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        ShareItem item = null;
        try
        {
            Thread.sleep(500);
            while (true) {
                if (!Thread.currentThread().isInterrupted()) {
                    item = queue.take();
                    System.out.println("Processing " + item);
                }
            }
        }
        catch (InterruptedException e)
        {
            //e.printStackTrace();
        }

    }
}
