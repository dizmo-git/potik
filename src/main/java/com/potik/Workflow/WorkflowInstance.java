package com.potik.Workflow;

import com.potik.Interfaces.IWorkflowElement;

public class WorkflowInstance
{
    private final IWorkflowElement head;
    private IWorkflowElement tail;

    public WorkflowInstance(IWorkflowElement headNode)
    {
        this.head = headNode;
        this.tail = headNode;
    }

    public void AddNode(IWorkflowElement node)
    {
        this.tail.SetNext(node);
        this.tail = node;
    }

    public void Run()
    {
        IWorkflowElement currentElement = this.head;
        int elementNumber = 1;

        workflowLoop: do
        {
            switch (currentElement.Status())
            {
                case INIT -> currentElement.Run();
                case SUCCESS -> {
                    currentElement = currentElement.GetNext();
                    elementNumber++;
                }
                case FAILURE -> {
                    FailAndStop(currentElement, elementNumber);
                    break workflowLoop;
                }
            }
        }
        while (currentElement != null);
    }

    private void FailAndStop(IWorkflowElement currentElement, int elementNumber)
    {
        System.out.println("Task " + elementNumber + ": " + currentElement.GetTaskName() + " has failed");
    }
}