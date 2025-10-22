package com.potik.Tasks.Mock;

import com.potik.Enums.Status;
import com.potik.Interfaces.IExecutable;

public class MockFailureTask implements IExecutable
{
    @Override
    public Status Execute()
    {
        return Status.FAILURE;
    }
}