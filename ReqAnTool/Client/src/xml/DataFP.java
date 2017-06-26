package xml;

import Model_Interfaces.ClassOfDataFP;
import Model_Interfaces.IDataFP;
import Model_Interfaces.IRequirement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)

/**
 * Class to hold the DataFunctionPoint of the requirement analysis.
 * This class provides JAXB support and can be accessed via the {@link IDataFP} Interface.
 * Getter and Setter must be provided to be JAXB conform.
 * It is implemented in the {@link CustomXMLFormat}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see IDataFP
 * @see CustomXMLFormat
 */
public class DataFP
    implements IDataFP
{
    private int det;
    private int ret;
    private ArrayList<String> referenceIDs;
    @XmlElement(name="Data_Function_Point")
    private ClassOfDataFP type;
    private String reqID;

    /**
     * The constructor for the DataFP class.
     * The data from the original DataFP instance is copied into this JAXB conform class.
     * @param origin The DataFP instance from the original {@link Model_Interfaces.IRequirementAnalysis} which holds
     *               all the data that has to be stored in the XML file.
     */
    public DataFP(IDataFP origin)
    {
      det = origin.getDet();
      ret = origin.getRet();
      referenceIDs = origin.getRequirement().getReferenceIDs();
      referenceIDs = null;
      type = origin.getType();
      reqID = origin.getRequirement().getID();
      reqID = null;
    }

    /**
     * The default constructor for the DataFP class.
     * Must be provided to be JAXB conform.
     */
    public DataFP()
    {
    }

    public int getDet()
    {
        return det;
    }

    public int getRet()
    {
        return ret;
    }

    public ArrayList<String> getReferenceIDs()
    {
        return referenceIDs;
    }

    public ClassOfDataFP getType()
    {
        return type ;
    }

    public String getReqID() {
        return reqID;
    }

    public void setDet(int det)
    {
        this.det = det;
    }

    public void setRet(int ret)
    {
        this.ret = ret;
    }

    public void setReferenceIDs(ArrayList<String> referenceIDs)
  {
    this.referenceIDs = referenceIDs;
  }

    public void setType(ClassOfDataFP type)
  {
    this.type = type;
  }

    public void setReqID(String reqID) {
        this.reqID = reqID;
    }

    /**
     * This method from the {@link IDataFP} interface is not implemented, because only the data should be available,
     * no functionality should be provided.
     * @return Always returns null.
     */
    public IRequirement getRequirement() {
        return null;
    }
}
