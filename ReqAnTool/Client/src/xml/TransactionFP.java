package xml;

import Model_Interfaces.ClassOfTransactionFP;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;

@XmlAccessorType(XmlAccessType.FIELD)

public class TransactionFP
{
  private int det;
  private int ftr;
  private ArrayList<String> referenceIDs;
  @XmlElement(name="Transaction_Function_Point")
  private ClassOfTransactionFP type;
  private String reqID;

  public ArrayList<String> getReferenceIDs() {
    return referenceIDs;
  }

  public void setReferenceIDs(ArrayList<String> referenceIDs) {
    this.referenceIDs = referenceIDs;
  }

  public String getReqID() {
    return reqID;
  }

  public void setReqID(String reqID) {
    this.reqID = reqID;
  }

  public TransactionFP()
  {
    // Default-Constructor
  }

  public TransactionFP(int det, int ftr, ArrayList<String> referenceIDs, ClassOfTransactionFP type, String reqID)
  {
    this.det = det;
    this.ftr = ftr;
    this.referenceIDs = referenceIDs;
    this.type = type;
    this.reqID = reqID;
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
  
  public void setDet(int det)
  {
    this.det = det;
  }

  public void setFtr(int ftr)
  {
    this.ftr = ftr;
  }

  public void setType(ClassOfTransactionFP type)
  {
    this.type = type;
  }

  public ClassOfTransactionFP getType()
  {
    return type;
  }
}
