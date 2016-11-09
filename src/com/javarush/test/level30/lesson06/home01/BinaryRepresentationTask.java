package com.javarush.test.level30.lesson06.home01;


import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String>
{
    final private int i;
    public BinaryRepresentationTask(int i)
    {
        this.i = i;
    }

    @Override
    protected String compute()
    {
        int a = i % 2;
        int b = i / 2;
        String result = String.valueOf(a);

        if (b > 0)
        {
            BinaryRepresentationTask f1 = new BinaryRepresentationTask(a);
            BinaryRepresentationTask f2 = new BinaryRepresentationTask(b);
            f1.fork();
            return f2.compute() + f1.join();
        }
        return result;
    }
}
