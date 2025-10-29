package com.potik.Workflow;

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

    public String getName()
    {
        String taskName = task.getClass().getSimpleName();
        return "Node(" + taskName + ")";
    }

    public void run()
    {
        this.status = this.task.execute();
    }

    public AbstractWorkflowElement getNext()
    {
        return next;
    }

    public void setNext(AbstractWorkflowElement next)
    {
        this.next = next;
    }
}
