package xml;

import Model_Interfaces.IQualityRequirement;
import Model_Interfaces.Score;

/**
 * Class to hold the QualityRequirement of the requirement analysis.
 * This class provides JAXB support and can be accessed via the {@link IQualityRequirement} Interface.
 * Getter and Setter must be provided to be JAXB conform.
 * It is implemented in the {@link CustomXMLFormat}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see IQualityRequirement
 * @see CustomXMLFormat
 */
public class QualityRequirement
    implements IQualityRequirement
{
    private String criteria;
    private Score value;

    /**
     * The constructor for the QualityRequirement class.
     * The data from the original QualityRequirement instance is copied into this JAXB conform class.
     * @param origin The QualityRequirement instance from the original {@link Model_Interfaces.IRequirementAnalysis}
     *               which holds all the data that has to be stored in the XML file.
     */
    public QualityRequirement(IQualityRequirement origin)
    {
        criteria = origin.getCriteria();
        value = origin.getValue();
    }

    /**
     * The default constructor for the QualityRequirement class.
     * Must be provided to be JAXB conform.
     */
    public QualityRequirement()
    {
    }

    public String getCriteria()
  {
    return criteria;
  }

    public Score getValue() {
    return value;
  }

    public void setCriteria(String criteria)
  {
    this.criteria = criteria;
  }

    public void setValue(Score value) {
        this.value = value;
    }
}

