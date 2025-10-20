package com.potik.Singletons;

public class BaseSingleton<T>
{
    private static Object instance;

    protected BaseSingleton()
    {
        if (instance != null)
        {
            throw new IllegalStateException("Already instantiated!");
        }
        instance = this;
    }

    @SuppressWarnings("unchecked")
    public static <T> T instance()
    {
        return (T) instance;
    }
}