package Model_Interfaces;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by phlippe on 26.04.17.
 */
public interface IRequirementAnalysis 
{

    public double getActualState();
    
    public Date getCreateDate();
    
    public String getCustomerDescription();
    
    public ArrayList<IAddition> getAdditions();

    public ICostEstimation getCostEstimation();

    public ArrayList<IFRequirement> getFRequirements();
    
    public ArrayList<INFRequirement> getNFRequirements();
    
    public ArrayList<IGlossaryEntry> getGlossaryEntries();
    
    public ArrayList<IProductData> getProductData();
    
    public ArrayList<IQualityRequirement> getQualityRequirements();
    
    public ArrayList<IWeightFactor> getWeightFactors();
    
    public String getTitle();
    
    public ITargetDefinition getTargetDefinition();
    
    public IProductApplication getProductApplication();
    
    public ICustomerData getCustomerData();
}
