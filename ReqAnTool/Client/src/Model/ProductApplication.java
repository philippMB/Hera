package Model;

import Exceptions.ListOverflowException;
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

    public void edit(String description) throws Exception
    {
        if (description.length()> 20000)
        {
            throw new ListOverflowException(String.class, "Product Description");
        }
        this.description = description;

    }
}
