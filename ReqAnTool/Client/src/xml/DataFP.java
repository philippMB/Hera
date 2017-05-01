package xml;

public class DataFP
{
  private int det;
  private int ret;

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
