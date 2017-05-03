package Model_Interfaces;


/**
 * Created by phlippe on 26.04.17.
 */
public interface ITransactionFP 
{
    
    public int getDET();
    
    public int getFTR();
    
    public ClassOfTransactionFP getType();
    
    public IRequirement getReference();
    
}