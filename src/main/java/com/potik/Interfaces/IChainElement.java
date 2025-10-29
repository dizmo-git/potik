package com.potik.Interfaces;

public interface IChainElement<T>
{
    public T GetNext();
    public void SetNext(T next);
}