package com.potik.Tasks;

import com.potik.Enums.Status;
import com.potik.Interfaces.IExecutable;

import java.util.concurrent.TimeUnit;

public class SleepTask  implements IExecutable
{
    private final int seconds;

    public SleepTask(int seconds)
    {
        this.seconds = seconds;
    }

    @Override
    public Status execute()
    {
        try
        {
            TimeUnit.SECONDS.sleep(seconds);
        }
        catch (InterruptedException e)
        {
            return Status.FAILURE;
        }

        return Status.SUCCESS;
    }
}