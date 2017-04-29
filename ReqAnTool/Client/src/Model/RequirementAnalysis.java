package Model;

import Model_Interfaces.IAddition;
import Model_Interfaces.ICostEstimation;
import Model_Interfaces.ICustomerData;
import Model_Interfaces.IFRequirement;
import Model_Interfaces.IGlossaryEntry;
import Model_Interfaces.INFRequirement;
import Model_Interfaces.IProductApplication;
import Model_Interfaces.IProductData;
import Model_Interfaces.IQualityRequirement;
import Model_Interfaces.IRequirementAnalysis;
import Model_Interfaces.ITargetDefinition;
import Model_Interfaces.IWeightFactor;

import java.util.ArrayList;
import java.util.Date;

public class RequirementAnalysis
    implements IRequirementAnalysis
{
    private Date createDate;
    private String title;
    private String customerDescription;
    private double actualState;    
    private ProductApplication myProductApplication;
    private TargetDefinition myTargetDefinition;
    private CustomerData myCustomerData;


    /**
     * @associates <{Model.FRequirement}>
     */
    private IRequirementList<IFRequirement> myFRequirements;

    /**
     * @associates <{Model.ProductData}>
     */
    private IRequirementList<IProductData> myProductData;

    /**
     * @associates <{Model.NFRequirement}>
     */
    private IRequirementList<INFRequirement> myNFRequirements;

    /**
     * @associates <{Model.Addition}>
     */
    private ArrayList<Addition> myAddition;

    /**
     * @associates <{Model.GlossaryEntry}>
     */
    private ArrayList<GlossaryEntry> myGlossaryEntries;

    /**
     * @associates <{Model.QualityRequirement}>
     */
    private ArrayList<QualityRequirement> myQualityRequirements;

    /**
     * @associates <{Model.WeightFactor}>
     */
    private ArrayList<WeightFactor> myWeightFactors;
    private CostEstimation myCostEstimation;
    private Configuration myConfig;


    public Status checkReference(String _alteID, String _neueID) {
        return null;
    }

    public boolean isIDunique(String _id) {
        return true;
    }

    public Status optimizeWeightFactor() {
        return null;
    }

    @Override
    public double getActualState()
    {
        // TODO Implement this method
        return 0.0;
    }

    @Override
    public Date getCreateDate()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getCustomerDescription()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ArrayList<IAddition> getAdditions()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ICostEstimation getCostEstimation()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public IRequirementList<IFRequirement> getFRequirements()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public IRequirementList<INFRequirement> getNFRequirements()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ArrayList<IGlossaryEntry> getGlossaryEntries()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public IRequirementList<IProductData> getProductData()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ArrayList<IQualityRequirement> getQualityRequirements()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ArrayList<IWeightFactor> getWeightFactors()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getTitle()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ITargetDefinition getTargetDefinition()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public IProductApplication getProductApplication()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ICustomerData getCustomerData()
    {
        // TODO Implement this method
        return null;
    }
}
