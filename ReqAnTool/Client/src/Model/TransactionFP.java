package Model;

import Model_Interfaces.ITransactionFP;

public class TransactionFP
    implements ITransactionFP
{
    private ClassOfTransactionFP type;
    private int det;
    private int ftr;
    private Requirement reference;
}
