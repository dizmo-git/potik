package com.potik.Tasks;

import com.potik.Enums.Status;
import com.potik.Interfaces.IExecutable;
import com.potik.Singletons.FileLogger;

public class FileLogTask implements IExecutable
{
    private final String message;
    private final String fileName;

    public FileLogTask(String message)
    {
        this.message = message;
        this.fileName = null;
    }

    public FileLogTask(String message, String fileName)
    {
        this.message = message;
        this.fileName = fileName;
    }

    @Override
    public Status execute()
    {
        try
        {
            FileLogger logger = FileLogger.instance();

            if (fileName == null)
            {
                logger.sessionLog(message);
            }
            else
            {
                logger.logInFile(message, fileName);
            }

            return Status.SUCCESS;
        }
        catch (Exception e)
        {
            return Status.FAILURE;
        }
    }
}
