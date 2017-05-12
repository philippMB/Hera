package Model;

import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IProductEnvironment;

/**
 * Created by mbill on 11.05.2017.
 */
public class ProductEnvironment
    implements IProductEnvironment
{

    private String description;

    public ProductEnvironment()
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
