package xml;

import Model_Interfaces.INFRequirement;

/**
 * Class to hold the NonFunctionalRequirement of the requirement analysis.
 * This class provides JAXB support and can be accessed via the {@link INFRequirement} Interface.
 * Getter and Setter must be provided to be JAXB conform.
 * It is implemented in the {@link CustomXMLFormat}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see INFRequirement
 * @see CustomXMLFormat
 */
public class NFRequirement
        extends Requirement
        implements INFRequirement
{
    private String title;
    private String actor;
    private String description;

    /**
     * The constructor for the NFRequirement class.
     * The data from the original NFRequirement instance is copied into this JAXB conform class.
     * @param origin The NFRequirement instance from the original {@link Model_Interfaces.IRequirementAnalysis} which holds
     *               all the data that has to be stored in the XML file.
     */
    public NFRequirement(INFRequirement origin)
    {
        super(origin);
        title = origin.getTitle();
        actor = origin.getActor();
        description = origin.getDescription();
    }

    /**
     * The default constructor for the NFRequirement class.
     * Must be provided to be JAXB conform.
     */
    public NFRequirement()
    {
    }

    public String getTitle()
  {
    return title;
  }

    public String getActor()
  {
    return actor;
  }

    public String getDescription()
  {
    return description;
  }

    public void setTitle(String title)
  {
    this.title = title;
  }

    public void setActor(String actor)
  {
    this.actor = actor;
  }

    public void setDescription(String description)
  {
    this.description = description;
  }
}
