<<<<<<< HEAD
package Model_Interfaces;

import java.util.ArrayList;

/**
 * Created by phlippe on 26.04.17.
 */
public interface ICostEstimation {
    public void calculateFP();
    
    public void calculateManMonth();
    
    public double getFunctionPoints();
    
    public double getManMonth();
    
    public ArrayList<IDataFP> getDataFPs();
      
    public ArrayList<ITransactionFP> getTransactionFPs();
}
=======
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
    
}
>>>>>>> 9cdce7ea87eff28f9af5bcaf7ae45e8b6b35d527
