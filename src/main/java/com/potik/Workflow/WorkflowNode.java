package com.potik.Workflow;

import com.potik.Enums.Status;
import com.potik.Interfaces.IExecutable;
import com.potik.Interfaces.AbstractWorkflowElement;

public class WorkflowNode extends AbstractWorkflowElement
{
    private final IExecutable task;

    public WorkflowNode(IExecutable task, AbstractWorkflowElement next)
    {
        super(next);
        this.task = task;
    }

    public WorkflowNode(IExecutable task)
    {
        super(null);
        this.task = task;
    }

    public String GetName()
    {
        String taskName = task.getClass().getSimpleName();
        return "Node(" + taskName + ")";
    }

    public void Run()
    {
        this.status = this.task.Execute();
    }

    public AbstractWorkflowElement GetNext()
    {
        return next;
    }

    public void SetNext(AbstractWorkflowElement next)
    {
        this.next = next;
    }
}
