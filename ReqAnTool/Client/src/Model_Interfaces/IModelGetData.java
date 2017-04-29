package Model_Interfaces;

public interface IModelGetData
{
    IRequirement getReqByID(String ID);

    public ICustomerData getCustomerData();

    IGlossaryEntry getGlossaryEntryByTerm(String term);

    public ICostEstimation getCostEstimation();

    public IAddition getAddition();

    public IProductApplication getProdApp();

    public IQualityRequirement getQualReqByCriteria(String criteria);

    public ITargetDefinition getTargetDef();

    public IWeightFactor getOptWeightFactor();

    public IWeightFactor getWeightFactor();
}
