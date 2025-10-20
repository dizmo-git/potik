package com.potik.Tasks;

import com.potik.Enums.Status;
import com.potik.Interfaces.IExecutable;

public class ConsoleLogTask implements IExecutable
{
    private final String message;

    public ConsoleLogTask(String message)
    {
        this.message = message;
    }

    @Override
    public Status Execute()
    {
        try
        {
            System.out.println(message);
            return Status.SUCCESS;
        }
        catch (Exception e)
        {
            return Status.FAILURE;
        }
    }
}