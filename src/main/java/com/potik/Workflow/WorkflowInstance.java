package com.potik.Workflow;

import com.potik.Interfaces.IWorkflowElement;

public class WorkflowInstance
{
    private IWorkflowElement head;
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

        do
        {
            switch (currentElement.Status())
            {
                case INIT -> currentElement.Run();
                case SUCCESS -> currentElement = currentElement.GetNext();
                case FAILURE -> throw new RuntimeException("Workflow element has failed");
            }
        }
        while (currentElement != null);
    }
}