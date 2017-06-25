package xml;

import Model_Interfaces.ClassOfDataFP;
import Model_Interfaces.IDataFP;
import Model_Interfaces.IRequirement;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)

public class DataFP
    implements IDataFP
{
    private int det;
    private int ret;
    private ArrayList<String> referenceIDs;
    // TODO enum in JAXB
    @XmlElement(name="Data_Function_Point")
    private ClassOfDataFP type;
    private String reqID;

    public DataFP(IDataFP origin)
    {
      det = origin.getDet();
      ret = origin.getRet();
        // TODO: in echt nachher so?:
        // referenceIDs = origin.getRequirement().getReferenceIDs();
        referenceIDs = null;
        type = origin.getType();
      // TODO:
        // reqID = origin.getRequirement().getID();
        reqID = null;
    }

    public DataFP()
    {
        // Default-Constructor
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

    public IRequirement getRequirement() {
        // Nicht implementiert
        return null;
    }
}
