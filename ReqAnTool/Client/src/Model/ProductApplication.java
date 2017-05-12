package Model;

import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IProductApplication;

public class ProductApplication 
    implements IProductApplication 
{

    private String description;

    public ProductApplication()
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
