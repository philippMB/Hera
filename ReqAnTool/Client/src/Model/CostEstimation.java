package Model;

import Model_Interfaces.ICostEstimation;

import java.util.ArrayList;

public class CostEstimation 
    implements ICostEstimation
{
    private double FPcount;
    private double manMonthCount;

    /**
     * @associates <{Model.TransactionFP}>
     */
    private ArrayList<TransactionFP> myTransactionFPs;

    /**
     * @associates <{Model.DataFP}>
     */
    private ArrayList<DataFP> myDataFPs;

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
    public void getFunctionPoints()
    {
        // TODO Implement this method
    }

    @Override
    public void getManMonth()
    {
        // TODO Implement this method
    }
}
