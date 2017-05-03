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
    public ArrayList<IWeightFactor> getWeightFactors()
    {
        return myWeightFactors;
    }
    
}
