package com.potik.Workflow;

import com.potik.Interfaces.AbstractWorkflowElement;

public class WorkflowInstance
{
    private final AbstractWorkflowElement head;
    private AbstractWorkflowElement tail;

    public WorkflowInstance(AbstractWorkflowElement headNode)
    {
        this.head = headNode;
        this.tail = headNode;
    }

    public void AddNode(AbstractWorkflowElement node)
    {
        this.tail.SetNext(node);
        this.tail = node;
    }

    public void Run()
    {
        AbstractWorkflowElement currentElement = this.head;
        int elementNumber = 1;

        workflowLoop: do
        {
            switch (currentElement.GetStatus())
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

    private void FailAndStop(AbstractWorkflowElement currentElement, int elementNumber)
    {
        System.out.println("Element " + elementNumber + ": " + currentElement.GetName() + " has failed");
    }
}