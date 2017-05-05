package Model;

import Model_Interfaces.ErrorCodes;
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

    ProductData(String id, String content, String attribute, String maxCount, RequirementList<IRequirement> references)
    {
        super(id, references);
        this.content = content;
        this.attribute = attribute;
        this.maxCount = maxCount;
    }

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

    public ErrorCodes edit(String id, String content, String attribute, String maxCount, RequirementList<IRequirement> myReferences)
    {
        super.edit(id, myReferences);
        this.content = content;
        this.attribute = attribute;
        this.maxCount = maxCount;
        return ErrorCodes.NO_ERROR;
    }
}
