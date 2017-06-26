package xml;

import Model_Interfaces.IProductApplication;

/**
 * Class to hold the ProductApplication of the requirement analysis.
 * This class provides JAXB support and can be accessed via the {@link IProductApplication} Interface.
 * Getter and Setter must be provided to be JAXB conform.
 * It is implemented in the {@link CustomXMLFormat}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see IProductApplication
 * @see CustomXMLFormat
 */
public class ProductApplication
    implements IProductApplication
{
    private String description;

    /**
     * The constructor for the ProductAppplication class.
     * The data from the original ProductApplication instance is copied into this JAXB conform class.
     * @param origin The ProductApplication instance from the original {@link Model_Interfaces.IRequirementAnalysis} which holds
     *               all the data that has to be stored in the XML file.
     */
    public ProductApplication(IProductApplication origin)
    {
        description = origin.getDescription();
    }

    /**
     * The default constructor for the ProductAppliaction class.
     * Must be provided to be JAXB conform.
     */
    public ProductApplication()
    {
    }

    public String getDescription()
  {
    return description;
  }

    public void setDescription(String description)
  {
    this.description = description;
  }
}
