package com.potik.Tasks.Mock;

import com.potik.Enums.Status;
import com.potik.Interfaces.IExecutable;

public class MockTask implements IExecutable
{
    private final float successProbability;

    public MockTask(float successProbability)
    {
        this.successProbability = successProbability;
    }

    @Override
    public Status Execute()
    {
        return Math.random() <= successProbability ? Status.SUCCESS : Status.FAILURE;
    }
}