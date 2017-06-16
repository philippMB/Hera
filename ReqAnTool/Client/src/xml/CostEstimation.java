package xml;

import java.util.ArrayList;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class CostEstimation
{
  private double functionPoints;
  private double manMonth;
  @XmlElementWrapper(name="Data_FunctionPoints")
  @XmlElement(name="FunctionPoint")
  private ArrayList<DataFP> dataFPList;
  @XmlElementWrapper(name="Transaction_FunctionPoints")
  @XmlElement(name="FunctionPoint")
  private ArrayList<TransactionFP> transactionFPList;
  @XmlElementWrapper(name="Weightfactors")
  @XmlElement(name="Factor")
  private ArrayList<WeightFactor> weightFactorList;

  public CostEstimation(double functionPoints, double manMonth, ArrayList<DataFP> dataFPList,
                        ArrayList<TransactionFP> transactionFPList, ArrayList<WeightFactor> weightFactorList)
  {
    this.functionPoints = functionPoints;
    this.manMonth = manMonth;
    this.dataFPList = dataFPList;
    this.transactionFPList = transactionFPList;
    this.weightFactorList = weightFactorList;
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
     // Default-Constructor
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
