package Model;

import Model_Interfaces.IProductApplication;

public class ProductApplication 
    implements IProductApplication 
{

    private String description;

    @Override
    public String getDescription()
    {
        return description;
    }

}
