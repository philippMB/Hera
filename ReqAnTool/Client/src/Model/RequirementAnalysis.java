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
import Model_Interfaces.IRequirementList;
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
    private IProductApplication myProductApplication;
    private ITargetDefinition myTargetDefinition;
    private ICostEstimation myCostEstimation;
    private ICustomerData myCustomerData;
    /**
     * @associates <{Model.FRequirement}>
     */
    private AdapterList<IFRequirement> myFRequirements;
    /**
     * @associates <{Model.ProductData}>
     */
    private AdapterList<IProductData> myProductData;
    /**
     * @associates <{Model.NFRequirement}>
     */
    private AdapterList<INFRequirement> myNFRequirements;
    /**
     * @associates <{Model.Addition}>
     */
    private ArrayList<IAddition> myAdditions;
    /**
     * @associates <{Model.GlossaryEntry}>
     */
    private ArrayList<IGlossaryEntry> myGlossaryEntries;
    /**
     * @associates <{Model.QualityRequirement}>
     */
    private ArrayList<IQualityRequirement> myQualityRequirements;
    /**
     * @associates <{Model.WeightFactor}>
     */
    private ArrayList<IWeightFactor> myWeightFactors;


    public boolean checkReference(String _alteID, String _neueID) {
        return false;
    }

    public boolean isIDunique(String _id) {
        return true;
    }

    public boolean optimizeWeightFactor() {
        return false;
    }

    @Override
    public double getActualState()
    {
        return actualState;
    }

    @Override
    public Date getCreateDate()
    {
        return createDate;
    }

    @Override
    public String getCustomerDescription()
    {
        return customerDescription;
    }

    @Override
    public ArrayList<IAddition> getAdditions()
    {
        return myAdditions;
    }

    @Override
    public AdapterList<IFRequirement> getFRequirements()
    {
        return myFRequirements;
    }

    @Override
    public AdapterList<INFRequirement> getNFRequirements()
    {
        return myNFRequirements;
    }

    @Override
    public ArrayList<IGlossaryEntry> getGlossaryEntries()
    {
        return myGlossaryEntries;
    }

    @Override
    public AdapterList<IProductData> getProductData()
    {
        return myProductData;
    }

    @Override
    public ArrayList<IQualityRequirement> getQualityRequirements()
    {
        return myQualityRequirements;
    }

    @Override
    public ArrayList<IWeightFactor> getWeightFactors()
    {
        return myWeightFactors;
    }

    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public ITargetDefinition getTargetDefinition()
    {
        return myTargetDefinition;
    }

    @Override
    public IProductApplication getProductApplication()
    {
        return myProductApplication;
    }

    @Override
    public ICustomerData getCustomerData()
    {
        return myCustomerData;
    }

    @Override
    public ICostEstimation getCostEstimation()
    {
        return myCostEstimation;
    }

    @Override
    public IGlossaryEntry getGlossaryEntriesByTerm(String term)
    {
        // TODO
        return null;
    }

    @Override
    public IQualityRequirement getQualityRequirementsByCriteria(String criteria)
    {
        // TODO
        return null;
    }

    @Override
    public IAddition getAdditionByTitle(String title)
    {
        // TODO
        return null;
    }

    @Override
    public IWeightFactor getWeightFactorByTitle(String title)
    {
        // TODO
        return null;
    }

    @Override
    public IFRequirement getFRequirementByID(String id)
    {
        // TODO
        return null;
    }

    @Override
    public INFRequirement getNFRequirementByID(String id)
    {
        // TODO
        return null;
    }

    @Override
    public IProductData getProductDataByID(String id)
    {
        // TODO
        return null;
    }
    
}
