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
    private IRequirement reference;
    private Complexities myComplexity;
    private int fPValue;

    public TransactionFP(ClassOfTransactionFP type, IRequirement reference, int det, int ftr)
    {
        this.type = type;
        this.reference = reference;
        this.det = det;
        this.ftr = ftr;
        this.fPValue = -1;
    }

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
    public IRequirement getRequirement()
    {
        return reference;

    }

    private void calculateComplexity(ComplexityMatrix myComplexityMatrix)
    {
        myComplexity = myComplexityMatrix.getDetFtrValue(det, ftr);
    }

    public int getFPvalue(ComplexityMatrix myComplexityMatrix, ComplexityWeightMatrix myComplexityWeightMatrix)
    {
        if (fPValue == -1)
        {
            calculateComplexity(myComplexityMatrix);
            fPValue = myComplexityWeightMatrix.getFPvalue(myComplexity, type);
        }
        return fPValue;

    }

    public void edit(ClassOfTransactionFP type, int det, int ftr)
    {
        this.type = type;
        this.det = det;
        this.ftr = ftr;
        this.fPValue = -1;

    }
}
