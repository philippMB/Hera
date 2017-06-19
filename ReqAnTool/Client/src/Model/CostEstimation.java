package Model;

import Model_Interfaces.*;

import java.util.ArrayList;
import java.util.Map;

public class CostEstimation 
    implements ICostEstimation
{
    private double fPCount;
    private double manMonthCount;
    private ComplexityWeightMatrix myComplexityWeightMatrix;
    private Map<IClassOfFP, ComplexityMatrix> myComplexityMatrices;
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

    public CostEstimation(ComplexityWeightMatrix myWeightMatrix, Map<IClassOfFP, ComplexityMatrix> myComplexityMatrices)
    {
        this.fPCount = -1.0;
        this.manMonthCount = -1.0;
        myDataFPs = new ArrayList<IDataFP>();
        myTransactionFPs = new ArrayList<ITransactionFP>();
        myWeightFactors = new ArrayList<IWeightFactor>();
        this.myComplexityWeightMatrix = myWeightMatrix;
        this.myComplexityMatrices = myComplexityMatrices;
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
            int myFPvalue = myTransactionFP.getFPvalue(myComplexityMatrices.get(myITransactionFP.getType()),
                                                       myComplexityWeightMatrix);
            if (myFPvalue != -1) // check for error from getFPvalue (error = -1)
            {
                sumOfWeightedComplexities += myFPvalue;
            }
        }
        for (IDataFP myIDataFP : myDataFPs)
        {
            DataFP myDataFP = (DataFP)myIDataFP;
            int myFPvalue = myDataFP.getFPvalue(myComplexityMatrices.get(myDataFP.getType()),
                                                myComplexityWeightMatrix);
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
        double developmentTime = Math.pow(fPCount, 0.4);
        double personCount = Math.ceil(fPCount / 150);
        this.manMonthCount = developmentTime * personCount;
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
        boolean hasDataFP = false;
        for (IDataFP myDataFP : myDataFPs)
        {
            if (myDataFP.getRequirement().getID().equals(id))
            {
                hasDataFP = true;
            }
        }
        return hasDataFP;
    }

    @Override
    public boolean hasIDTransactionFP(String id)
    {
        boolean hasTransactionFP = false;
        for (ITransactionFP myTransactionFP : myTransactionFPs)
        {
            if (myTransactionFP.getRequirement().getID().equals(id))
            {
                hasTransactionFP = true;
            }
        }
        return hasTransactionFP;
    }

    @Override
    public IDataFP getDataFPByID(String id)
    {
        IDataFP dataFPToReturn = null;
        for (IDataFP myDataFP : myDataFPs)
        {
            if (myDataFP.getRequirement().getID().equals(id))
            {
                dataFPToReturn = myDataFP;
            }
        }
        return dataFPToReturn;
    }

    @Override
    public ITransactionFP getTransactionFPByID(String id)
    {
        ITransactionFP transactionFPToReturn = null;
        for (ITransactionFP myTransactionFP : myTransactionFPs)
        {
            if (myTransactionFP.getRequirement().getID().equals(id))
            {
                transactionFPToReturn = myTransactionFP;
            }
        }
        return transactionFPToReturn;
    }

    @Override
    public ArrayList<IWeightFactor> getWeightFactors()
    {
        return myWeightFactors;
    }

    public ArrayList<ErrorCodes> rateWeightFactor(Map<String, Integer> mapOfWeightFactors)
    {
        ArrayList<ErrorCodes> retValue = new ArrayList<ErrorCodes>();
        if (mapOfWeightFactors.size() == getWeightFactors().size())
        {
            WeightFactor tmp;
            for (String key : mapOfWeightFactors.keySet())
            {
                for (IWeightFactor factor : myWeightFactors)
                {
                    if (factor.getTitle().equals(key))
                    {
                        tmp = (WeightFactor)factor;
                        retValue.add(tmp.setValue(mapOfWeightFactors.get(key)));
                    }
                }
            }
        }
        else
        {
            retValue.add(ErrorCodes.INVALID_ARGUMENT);
        }
        return retValue;

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
        if (myValidator.isValidDET(det) && myValidator.isValidRET(ret))
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
        if (myValidator.isValidDET(det) && myValidator.isValidFTR(ftr))
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
            if (myValidator.isValidDET(det) && myValidator.isValidFTR(ftr))
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
            if (myValidator.isValidDET(det) && myValidator.isValidRET(ret))
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
