package xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public class TransactionFP
{
  private int det;
  private int ftr;
  private ArrayList<String> referenceIDs;
  private TransactionFPType type;

  public TransactionFP(int det, int ftr)
  {
    this.det = det;
    this.ftr = ftr;
  }

  public int getDet()
  {
    return det;
  }

  public int getFtr()
  {
    return ftr;
  }
  
  // für JavaBeans
  
  public TransactionFP()
  {
    
  }
  
  public void setDet(int det)
  {
    this.det = det;
  }

  public void setFtr(int ftr)
  {
    this.ftr = ftr;
  }

  public void setType(TransactionFPType type)
  {
    this.type = type;
  }

  public TransactionFPType getType()
  {
    return type;
  }
}
