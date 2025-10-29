package com.potik.Workflow;

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
        this.tail.setNext(node);
        this.tail = node;
    }

    @Override
    public String getName()
    {
        return "Sequence";
    }

    public void run()
    {
        AbstractWorkflowElement currentElement = this.head;
        int elementNumber = 1;

        workflowLoop: do
        {
            switch (currentElement.getStatus())
            {
                case INIT -> currentElement.run();
                case SUCCESS -> {
                    currentElement = currentElement.getNext();
                    elementNumber++;
                }
                case FAILURE -> {
                    failAndStop(currentElement, elementNumber);
                    break workflowLoop;
                }
            }
        }
        while (currentElement != null);
    }

    private void failAndStop(AbstractWorkflowElement currentElement, int elementNumber)
    {
        System.out.println("Element " + elementNumber + ": " + currentElement.getName() + " has failed");
    }

    @Override
    public AbstractWorkflowElement getNext() {
        return null;
    }

    @Override
    public void setNext(AbstractWorkflowElement next) {

    }
}