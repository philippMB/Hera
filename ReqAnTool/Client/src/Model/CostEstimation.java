package Model;

import Model_Interfaces.*;

import java.util.ArrayList;

public class CostEstimation 
    implements ICostEstimation
{
    private double fPCount;
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
        this.fPCount = -1.0;
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

        int unweightedFPcount = getSumOfDataAndTransactionFPs();
        double factorOfInfluences = determineInfluences();
        this.fPCount = unweightedFPcount * factorOfInfluences;
    }

    private double determineInfluences()
    {
        int sumOfFactors = 0;
        for (IWeightFactor myWeightFactor : myWeightFactors)
        {
            sumOfFactors += myWeightFactor.getValue();
        }
        return (sumOfFactors / 100 + 0.7);
    }

    private int getSumOfDataAndTransactionFPs()
    {
        int sumOfWeightedComplexities = 0;
        for (ITransactionFP myITransactionFP : myTransactionFPs)
        {
            TransactionFP myTransactionFP = (TransactionFP)myITransactionFP;
            int myFPvalue = myTransactionFP.getFPvalue(myComplexityMatrix, myComplexityWeightMatrix);
            if (myFPvalue != -1) // check for error from getFPvalue (error = -1)
            {
                sumOfWeightedComplexities += myFPvalue;
            }
        }
        for (IDataFP myIDataFP : myDataFPs)
        {
            DataFP myDataFP = (DataFP)myIDataFP;
            int myFPvalue = myDataFP.getFPvalue(myComplexityMatrix, myComplexityWeightMatrix);
            if (myFPvalue != -1) // check for error from getFPvalue (error = -1)
            {
                sumOfWeightedComplexities += myFPvalue;
            }
        }
        return sumOfWeightedComplexities;
    }

    @Override
    public void calculateManMonth()
    {
        // rough Estimation by Jones:
        double developementTime = Math.pow(fPCount, 0.4);
        double personCount = Math.ceil(fPCount / 150);
        this.manMonthCount = developementTime * personCount;
    }

    @Override
    public double getFunctionPoints()
    {
        return fPCount;
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
        IWeightFactor myWeightFactor = null;
        for (IWeightFactor factor : myWeightFactors)
        {
            if (factor.getTitle().equals(title))
            {
                myWeightFactor = factor;
            }

        }
        return myWeightFactor;
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
        ArrayList<ErrorCodes> retValue = new ArrayList<ErrorCodes>();
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

    public ErrorCodes setDataFP(ClassOfDataFP type, IRequirement reference, int det, int ret)
    {
        fPCount = -1.0;
        manMonthCount = -1.0;
        Validator myValidator = new Validator();
        for (IDataFP myDataFP : myDataFPs)
        {
            if (myDataFP.getRequirement().equals(reference))
            {
                return ErrorCodes.DUPLICATE;
            }
        }
        if (myValidator.areValidValues(det, ret))
        {
            DataFP myDataFP = new DataFP(type, reference, det, ret);
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
        fPCount = -1.0;
        manMonthCount = -1.0;
        Validator myValidator = new Validator();
        for (ITransactionFP myTransactionFP : myTransactionFPs)
        {
            if (myTransactionFP.getRequirement().equals(reference))
            {
                return ErrorCodes.DUPLICATE;
            }
        }
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

    public ErrorCodes remTransactionFPByID(IRequirement myRefToReq)
    {
        ITransactionFP toRemove = null;
        for (ITransactionFP myTransactionFP : myTransactionFPs)
        {
            if (myTransactionFP.getRequirement().equals(myRefToReq))
            {
                toRemove = myTransactionFP;
            }
        }
        if (toRemove != null)
        {
            myTransactionFPs.remove(toRemove);
            return ErrorCodes.NO_ERROR;
        }
        else
        {
            return ErrorCodes.FP_NOT_EXISTENT;
        }
    }

    public ErrorCodes remDataFPByID(IRequirement myRefToReq)
    {
        IDataFP toRemove = null;
        for (IDataFP myDataFP : myDataFPs)
        {
            if (myDataFP.getRequirement().equals(myRefToReq))
            {
                toRemove = myDataFP;
            }
        }
        if (toRemove != null)
        {
            myDataFPs.remove(toRemove);
            return ErrorCodes.NO_ERROR;
        }
        else
        {
            return ErrorCodes.FP_NOT_EXISTENT;
        }
    }

    public ErrorCodes editTransactionFPByID(ClassOfTransactionFP type, IRequirement myRefToReq, int det, int ftr)
    {
        fPCount = -1.0;
        manMonthCount = -1.0;
        Validator myValidator = new Validator();
        TransactionFP fPtoEdit = null;
        for (ITransactionFP myITransactionFP : myTransactionFPs)
        {
            if (myITransactionFP.getRequirement().equals(myRefToReq))
            {
                fPtoEdit = (TransactionFP)myITransactionFP;
            }
        }
        if (fPtoEdit != null)
        {
            if (myValidator.areValidValues(det, ftr))
            {
                fPtoEdit.edit(type, det, ftr);
                return ErrorCodes.NO_ERROR;
            }
            else
            {
                return ErrorCodes.INVALID_ARGUMENT;
            }
        }
        else
        {
            return ErrorCodes.FP_NOT_EXISTENT;
        }
    }

    public ErrorCodes editDataFPByID(ClassOfDataFP type, IRequirement myRefToReq, int det, int ret)
    {
        fPCount = -1.0;
        manMonthCount = -1.0;
        Validator myValidator = new Validator();
        DataFP fPtoEdit = null;
        for (IDataFP myIDataFP : myDataFPs)
        {
            if (myIDataFP.getRequirement().equals(myRefToReq))
            {
                fPtoEdit = (DataFP)myIDataFP;
            }
        }
        if (fPtoEdit != null)
        {
            if (myValidator.areValidValues(det, ret))
            {
                fPtoEdit.edit(type, det, ret);
                return ErrorCodes.NO_ERROR;
            }
            else
            {
                return ErrorCodes.INVALID_ARGUMENT;
            }
        }
        else
        {
            return ErrorCodes.FP_NOT_EXISTENT;
        }
    }
}
