package Model;

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
        // TODO Implement this method
        return 0;
    }

    @Override
    public int getRET()
    {
        // TODO Implement this method
        return 0;
    }

    @Override
    public IRequirement getReference()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ClassOfDataFP getType()
    {
        // TODO Implement this method
        return null;
    }
}
