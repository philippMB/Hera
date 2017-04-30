package xml;

public class CostEstimation
{
  private double functionPoints;
  private double manMonth;

  public CostEstimation(double functionPoints, double manMonth)
  {
    this.functionPoints = functionPoints;
    this.manMonth = manMonth;
  }

  public double getFunctionPoints()
  {
    return functionPoints;
  }

  public double getManMonth()
  {
    return manMonth;
  }
}
