package xml;

import java.util.ArrayList;

public class CostEstimation
{
  private double functionPoints;
  private double manMonth;
  private ArrayList<DataFP> dataFPList;
  private ArrayList<TransactionFP> transactionFPList;
  private ArrayList<WeightFactor> weightFactorList;

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
  
  // für JavaBeans
  
  public CostEstimation()
  {
     
  }
  
  public void setFunctionPoints(double functionPoints)
  {
    this.functionPoints = functionPoints;
  }

  public void setManMonth(double manMonth)
  {
    this.manMonth = manMonth;
  }

  public void setDataFPList(ArrayList<DataFP> dataFPList)
  {
    this.dataFPList = dataFPList;
  }

  public ArrayList<DataFP> getDataFPList()
  {
    return dataFPList;
  }

  public void setTransactionFPList(ArrayList<TransactionFP> transactionFPList)
  {
    this.transactionFPList = transactionFPList;
  }

  public ArrayList<TransactionFP> getTransactionFPList()
  {
    return transactionFPList;
  }

  public void setWeightFactorList(ArrayList<WeightFactor> weightFactorList)
  {
    this.weightFactorList = weightFactorList;
  }

  public ArrayList<WeightFactor> getWeightFactorList()
  {
    return weightFactorList;
  }
}
