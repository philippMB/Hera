package xml;

public class TransactionFP
{
  private int det;
  private int ftr;

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
}
