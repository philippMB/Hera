package Model;


import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IAddition;
import Model_Interfaces.ICostEstimation;
import Model_Interfaces.ICustomerData;
import Model_Interfaces.IFRequirement;
import Model_Interfaces.IGlossaryEntry;
import Model_Interfaces.INFRequirement;
import Model_Interfaces.IProductApplication;
import Model_Interfaces.IProductData;
import Model_Interfaces.IQualityRequirement;
import Model_Interfaces.IRequirement;
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

    RequirementAnalysis(String title, String pmName, String pmMail, String pmPhone)
    {
        this.title = title;
        this.customerDescription = null;
        this.myCustomerData = new CustomerData(pmName, pmMail, pmPhone);
        this.myAdditions = new ArrayList<IAddition>();
        this.myCostEstimation = new CostEstimation();
        this.myFRequirements = new AdapterList<IFRequirement>();
        this.myGlossaryEntries = new ArrayList<IGlossaryEntry>();
        this.myNFRequirements = new AdapterList<INFRequirement>();
        this.myProductApplication = new ProductApplication();
        this.myProductData = new AdapterList<IProductData>();
        this.myQualityRequirements = new ArrayList<IQualityRequirement>();
        this.myTargetDefinition = new TargetDefinition();
        this.createDate = new Date();
        this.actualState = -1.0;        
    }

    protected boolean isReqIncluded(String id)
    {
        boolean isIncluded = false;
        if (myFRequirements.isIncluded(id))
        {
            isIncluded = true;
        }
        else if (myNFRequirements.isIncluded(id))
        {
            isIncluded = true;
        }
        else if (myProductData.isIncluded(id))
        {
            isIncluded = true;
        }
        return isIncluded;
    }
    
    
    protected IRequirement getAnyReqByID(String id)
    {
        IRequirement myReq = null;
        if (myFRequirements.isIncluded(id))
        {
            myReq = myFRequirements.getReqByID(id);
        }
        else if (myNFRequirements.isIncluded(id))
        {
            myReq = myNFRequirements.getReqByID(id);
        }
        else if (myProductData.isIncluded(id))
        {
            myReq = myProductData.getReqByID(id);
        }
        return myReq;
    }
    
    protected ArrayList<String> getAllReqIDs()
    {
        ArrayList<String> myIDs = new ArrayList<String>();
        for (IRequirement req : myFRequirements)
        {
            myIDs.add(req.getID());
        }
        for (IRequirement req : myNFRequirements)
        {
            myIDs.add(req.getID());
        }
        for (IRequirement req : myProductData)
        {
            myIDs.add(req.getID());
        }
        return myIDs;
    }
    
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
    public ArrayList<IFRequirement> getFRequirements()
    {
        return myFRequirements.toArrayList();
    }

    @Override
    public ArrayList<INFRequirement> getNFRequirements()
    {
        return myNFRequirements.toArrayList();
    }

    @Override
    public ArrayList<IGlossaryEntry> getGlossaryEntries()
    {
        return myGlossaryEntries;
    }

    @Override
    public ArrayList<IProductData> getProductData()
    {
        return myProductData.toArrayList();
    }

    @Override
    public ArrayList<IQualityRequirement> getQualityRequirements()
    {
        return myQualityRequirements;
    }

    @Override
    public ArrayList<IWeightFactor> getWeightFactors()
    {
        return myCostEstimation.getWeightFactors();
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
        return myCostEstimation.getWeightFactorByTitle(title);
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

    protected void addAddition(String title, String description)
    {
        Addition myAdd = new Addition(title, description);
        myAdditions.add(myAdd);
    }

    protected ErrorCodes addFRequirement(String id, String title, String actor, String description, ArrayList<String> references)
    {
        int flag = 0;
        for (String ref : references)
        {
            if (isReqIncluded(ref))
            {
                flag++;
            }
        }
        if (flag < references.size())
        {
            return ErrorCodes.REFERENCE_NOT_SOLVED;
        }
        else
        {
            ArrayList<IRequirement> myReferences = new ArrayList<IRequirement>(); 
            for (String ref : references)
            {
                myReferences.add(getAnyReqByID(ref));
            }
            FRequirement myReq = new FRequirement(id, title, actor, description, myReferences);
            return ErrorCodes.NO_ERROR;
        }
    }
    

    protected ErrorCodes addGlossaryEntry(String term, String sense, String boundary, String validity, String obscurities,
                                String label, ArrayList<String> crossRef)
    {
        ErrorCodes retValue = null;
        int flag = 0;
        for (String ref : crossRef)
        {
            
        }
        return null;
    }

}
