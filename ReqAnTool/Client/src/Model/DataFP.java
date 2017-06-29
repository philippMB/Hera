package Model;

import Model_Interfaces.ClassOfDataFP;
import Model_Interfaces.IDataFP;
import Model_Interfaces.IRequirement;

public class DataFP
    implements IDataFP
{

    private ClassOfDataFP type;
    private int det;
    private int ret;
    private IRequirement reference;
    private Complexities myComplexity;
    private int fPvalue;

    public DataFP(ClassOfDataFP type, IRequirement requirement, int det, int ret)
    {
        this.type = type;
        this.det = det;
        this.ret = ret;
        this.reference = requirement;
        this.fPvalue = -1;
    }

    @Override
    public int getDet()
    {
        return det;
    }

    @Override
    public int getRet()
    {
        return ret;
    }

    @Override
    public IRequirement getRequirement()
    {
        return reference;
    }

    @Override
    public ClassOfDataFP getType()
    {
        return type;
    }

    private void calculateComplexity(ComplexityMatrix myComplexityMatrix)
    {
        myComplexity = myComplexityMatrix.getDetRetValue(det, ret);
    }

    public int getFPvalue(ComplexityMatrix myComplexityMatrix, ComplexityWeightMatrix myComplexityWeightMatrix)
    {
        if (fPvalue == -1) // if already determined: do not calculate
        {
            calculateComplexity(myComplexityMatrix);
            fPvalue = myComplexityWeightMatrix.getFPvalue(myComplexity, type);
        }
        return fPvalue;
    }

    public void edit(ClassOfDataFP type, int det, int ret)
    {
        this.type = type;
        this.det = det;
        this.ret = ret;
        this.fPvalue = -1;
    }
}
