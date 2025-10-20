package com.potik;

import com.potik.Interfaces.IExecutable;
import com.potik.Singletons.FileLogger;
import com.potik.Tasks.ConsoleLogTask;
import com.potik.Tasks.FileLogTask;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void  main(String[] args)
    {
        FileLogger logger = new FileLogger();

        List<IExecutable> tasks = new ArrayList<IExecutable>();

        tasks.add(new FileLogTask("Test123"));
        tasks.add(new FileLogTask("Test123", "TestFile"));
        tasks.add(new ConsoleLogTask("Hello Workflow!"));

        for (IExecutable t : tasks)
        {
            System.out.println(t.Execute());
        }
    }
}