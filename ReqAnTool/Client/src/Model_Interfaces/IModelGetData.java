package Model_Interfaces;

import java.util.ArrayList;

public interface IModelGetData
{
    
    public IFRequirement getFReqByID(String id);

    public ICustomerData getCustomerData();

    public IGlossaryEntry getGlossaryEntryByTerm(String term);

    public ICostEstimation getCostEstimation();

    public IAddition getAdditionByTitle(String title);

    public IProductApplication getProdApp();

    public IQualityRequirement getQualReqByCriteria(String criteria);

    public ITargetDefinition getTargetDef();

    public IWeightFactor getOptWeightFactorByTitle(String title);

    public IWeightFactor getWeightFactorByTitle(String title);

    public ArrayList<IFRequirement> getAllFReq();

    public ArrayList<INFRequirement> getAllNFReq();

    public ArrayList<IProductData> getAllProdData();

    public ArrayList<IGlossaryEntry> getAllGlossEntry();

    public ArrayList<IQualityRequirement> getAllQualReq();

    public ArrayList<IAddition> getAllAddition();

    public ArrayList<IWeightFactor> getAllWeightFactor();
    
    public ArrayList<IWeightFactor> getAllOptWeightFactor();

    public INFRequirement getNFReqByID(String id);

    public IProductData getProductDataByID(String id);
    
}
