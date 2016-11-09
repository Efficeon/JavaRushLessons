package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lion on 28.05.16.
 */
public class MyThread extends Thread
{
    static AtomicInteger x = new AtomicInteger(0);

    public MyThread()
    {
       init();
    }

    public MyThread(Runnable target)
    {
        super(target);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        init();
    }

    public MyThread(String name)
    {
        super(name);
        init();
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        init();
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        init();
    }

    public void init(){
        x.incrementAndGet();
        if (x.get() > 10) x.set(1);
        this.setPriority(x.get());
    }
}
