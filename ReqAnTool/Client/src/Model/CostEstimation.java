package Model;

import Exceptions.DuplicateIDException;
import Exceptions.ListOverflowException;
import Exceptions.UnknownIDException;
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
    private WeightFactorList<IWeightFactor> myWeightFactors;

    public CostEstimation(ComplexityWeightMatrix myWeightMatrix, Map<IClassOfFP, ComplexityMatrix> myComplexityMatrices,
                          WeightFactorList<IWeightFactor> myWeightFactors)
    {
        this.fPCount = -1.0;
        this.manMonthCount = -1.0;
        myDataFPs = new ArrayList<IDataFP>();
        myTransactionFPs = new ArrayList<ITransactionFP>();
        this.myWeightFactors = myWeightFactors;
        this.myComplexityWeightMatrix = myWeightMatrix;
        this.myComplexityMatrices = myComplexityMatrices;
    }

    @Override
    public void calculateFP()
    {

        int unweightedFPcount = getSumOfDataAndTransactionFPs();
        double factorOfInfluences = sumOfWeightFactors();
        this.fPCount = unweightedFPcount * factorOfInfluences;
    }

    public double sumOfWeightFactors()
    {
        int sumOfFactors = 0;
        for (IWeightFactor myIWeightFactor : myWeightFactors)
        {
            WeightFactor myWeightFactor = (WeightFactor) myIWeightFactor;
            sumOfFactors += myWeightFactor.getExactValue();
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

    public WeightFactorList<IWeightFactor> getWeightFactorList()
    {
        return myWeightFactors;
    }

    public void rateWeightFactor(Map<String, Integer> mapOfWeightFactors) throws Exception
    {
        if (mapOfWeightFactors.size() == getWeightFactors().size())
        {
            throw new ListOverflowException(WeightFactorList.class, "given Weight Factor count");
        }
        WeightFactor tmp;
        for (String key : mapOfWeightFactors.keySet())
        {
            for (IWeightFactor factor : myWeightFactors)
            {
                if (factor.getTitle().equals(key))
                {
                    tmp = (WeightFactor)factor;
                    tmp.setValue(mapOfWeightFactors.get(key));
                }
            }
        }

    }

    public void setDataFP(ClassOfDataFP type, IRequirement reference, int det, int ret) throws Exception
    {
        fPCount = -1.0;
        manMonthCount = -1.0;
        Validator myValidator = new Validator();
        for (IDataFP myDataFP : myDataFPs)
        {
            if (myDataFP.getRequirement().equals(reference))
            {
                throw new DuplicateIDException(reference.getID());
            }
        }
        myValidator.validateDET(det);
        myValidator.validateRET(ret);
        DataFP myDataFP = new DataFP(type, reference, det, ret);
        myDataFPs.add(myDataFP);

    }

    public void setTransactionFP(ClassOfTransactionFP type, IRequirement reference, int det, int ftr) throws Exception
    {
        fPCount = -1.0;
        manMonthCount = -1.0;
        Validator myValidator = new Validator();
        for (ITransactionFP myTransactionFP : myTransactionFPs)
        {
            if (myTransactionFP.getRequirement().equals(reference))
            {
                throw new DuplicateIDException(reference.getID());
            }
        }
        myValidator.validateDET(det);
        myValidator.validateFTR(ftr);
        TransactionFP myTransactionFP = new TransactionFP(type, reference, det, ftr);
        myTransactionFPs.add(myTransactionFP);

    }

    public void remTransactionFPByID(IRequirement myRefToReq) throws Exception
    {
        ITransactionFP toRemove = null;
        for (ITransactionFP myTransactionFP : myTransactionFPs)
        {
            if (myTransactionFP.getRequirement().equals(myRefToReq))
            {
                toRemove = myTransactionFP;
            }
        }
        if (toRemove == null)
        {
            throw new UnknownIDException(toRemove.getRequirement().getID());
        }
        myTransactionFPs.remove(toRemove);

    }

    public void remDataFPByID(IRequirement myRefToReq) throws Exception
    {
        IDataFP toRemove = null;
        for (IDataFP myDataFP : myDataFPs)
        {
            if (myDataFP.getRequirement().equals(myRefToReq))
            {
                toRemove = myDataFP;
            }
        }
        if (toRemove == null)
        {
            throw new UnknownIDException(toRemove.getRequirement().getID());
        }
        myDataFPs.remove(toRemove);

    }

    public void editTransactionFPByID(ClassOfTransactionFP type, IRequirement myRefToReq, int det, int ftr)
            throws Exception
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
        if (fPtoEdit == null)
        {
            throw new UnknownIDException(fPtoEdit.getRequirement().getID());
        }
        myValidator.validateDET(det);
        myValidator.validateFTR(ftr);
        fPtoEdit.edit(type, det, ftr);

    }

    public void editDataFPByID(ClassOfDataFP type, IRequirement myRefToReq, int det, int ret) throws Exception
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
        if (fPtoEdit == null)
        {
            throw new UnknownIDException(fPtoEdit.getRequirement().getID());
        }
        myValidator.validateDET(det);
        myValidator.validateRET(ret);
        fPtoEdit.edit(type, det, ret);

    }

    public void setWeightFactors(WeightFactorList<IWeightFactor> weightFactors)
    {
        this.myWeightFactors = weightFactors;

    }

    public void setDataFPs(ArrayList<IDataFP> dataFPs)
    {
        this.myDataFPs = dataFPs;

    }

    public void setTransactionFPs(ArrayList<ITransactionFP> transactionFPs)
    {
        this.myTransactionFPs = transactionFPs;

    }
}
