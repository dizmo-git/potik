package com.potik.Interfaces;

import com.potik.Enums.Status;

public interface IWorkflowElement
{
    public Status Status();
    public IWorkflowElement GetNext();
    public void SetNext(IWorkflowElement next);
    public void Run();
}