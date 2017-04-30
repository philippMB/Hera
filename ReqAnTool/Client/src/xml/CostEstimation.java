package xml;

public class CostEstimation
{
  private int functionPoints;
  private int manMonth;

  public CostEstimation(int functionPoints, int manMonth)
  {
    this.functionPoints = functionPoints;
    this.manMonth = manMonth;
  }

  public int getFunctionPoints()
  {
    return functionPoints;
  }

  public int getManMonth()
  {
    return manMonth;
  }
}
