package com.potik;

import com.potik.Interfaces.IExecutable;
import com.potik.Singletons.FileLogger;
import com.potik.Tasks.ConsoleLogTask;
import com.potik.Tasks.FileLogTask;
import com.potik.Workflow.WorkflowInstance;
import com.potik.Workflow.WorkflowManager;
import com.potik.Workflow.WorkflowNode;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void  main(String[] args)
    {
        //Instantiate singletons
        FileLogger logger = new FileLogger();

        //Create nodes and tasks for them
        WorkflowNode node3 = new WorkflowNode(new ConsoleLogTask("Hello Workflow!"));
        WorkflowNode node2 = new WorkflowNode
        (
            new FileLogTask("Hello!", "WorkflowLog"),
            node3
        );
        WorkflowNode node1 = new WorkflowNode
        (
                new FileLogTask("Yo!"),
                node2
        );

        //Create and run Workflow
        WorkflowManager manager = new WorkflowManager();
        manager.AddWorkflow("work", new WorkflowInstance(node1));
        manager.RunWorkflow("work");
    }
}