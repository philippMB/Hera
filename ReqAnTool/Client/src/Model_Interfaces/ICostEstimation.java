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

    public ArrayList<IWeightFactor> getWeightFactors();

    public IWeightFactor getWeightFactorByTitle(String title);

    public boolean hasIDDataFP(String id);

    public boolean hasIDTransactionFP(String id);

    public IDataFP getDataFPByID(String id);

    public ITransactionFP getTransactionFPByID(String id);
}
