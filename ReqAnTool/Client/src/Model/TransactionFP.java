package Model;

import Model_Interfaces.ClassOfTransactionFP;
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
        return det;
    }

    @Override
    public int getFTR()
    {
        return ftr;
    }

    @Override
    public ClassOfTransactionFP getType()
    {
        return type;
    }

    @Override
    public IRequirement getReference()
    {
        return reference;
    }
}
