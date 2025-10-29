package com.potik.Interfaces;

import com.potik.Enums.Status;

public interface IWorkflowElement extends IChainElement<IWorkflowElement>
{
    public Status Status();
    public String GetName();
    public void Run();
}