package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator
{
    String name;
    Thread thread;

    public void run() {

            try{
                while (!thread.isInterrupted()){
                Thread.sleep(0);
                System.out.println(name);
                Thread.sleep(90);}

            }
            catch (InterruptedException e)
            { }

    }

    @Override
    public void start(String threadName)
    {
        this.name = threadName;
        thread = new Thread(this);
        thread.start();

    }

  @Override
    public void stop() {
        thread.interrupt();
    }
}
