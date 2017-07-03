package Model;

import Calculations.Complexities;
import Calculations.ComplexityMatrix;
import Calculations.ComplexityWeightMatrix;
import Model_Interfaces.ClassOfTransactionFP;
import Model_Interfaces.IRequirement;
import Model_Interfaces.ITransactionFP;

public class TransactionFP
    implements ITransactionFP
{
    private ClassOfTransactionFP type;
    private int det;
    private int ftr;
    private IRequirement reference;
    private Complexities myComplexity;

    public TransactionFP(ClassOfTransactionFP type, IRequirement reference, int det, int ftr)
    {
        this.type = type;
        this.reference = reference;
        this.det = det;
        this.ftr = ftr;
    }

    @Override
    public int getDet()
    {
        return det;

    }

    @Override
    public int getFtr()
    {
        return ftr;

    }

    @Override
    public ClassOfTransactionFP getType()
    {
        return type;

    }

    @Override
    public IRequirement getRequirement()
    {
        return reference;

    }

    public void edit(ClassOfTransactionFP type, int det, int ftr)
    {
        this.type = type;
        this.det = det;
        this.ftr = ftr;
    }
}
