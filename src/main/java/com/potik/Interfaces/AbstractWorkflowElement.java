package com.potik.Interfaces;

import com.potik.Enums.Status;

public abstract class AbstractWorkflowElement implements IChainElement<AbstractWorkflowElement>
{
    protected AbstractWorkflowElement next;
    protected Status status = Status.INIT;

    public abstract String GetName();
    public abstract void Run();

    public AbstractWorkflowElement(AbstractWorkflowElement next)
    {
        this.next = next;
    }

    public Status GetStatus()
    {
        return status;
    }
}