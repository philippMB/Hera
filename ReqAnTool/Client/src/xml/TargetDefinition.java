package xml;

import Model_Interfaces.ITargetDefinition;

/**
 * Class to hold the TargetDefinition of the requirement analysis.
 * This class provides JAXB support and can be accessed via the {@link TargetDefinition} Interface.
 * Getter and Setter must be provided to be JAXB conform.
 * It is implemented in the {@link CustomXMLFormat}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see TargetDefinition
 * @see CustomXMLFormat
 */
public class TargetDefinition
    implements ITargetDefinition
{
    private String description;

    /**
     * The constructor for the TargetDefinition class.
     * The data from the original TargetDefinition instance is copied into this JAXB conform class.
     * @param origin The TargetDefinition instance from the original {@link Model_Interfaces.IRequirementAnalysis} which holds
     *               all the data that has to be stored in the XML file.
     */
    public TargetDefinition(ITargetDefinition origin)
    {
        description = origin.getDescription();
    }

    /**
     * The default constructor for the TargetDefinition class.
     * Must be provided to be JAXB conform.
     */
    public TargetDefinition()
    {
        // Default-Constructor
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
