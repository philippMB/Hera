package Model;

import Model_Interfaces.*;

import java.util.ArrayList;

public class CostEstimation 
    implements ICostEstimation
{
    private double FPcount;
    private double manMonthCount;
    private ComplexityWeightMatrix myComplexityWeightMatrix;
    private ComplexityMatrix myComplexityMatrix;
    /**
     * @associates <{Model.TransactionFP}>
     */
    private ArrayList<ITransactionFP> myTransactionFPs;
    /**
     * @associates <{Model.DataFP}>
     */
    private ArrayList<IDataFP> myDataFPs;

    /**
     * @associates <{Model.WeightFactor}>
     */
    private ArrayList<IWeightFactor> myWeightFactors;

    public CostEstimation(ComplexityWeightMatrix myWeightMatrix, ComplexityMatrix myComplexityMatrix)
    {
        this.FPcount = -1.0;
        this.manMonthCount = -1.0;
        myDataFPs = new ArrayList<IDataFP>();
        myTransactionFPs = new ArrayList<ITransactionFP>();
        myWeightFactors = new ArrayList<IWeightFactor>();
        this.myComplexityWeightMatrix = myWeightMatrix;
        this.myComplexityMatrix = myComplexityMatrix;
    }

    @Override
    public void calculateFP()
    {

        // TODO Implement this method
    }

    @Override
    public void calculateManMonth()
    {
        // TODO Implement this method
    }

    @Override
    public double getFunctionPoints()
    {
        return FPcount;
    }

    @Override
    public double getManMonth()
    {
        return manMonthCount;
    }

    @Override
    public ArrayList<IDataFP> getDataFPs()
    {
        return myDataFPs;
    }

    @Override
    public ArrayList<ITransactionFP> getTransactionFPs()
    {
        return myTransactionFPs;
    }

    @Override
    public IWeightFactor getWeightFactorByTitle(String title)
    {
        // TODO
        return null;
    }

    @Override
    public boolean hasIDDataFP(String id)
    {
        return false;
    }

    @Override
    public boolean hasIDTransactionFP(String id)
    {
        return false;
    }

    @Override
    public IDataFP getDataFPByID(String id)
    {
        return null;
    }

    @Override
    public ITransactionFP getTransactionFPByID(String id)
    {
        return null;
    }

    @Override
    public ArrayList<IWeightFactor> getWeightFactors()
    {
        return myWeightFactors;
    }

    public ArrayList<ErrorCodes> rateWeightFactor(ArrayList<Integer> values)
    {
        ArrayList<ErrorCodes> retValue = new AdditionList<ErrorCodes>();
        if (values.size() == getWeightFactors().size())
        {
            int i = 0;
            WeightFactor tmp;
            for (Integer value : values)
            {
                tmp = (WeightFactor) myWeightFactors.get(i);
                retValue.add(tmp.setValue(value));
            }
            return retValue;
        }
        else
        {
            retValue.add(ErrorCodes.INVALID_ARGUMENT);
            return retValue;
        }
    }

    public ErrorCodes setDataFP(ClassOfDataFP type, IRequirement requirement, int det, int ret)
    {
        Validator myValidator = new Validator();
        if (myValidator.areValidValues(det, ret))
        {
            DataFP myDataFP = new DataFP(type, requirement, det, ret);
            myDataFPs.add(myDataFP);
            return ErrorCodes.NO_ERROR;
        }
        else
        {
            return ErrorCodes.INVALID_ARGUMENT;
        }

    }

    public ErrorCodes setTransactionFP(ClassOfTransactionFP type, IRequirement reference, int det, int ftr)
    {
        Validator myValidator = new Validator();
        if (myValidator.areValidValues(det, ftr))
        {
            TransactionFP myTransactionFP = new TransactionFP(type, reference, det, ftr);
            myTransactionFPs.add(myTransactionFP);
            return ErrorCodes.NO_ERROR;
        }
        else
        {
            return ErrorCodes.INVALID_ARGUMENT;
        }

    }

}
