package xml;

import Model.ComplexityMatrix;
import Model.ComplexityWeightMatrix;
import Model_Interfaces.*;

import java.util.ArrayList;
import java.util.Map;
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

    /**
     * Get the DataFunctionPoints of the CustomXMLFormat.
     * Required by IRequirementAnalysis. Have to be converted one by one because of the xml binding for JAXB.
     * @return Arraylist of IDataFP.
     */
    @Override
    public ArrayList<IDataFP> getDataFPs() {
        ArrayList<IDataFP> dataFPs = new ArrayList<>();
        for (IDataFP obj : dataFPList)
        {
            dataFPs.add(obj);
        }
        return dataFPs;
    }

    /**
     * Get the TransactionFunctionPoints of the CustomXMLFormat.
     * Required by IRequirementAnalysis. Have to be converted one by one because of the xml binding for JAXB.
     * @return Arraylist of ITransactionFP.
     */
    @Override
    public ArrayList<ITransactionFP> getTransactionFPs()
    {
        ArrayList<ITransactionFP> transFPs = new ArrayList<>();
        for (ITransactionFP obj : transactionFPList)
        {
            transFPs.add(obj);
        }
        return transFPs;
    }

    public ArrayList<TransactionFP> getTransactionFPList()
    {
        return transactionFPList;
    }

    /**
     * Get the WeightFactors of the CustomXMLFormat.
     * Required by IRequirementAnalysis. Have to be converted one by one because of the xml binding for JAXB.
     * @return Arraylist of IWeightFactor.
     */
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

    /**
     * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
     * functionality.
     * @param title
     * @return always null
     */
    @Override
    public IWeightFactor getWeightFactorByTitle(String title) {
        return null;
    }

    /**
     * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
     * functionality.
     * @param id
     * @return always false
     */
    @Override
    public boolean hasIDDataFP(String id) {
        return false;
    }

    /**
     * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
     * functionality.
     * @param id
     * @return always false
     */
    @Override
    public boolean hasIDTransactionFP(String id) {
        return false;
    }

    /**
     * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
     * functionality.
     * @param id
     * @return always null
     */
    @Override
    public IDataFP getDataFPByID(String id) {
        return null;
    }

    /**
     * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
     * functionality.
     * @param id
     * @return always null
     */
    @Override
    public ITransactionFP getTransactionFPByID(String id) {
        return null;
    }

    /**
     * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
     * functionality.
     * @return always null
     */
    @Override
    public Map<IClassOfFP, ComplexityMatrix> getComplexityMatrices() {
        return null;
    }

    /**
     * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
     * functionality.
     * @return always null
     */
    @Override
    public ComplexityWeightMatrix getComplexityWeightMatrix() {
        return null;
    }

    /**
     * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
     * functionality.
     */
    @Override
    public void calculateFP() {
    }

    /**
     * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
     * functionality.
     */
    @Override
    public void calculateManMonth() {
    }
}
