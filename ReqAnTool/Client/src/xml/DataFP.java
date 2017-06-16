package xml;

import Model_Interfaces.ClassOfDataFP;
import Model_Interfaces.IRequirement;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)

public class DataFP
{
  private int det;
  private int ret;
  private ArrayList<String> referenceIDs;
  // TODO enum in JAXB
  @XmlElement(name="Data_Function_Point")
  private ClassOfDataFP type;
  private String reqID;

    public String getReqID() {
        return reqID;
    }

    public void setReqID(String reqID) {
        this.reqID = reqID;
    }

    public DataFP()
  {
    // Default-Constructor
  }

  public void setReferenceIDs(ArrayList<String> referenceIDs)
  {
    this.referenceIDs = referenceIDs;
  }

  public ArrayList<String> getReferenceIDs()
  {
    return referenceIDs;
  }

  public void setType(ClassOfDataFP type)
  {
    this.type = type;
  }

  public ClassOfDataFP getType()
  {
    return type ;
  }

  public DataFP(int det, int ret, ArrayList<String> referenceIDs, ClassOfDataFP type, String reqID)
  {
    this.det = det;
    this.ret = ret;
    this.referenceIDs = referenceIDs;
    this.type = type;
    this.reqID = reqID;
  }

  public int getDet()
  {
    return det;
  }

  public int getRet()
  {
    return ret;
  }

  // für JavaBeans
  
  public void setDet(int det)
  {
    this.det = det;
  }

  public void setRet(int ret)
  {
    this.ret = ret;
  }
}
