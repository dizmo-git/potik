package com.potik.Workflow;

public class WorkflowInstance
{
    private final WorkflowSequence sequence;

    public WorkflowInstance(WorkflowSequence sequence)
    {
        this.sequence = sequence;
    }

    public void run()
    {
        sequence.run();
    }
}