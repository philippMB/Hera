package xml;

import Model_Interfaces.IWeightFactor;

/**
 * Class to hold the WeightFactors of the requirement analysis.
 * This class provides JAXB support and can be accessed via the {@link IWeightFactor} Interface.
 * Getter and Setter must be provided to be JAXB conform.
 * It is implemented in the {@link CustomXMLFormat}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see IWeightFactor
 * @see CustomXMLFormat
 */
public class WeightFactor
    implements IWeightFactor
{
    private String title;
    private int value;
    private int maxValue;

    /**
     * The constructor for the WeightFactor class.
     * The data from the original WeightFactor instance is copied into this JAXB conform class.
     * @param origin The WeightFactor instance from the original {@link Model_Interfaces.IRequirementAnalysis} which holds
     *               all the data that has to be stored in the XML file.
     */
    public  WeightFactor(IWeightFactor origin)
    {
        title = origin.getTitle();
        value = origin.getValue();
        maxValue = origin.getMaxValue();
    }

    /**
     * The default constructor for the WeightFactor class.
     * Must be provided to be JAXB conform.
     */
    public WeightFactor()
    {
    }

    public String getTitle()
  {
    return title;
  }

    public int getValue()
  {
    return value;
  }

    public int getMaxValue()
  {
    return maxValue;
  }
  
    public void setTitle(String title)
  {
    this.title = title;
  }

    public void setValue(int value)
  {
    this.value = value;
  }

    public void setMaxValue(int maxValue)
  {
    this.maxValue = maxValue;
  }
}
