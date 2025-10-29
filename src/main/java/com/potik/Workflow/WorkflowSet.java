package com.potik.Workflow;

import com.potik.Enums.Status;
import com.potik.Interfaces.AbstractWorkflowElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkflowSet extends AbstractWorkflowElement
{
    private final List<WorkflowSequence> threadSequences = new ArrayList<WorkflowSequence>();

    public WorkflowSet(WorkflowSequence sequence1, WorkflowSequence sequence2, AbstractWorkflowElement next)
    {
        super(next);
        addSequence(sequence1);
        addSequence(sequence2);
    }

    public void addSequence(WorkflowSequence sequence)
    {
        threadSequences.add(sequence);
    }

    @Override
    public String getName()
    {
        return "Set";
    }

    @Override
    public void run()
    {
        status = Status.RUNNING;

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (WorkflowSequence sequence : threadSequences)
        {
            executorService.execute(sequence);
        }

        executorService.shutdown();
        try
        {
            status = executorService.awaitTermination(1, TimeUnit.MINUTES) ? Status.SUCCESS : Status.FAILURE;
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}