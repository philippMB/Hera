package Model;

import Model_Interfaces.ICostEstimation;

import Model_Interfaces.IDataFP;
import Model_Interfaces.IRequirement;

import Model_Interfaces.ITransactionFP;

import Model_Interfaces.IWeightFactor;

import java.util.ArrayList;

public class CostEstimation 
    implements ICostEstimation
{
    private double FPcount;
    private double manMonthCount;
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

    public CostEstimation()
    {
        this.FPcount = -1.0;
        this.manMonthCount = -1.0;
        myDataFPs = new ArrayList<IDataFP>();
        myTransactionFPs = new ArrayList<ITransactionFP>();
        myWeightFactors = new ArrayList<IWeightFactor>();
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
    
}
