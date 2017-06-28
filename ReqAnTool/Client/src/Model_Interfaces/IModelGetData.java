package Model_Interfaces;

import java.util.ArrayList;
import java.util.Observer;

public interface IModelGetData
{

    void addObserver(Observer o);

    IRequirementAnalysis getReqAnalysis();

    IFRequirement getFReqByID(String id);
    
    INFRequirement getNFReqByID(String id);

    IProductData getProductDataByID(String id);

    ICustomerData getCustomerData();

    IProductApplication getProdApp();

    IProductEnvironment getProdEnv();

    IGlossaryEntry getGlossaryEntryByTerm(String term);

    ICostEstimation getCostEstimation();

    IAddition getAdditionByTitle(String title);

    IQualityRequirement getQualReqByCriteria(String criteria);

    ITargetDefinition getTargetDef();

    IWeightFactor getOptWeightFactorByTitle(String title);

    IWeightFactor getWeightFactorByTitle(String title);

    ArrayList<IFRequirement> getAllFReq();

    ArrayList<INFRequirement> getAllNFReq();

    ArrayList<IProductData> getAllProdData();

    ArrayList<IGlossaryEntry> getAllGlossEntries();

    ArrayList<IQualityRequirement> getAllQualReq();

    ArrayList<IAddition> getAllAddition();

    ArrayList<IWeightFactor> getAllWeightFactor();
    
    ArrayList<IWeightFactor> getAllOptWeightFactor();
    
    ArrayList<String> getAllReqIDs();
    
}
