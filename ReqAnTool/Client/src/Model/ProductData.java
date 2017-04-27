package Model;

import Model_Interfaces.IProductData;

import java.util.List;

public class ProductData
    extends Requirement
    implements IProductData
{

    private String content;
    private String attribute;
    private String maxCount;

}
