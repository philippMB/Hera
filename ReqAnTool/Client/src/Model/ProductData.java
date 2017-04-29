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
        // TODO Implement this method
        return null;
    }

    @Override
    public String getContent()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getMaxCount()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getID()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ArrayList<IRequirement> getReferences()
    {
        // TODO Implement this method
        return null;
    }
}
