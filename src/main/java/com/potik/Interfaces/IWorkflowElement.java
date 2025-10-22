package com.potik.Interfaces;

import com.potik.Enums.Status;

public interface IWorkflowElement
{
    public Status Status();
    public IWorkflowElement GetNext();
    public String GetTaskName();
    public void SetNext(IWorkflowElement next);
    public void Run();
}