package xml;

import Model_Interfaces.IAddition;

/**
 * Class to hold the Supplement of the requirement analysis.
 * This class provides JAXB support and can be accessed via the {@link IAddition} Interface.
 * Getter and Setter must be provided to be JAXB conform.
 * It is implemented in the {@link CustomXMLFormat}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see IAddition
 * @see CustomXMLFormat
 */
public class Supplement
    implements IAddition
{
    private String description;
    private String title;

    /**
     * The constructor for the Supplement class.
     * The data from the original Addition instance is copied into this JAXB conform class.
     * @param origin The Addition instance from the original {@link Model_Interfaces.IRequirementAnalysis} which holds
     *               all the data that has to be stored in the XML file.
     */
    public Supplement(IAddition origin)
    {
        description = origin.getDescription();
        title = origin.getTitle();
    }

    /**
     * The default constructor for the Supplement class.
     * Must be provided to be JAXB conform.
     */
    public Supplement()
    {
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
