package Model_Interfaces;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by phlippe on 26.04.17.
 */
public interface IRequirementAnalysis 
{

    double getActualState();
    
    Date getCreateDate();
    
    String getCustomerDescription();
    
    ArrayList<IAddition> getAdditions();

    ICostEstimation getCostEstimation();

    ArrayList<IFRequirement> getFRequirements();
    
    ArrayList<INFRequirement> getNFRequirements();
    
    ArrayList<IGlossaryEntry> getGlossaryEntries();
    
    ArrayList<IProductData> getProductData();
    
    ArrayList<IQualityRequirement> getQualityRequirements();
    
    ArrayList<IWeightFactor> getWeightFactors();
    
    String getTitle();
    
    ITargetDefinition getTargetDefinition();
    
    IProductApplication getProductApplication();
    
    ICustomerData getCustomerData();
    
    IGlossaryEntry getGlossaryEntriesByTerm(String term);
    
    IQualityRequirement getQualityRequirementsByCriteria(String criteria);
    
    IAddition getAdditionByTitle(String title);
    
    IWeightFactor getWeightFactorByTitle(String title);
    
    IFRequirement getFRequirementByID(String id);
    
    INFRequirement getNFRequirementByID(String id);
    
    IProductData getProductDataByID(String id);

    IProductEnvironment getProductEnviroment();

}
