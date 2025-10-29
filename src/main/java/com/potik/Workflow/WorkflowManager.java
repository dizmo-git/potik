package com.potik.Workflow;

import java.util.HashMap;
import java.util.Map;

public class WorkflowManager
{
    private final Map<String, WorkflowInstance> workflows = new HashMap<>();

    public void addWorkflow(String name, WorkflowInstance workflow)
    {
        workflows.put(name, workflow);
    }

    public void runWorkflow(String name)
    {
        workflows.get(name).run();
    }
}