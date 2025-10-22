package com.potik.Tasks.Mock;

import com.potik.Enums.Status;
import com.potik.Interfaces.IExecutable;

public class MockSuccessTask  implements IExecutable
{
    @Override
    public Status Execute()
    {
        return Status.SUCCESS;
    }
}