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

    public DataFP(ClassOfDataFP type, IRequirement requirement, int det, int ret)
    {
        this.type = type;
        this.det = det;
        this.ret = ret;
        this.reference = requirement;
    }

    @Override
    public int getDET()
    {
        return det;
    }

    @Override
    public int getRET()
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
}
