
package Model_Interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by phlippe on 26.04.17.
 */
public interface IFRequirement
    extends IRequirement
{

    public String getTitle();

    public String getActor();

    public String getDescription();

}
