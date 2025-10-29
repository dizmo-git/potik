package com.potik.Workflow;

import com.potik.Interfaces.AbstractWorkflowElement;

public class WorkflowInstance
{
    private final WorkflowSequence sequence;

    public WorkflowInstance(WorkflowSequence sequence)
    {
        this.sequence = sequence;
    }

    public void Run()
    {
        sequence.Run();
    }
}