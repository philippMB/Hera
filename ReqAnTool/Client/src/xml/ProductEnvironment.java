package xml;

import Model_Interfaces.IProductEnvironment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)

/**
 * Created by Philipp on 29.06.17.
 */
public class ProductEnvironment
    implements IProductEnvironment
{
    private String description;

    /**
     * Default constructor for ProductEnvironment.
     * Required by JAXB
     */
    public ProductEnvironment()
    {
    }

    public ProductEnvironment(IProductEnvironment origin)
    {
        description = origin.getDescription();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
