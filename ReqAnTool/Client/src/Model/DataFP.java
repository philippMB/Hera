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
    private Requirement reference;

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
    public IRequirement getReference()
    {
        return reference;
    }

    @Override
    public ClassOfDataFP getType()
    {
        // TODO returntype
        return type;
    }
}
