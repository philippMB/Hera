package xml;

import Model_Interfaces.IProductData;

/**
 * Class to hold the ProductData of the requirement analysis.
 * This class provides JAXB support and can be accessed via the {@link IProductData} Interface.
 * Getter and Setter must be provided to be JAXB conform.
 * It is implemented in the {@link CustomXMLFormat}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see IProductData
 * @see CustomXMLFormat
 */
public class ProductData
        extends Requirement
        implements IProductData
{
    private String attribute;
    private String content;
    private String maxCount;

    /**
     * The constructor for the ProductData class.
     * The data from the original ProductData instance is copied into this JAXB conform class.
     * @param origin The ProductData instance from the original {@link Model_Interfaces.IRequirementAnalysis} which holds
     *               all the data that has to be stored in the XML file.
     */
    public ProductData(IProductData origin)
    {
        super(origin);
        attribute = origin.getAttribute();
        content = origin.getContent();
        maxCount = origin.getMaxCount();
    }

    /**
     * The default constructor for the ProductData class.
     * Must be provided to be JAXB conform.
     */
    public ProductData()
    {
    }

    public String getAttribute()
  {
    return attribute;
  }

    public String getContent()
  {
    return content;
  }

    public String getMaxCount()
  {
    return maxCount;
  }

    public void setAttribute(String attribute)
  {
    this.attribute = attribute;
  }

    public void setContent(String content)
  {
    this.content = content;
  }

    public void setMaxCount(String maxCount)
  {
    this.maxCount = maxCount;
  }
}
