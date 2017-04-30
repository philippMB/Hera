package Model_Interfaces;

import java.util.ArrayList;

public interface IModelGetData
{
    IRequirement getReqByID(String ID);

	IFRequirement getFReqByID(String ID);

	INFRequirement getNFReqByID(String ID);

	IProductData getPReqByID(String ID);

	IRequirementAnalysis getReqAnalysis();

	public ArrayList<IFRequirement> getAllFReqs();

	public ArrayList<INFRequirement> getAllNFReqs();

	public ArrayList<IProductData> getAllPReqs();

    public ArrayList<String> getAllReqIDs();

    public ICustomerData getCustomerData();

    IGlossaryEntry getGlossaryEntryByTerm(String term);

    public ICostEstimation getCostEstimation();

    public IAddition getAddition();

    public ArrayList<IAddition> getAllAdditions();

    public IProductApplication getProdApp();

    public IQualityRequirement getQualReqByCriteria(String criteria);

    public ArrayList<IQualityRequirement> getAllQualityReqs();

	public ArrayList<IGlossaryEntry> getAllGlossaryEntries();

    public ITargetDefinition getTargetDef();

    public IWeightFactor getOptWeightFactor();

    public IWeightFactor getWeightFactor();

    public String generateNewID();
}
