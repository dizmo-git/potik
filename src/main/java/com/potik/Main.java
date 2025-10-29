package com.potik;

import com.potik.Singletons.FileLogger;
import com.potik.Tasks.ConsoleLogTask;
import com.potik.Tasks.FileLogTask;
import com.potik.Tasks.Mock.MockTask;
import com.potik.Tasks.SleepTask;
import com.potik.Workflow.*;

public class Main
{
    public static void  main(String[] args)
    {
        //Instantiate singletons
        FileLogger logger = new FileLogger();

        WorkflowNode n1_3 = new WorkflowNode(new ConsoleLogTask("Tr1: 3"));
        WorkflowNode n1_2 = new WorkflowNode(new ConsoleLogTask("Tr1: 2"), n1_3);
        WorkflowNode n1_1 = new WorkflowNode(new ConsoleLogTask("Tr1: 1"), n1_2);
        WorkflowSequence sequence1 = new WorkflowSequence(n1_1);

        WorkflowNode n2_3 = new WorkflowNode(new ConsoleLogTask("Tr2: 3"));
        WorkflowNode n2_2 = new WorkflowNode(new ConsoleLogTask("Tr2: 2"), n2_3);
        WorkflowNode n2_1 = new WorkflowNode(new ConsoleLogTask("Tr2: 1"), n2_2);
        WorkflowSequence sequence2 = new WorkflowSequence(n2_1);

        //Create nodes and tasks for them
        WorkflowNode node2 = new WorkflowNode
        (
            new ConsoleLogTask("WORKFLOW FINISH")
        );
        WorkflowSet set = new WorkflowSet
        (
            new WorkflowSequence(sequence1),
            new WorkflowSequence(sequence2),
            node2
        );
        WorkflowNode node1 = new WorkflowNode
        (
            new ConsoleLogTask("WORKFLOW START"),
            set
        );


        //Create and run Workflow
        WorkflowManager manager = new WorkflowManager();
        manager.addWorkflow("work", new WorkflowInstance(new WorkflowSequence(node1)));
        manager.runWorkflow("work");
    }
}