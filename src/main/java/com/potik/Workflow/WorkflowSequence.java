package com.potik.Workflow;

import com.potik.Enums.Status;
import com.potik.Interfaces.AbstractWorkflowElement;

public class WorkflowSequence extends AbstractWorkflowElement
{
    private final AbstractWorkflowElement head;
    private AbstractWorkflowElement tail;

    public WorkflowSequence(AbstractWorkflowElement headNode)
    {
        super(null);
        this.head = headNode;
        this.tail = headNode;
    }

    public void AddNode(AbstractWorkflowElement node)
    {
        this.tail.SetNext(node);
        this.tail = node;
    }

    @Override
    public String GetName()
    {
        return "Sequence";
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

    @Override
    public AbstractWorkflowElement GetNext() {
        return null;
    }

    @Override
    public void SetNext(AbstractWorkflowElement next) {

    }
}