package Model;

import Model_Interfaces.IProductData;

import Model_Interfaces.IRequirement;

import java.util.ArrayList;
import java.util.List;

public class ProductData
    extends Requirement
    implements IProductData
{

    private String content;
    private String attribute;
    private String maxCount;

    @Override
    public String getAttribute()
    {
        return attribute;
    }

    @Override
    public String getContent()
    {
        return content;
    }

    @Override
    public String getMaxCount()
    {
        return maxCount;
    }
    
}
