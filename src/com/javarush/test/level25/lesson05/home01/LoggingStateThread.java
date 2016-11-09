package com.javarush.test.level25.lesson05.home01;

public class LoggingStateThread extends Thread
{
    Thread target;

    LoggingStateThread(Thread thread){
        this.target = thread;
        setDaemon(true);
    }

    @Override
    public void run()
    {
        State state = this.target.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != this.target.getState())
            {
                state = this.target.getState();
                System.out.println(state);
            }
        }
    }
}
