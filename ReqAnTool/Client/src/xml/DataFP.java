package xml;

import Model_Interfaces.ClassOfDataFP;

import java.util.ArrayList;

public class DataFP
{
  private String id;
  private int det;
  private int ret;
  private ArrayList<String> referenceIDs;
  // TODO enum in JAXB
  private ClassOfDataFP type;

  public void setId(String id)
  {
    this.id = id;
  }

  public String getId()
  {
    return id;
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
    return type;
  }

  public DataFP(int det, int ret)
  {
    this.det = det;
    this.ret = ret;
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
  
  public DataFP()
  {
    
  }
  
  public void setDet(int det)
  {
    this.det = det;
  }

  public void setRet(int ret)
  {
    this.ret = ret;
  }
}
