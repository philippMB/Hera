package xml;

import Model_Interfaces.ICostEstimation;
import Model_Interfaces.IDataFP;
import Model_Interfaces.ITransactionFP;
import Model_Interfaces.IWeightFactor;
import java.util.ArrayList;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)

/**
 * Class to hold the CostEstimation of the requirement analysis.
 * This class provides JAXB support and can be accessed via the {@link ICostEstimation} Interface.
 * Getter and Setter must be provided to be JAXB conform.
 * It is implemented in the {@link CustomXMLFormat}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see ICostEstimation
 * @see CustomXMLFormat
 */
public class CostEstimation
  implements  ICostEstimation
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

  /**
   * The constructor for the CostEstimation class.
   * The data from the original CostEstimation instance is copied into this JAXB conform class.
   * @param origin The CostEstimation instance from the original {@link Model_Interfaces.IRequirementAnalysis} which holds
   *               all the data that has to be stored in the XML file.
   * @param dataFPs The DataFunctionPoint array already in the custom format.
   * @param transactionFPs The TransactionFunctionPoint array already in the custom format.
   * @param weightFactors The WeightFactor array already in the custom format
   */
  public CostEstimation(ICostEstimation origin, ArrayList<DataFP> dataFPs, ArrayList<TransactionFP> transactionFPs,
                        ArrayList<WeightFactor> weightFactors )
  {
    functionPoints = origin.getFunctionPoints();
    manMonth = origin.getManMonth();
    dataFPList = dataFPs;
    transactionFPList = transactionFPs;
    weightFactorList = weightFactors;
  }

  /**
   * The default constructor for the CostEstimation class.
   * Must be provided to be JAXB conform.
   */
  public CostEstimation()
  {
  }

  public double getFunctionPoints()
  {
    return functionPoints;
  }

  public double getManMonth()
  {
    return manMonth;
  }

  public ArrayList<DataFP> getDataFPList()
  {
    return dataFPList;
  }

  @Override
  public ArrayList<IDataFP> getDataFPs() {
    ArrayList<IDataFP> dataFPs = new ArrayList<>();
    for (IDataFP obj : dataFPList)
    {
      dataFPs.add(obj);
    }
    return dataFPs;
  }

  @Override
  public ArrayList<ITransactionFP> getTransactionFPs() {
    ArrayList<ITransactionFP> transFPs = new ArrayList<>();
    for (ITransactionFP obj : transactionFPList)
    {
      transFPs.add(obj);
    }
    return transFPs;  }

  public ArrayList<TransactionFP> getTransactionFPList()
  {
    return transactionFPList;
  }

  @Override
  public ArrayList<IWeightFactor> getWeightFactors() {
    ArrayList<IWeightFactor> weightFPs = new ArrayList<>();
    for (IWeightFactor obj : weightFPs)
    {
      weightFPs.add(obj);
    }
    return weightFPs;  }

  public ArrayList<WeightFactor> getWeightFactorList()
  {
    return weightFactorList;
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

  public void setTransactionFPList(ArrayList<TransactionFP> transactionFPList)
  {
    this.transactionFPList = transactionFPList;
  }

  public void setWeightFactorList(ArrayList<WeightFactor> weightFactorList)
  {
    this.weightFactorList = weightFactorList;
  }

  @Override
  public IWeightFactor getWeightFactorByTitle(String title) {
    // TODO: javadoc, nicht implementiert
    return null;
  }

  @Override
  public boolean hasIDDataFP(String id) {
    // TODO: javadoc, nicht implementiert
    return false;
  }

  @Override
  public boolean hasIDTransactionFP(String id) {
    // TODO: javadoc, nicht implementiert
    return false;
  }

  @Override
  public IDataFP getDataFPByID(String id) {
    // TODO: javadoc, nicht implementiert
    return null;
  }

  @Override
  public ITransactionFP getTransactionFPByID(String id) {
    // TODO: javadoc, nicht implementiert
    return null;
  }

  @Override
  public double sumOfWeightFactors() {
    return 0;
  }

  @Override
  public void calculateFP() {
    // TODO: javadoc, nicht implementiert
  }

  @Override
  public void calculateManMonth() {
    // TODO: javadoc, nicht implementiert
  }
}
