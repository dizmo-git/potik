package com.potik.Workflow;

import com.potik.Enums.Status;
import com.potik.Interfaces.IExecutable;
import com.potik.Interfaces.IWorkflowElement;

public class WorkflowNode implements IWorkflowElement
{
    private Status status = Status.INIT;
    private IExecutable task;
    private IWorkflowElement next;

    public WorkflowNode(IExecutable task, IWorkflowElement next)
    {
        this.task = task;
        this.next = next;
    }

    public WorkflowNode(IExecutable task)
    {
        this.task = task;
    }

    public WorkflowNode()
    {
        this.status = null;
        this.next = null;
    }

    public void SetTask(IExecutable task)
    {
        this.task = task;
    }

    @Override
    public void SetNext(IWorkflowElement next)
    {
        this.next = next;
    }

    @Override
    public void Run()
    {
        this.status = this.task.Execute();
    }

    @Override
    public IWorkflowElement GetNext()
    {
        return this.next;
    }

    @Override
    public String GetTaskName()
    {
        return task.getClass().getSimpleName();
    }

    @Override
    public Status Status()
    {
        return this.status;
    }
}
