package Model_Interfaces;

public interface IModelGetData
{
    public IRequirement getReqByID();

    public ICustomerData getCustomerData();

    public IGlossaryEntry getGlossaryEntryByTerm();

    public ICostEstimation getCostEstimation();
}
