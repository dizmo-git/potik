package com.potik.Interfaces;

public interface IChainElement<T>
{
    public T getNext();
    public void setNext(T next);
}