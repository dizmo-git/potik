package com.potik.Interfaces;

import com.potik.Enums.Status;

public abstract class AbstractWorkflowElement implements Runnable, IChainElement<AbstractWorkflowElement>
{
    protected AbstractWorkflowElement next;
    protected Status status = Status.INIT;

    public abstract String getName();
    public abstract void run();

    public AbstractWorkflowElement(AbstractWorkflowElement next)
    {
        this.next = next;
    }

    public Status getStatus()
    {
        return status;
    }
}