package Model;

import Model_Interfaces.ErrorCodes;
import Model_Interfaces.ITargetDefinition;

public class TargetDefinition
    implements ITargetDefinition
{

    private String description;

    public TargetDefinition()
    {
        this.description = null;

    }

    @Override
    public String getDescription()
    {
        return description;

    }

    public ErrorCodes edit(String description)
    {
        this.description = description;
        return ErrorCodes.NO_ERROR;

    }
}
