package xml;

import Model_Interfaces.ClassOfTransactionFP;
import Model_Interfaces.IRequirement;
import Model_Interfaces.ITransactionFP;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)

public class TransactionFP
  implements ITransactionFP
{
  private int det;
  private int ftr;
  private ArrayList<String> referenceIDs;
  @XmlElement(name="Transaction_Function_Point")
  private ClassOfTransactionFP type;
  private String reqID;

  public TransactionFP(ITransactionFP origin)
  {
    det = origin.getDet();
    ftr = origin.getFtr();
    // TODO:
    // referenceIDs = origin.getRequirement().getReferenceIDs();
    referenceIDs = null;
    type = origin.getType();
    // TODO:
    // reqID = origin.getRequirement().getID();
    reqID = null;
  }

  public TransactionFP()
  {
    // Default-Constructor
  }

  public int getDet()
  {
    return det;
  }

  public int getFtr()
  {
    return ftr;
  }

  public ArrayList<String> getReferenceIDs() {
    return referenceIDs;
  }

  public ClassOfTransactionFP getType()
  {
    return type;
  }

  public String getReqID() {
    return reqID;
  }

  public void setDet(int det)
  {
    this.det = det;
  }

  public void setFtr(int ftr)
  {
    this.ftr = ftr;
  }

  public void setReferenceIDs(ArrayList<String> referenceIDs) {
    this.referenceIDs = referenceIDs;
  }

  public void setType(ClassOfTransactionFP type)
  {
    this.type = type;
  }

  public void setReqID(String reqID) {
    this.reqID = reqID;
  }

  @Override
  public IRequirement getRequirement() {
    // nicht implementiert
    return null;
  }
}
