package Model;

import Exceptions.ListOverflowException;
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

    public void edit(String description) throws Exception
    {
        if (description.length() > 20000)
        {
            throw new ListOverflowException(String.class, "Environment Description");
        }
        this.description = description;

    }

}
