package com.potik;

import com.potik.Singletons.FileLogger;
import com.potik.Tasks.FileLogTask;
import com.potik.Tasks.Mock.MockTask;
import com.potik.Tasks.SleepTask;
import com.potik.Workflow.WorkflowInstance;
import com.potik.Workflow.WorkflowManager;
import com.potik.Workflow.WorkflowNode;

public class Main
{
    public static void  main(String[] args)
    {
        //Instantiate singletons
        FileLogger logger = new FileLogger();

        //Create nodes and tasks for them
        //WorkflowNode node3 = new WorkflowNode(new ConsoleLogTask("Hello Workflow!"));
        WorkflowNode node4 = new WorkflowNode(new MockTask(0.5f));
        WorkflowNode node3 = new WorkflowNode
        (
            new SleepTask(3),
            node4
        );
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