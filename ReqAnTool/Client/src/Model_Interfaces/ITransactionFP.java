package Model_Interfaces;


/**
 * Created by phlippe on 26.04.17.
 */
public interface ITransactionFP 
{
    
    int getDet();
    
    int getFtr();
    
    ClassOfTransactionFP getType();
    
    IRequirement getRequirement();
    
}