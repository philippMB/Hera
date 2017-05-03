package Model_Interfaces;

import java.util.ArrayList;

/**
 * Created by phlippe on 26.04.17.
 */

public interface ICostEstimation 
{
    
    public void calculateFP();
    
    public void calculateManMonth();
    
    public double getFunctionPoints();
    
    public double getManMonth();
    
    public ArrayList<IDataFP> getDataFPs();
    
    public ArrayList<ITransactionFP> getTransactionFPs();

    public boolean hasIDDataFP(String ID);

    public boolean hasIDTransaktionFP(String ID);

    public IDataFP getDataFPByID(String ID);

    public ITransactionFP getTransactionFPByID(String ID);
    
}
