package Model;

import Model_Interfaces.IRequirement;
import Model_Interfaces.ITransactionFP;

public class TransactionFP
    implements ITransactionFP
{
    private ClassOfTransactionFP type;
    private int det;
    private int ftr;
    private Requirement reference;

    @Override
    public int getDET()
    {
        // TODO Implement this method
        return 0;
    }

    @Override
    public int getFTR()
    {
        // TODO Implement this method
        return 0;
    }

    @Override
    public ClassOfTransactionFP getType()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public IRequirement getReference()
    {
        // TODO Implement this method
        return null;
    }
}
