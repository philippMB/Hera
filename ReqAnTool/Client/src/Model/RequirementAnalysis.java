package Model;


import Model_Interfaces.*;

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
    private CostEstimation myCostEstimation;
    private CustomerData myCustomerData;
    /**
     * @associates <{Model.FRequirement}>
     */
    private RequirementList<IFRequirement> myFRequirements;
    /**
     * @associates <{Model.ProductData}>
     */
    private RequirementList<IProductData> myProductData;
    /**
     * @associates <{Model.NFRequirement}>
     */
    private RequirementList<INFRequirement> myNFRequirements;
    /**
     * @associates <{Model.Addition}>
     */
    private AdditionList<IAddition> myAdditions;
    /**
     * @associates <{Model.GlossaryEntry}>
     */
    private GlossaryList<IGlossaryEntry> myGlossaryEntries;
    /**
     * @associates <{Model.QualityRequirement}>
     */
    private QualityRequirementList<IQualityRequirement> myQualityRequirements;

    RequirementAnalysis(String title, String pmName, String pmMail, String pmPhone)
    {
        this.title = title;
        this.customerDescription = null;
        this.myCustomerData = new CustomerData(pmName, pmMail, pmPhone);
        this.myAdditions = new AdditionList<IAddition>();
        this.myCostEstimation = null;
        this.myFRequirements = new RequirementList<IFRequirement>();
        this.myGlossaryEntries = new GlossaryList<IGlossaryEntry>();
        this.myNFRequirements = new RequirementList<INFRequirement>();
        this.myProductApplication = new ProductApplication();
        this.myProductData = new RequirementList<IProductData>();
        this.myQualityRequirements = new QualityRequirementList<IQualityRequirement>();
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

    protected boolean solveGlossaryTerms(ArrayList<String> terms)
    {
        int flag = 0;
        for (String term : terms)
        {
            for (IGlossaryEntry entry : myGlossaryEntries)
            {
                if (term.equals(entry.getTerm()))
                {
                    flag++;
                }
            }
        }
        return flag == terms.size();
    }
    
    protected boolean solveReqReferences(ArrayList<String> references)
    {
        int flag = 0;
        for (String ref : references)
        {
            if (isReqIncluded(ref))
            {
                flag++;
            }
        }
        return flag == references.size();
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

    public boolean isIDunique(String id) {
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
        return myGlossaryEntries.getEntryByTerm(term);
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

    ErrorCodes addAddition(String title, String description)
    {
        Addition myAdd = new Addition(title, description);
        myAdditions.add(myAdd);
        return ErrorCodes.NO_ERROR;
    }

    ErrorCodes addFRequirement(String id, String title, String actor, String description, ArrayList<String> references)
    {
        if (!solveReqReferences(references))
        {
            return ErrorCodes.REFERENCES_NOT_SOLVED;
        }
        else
        {
            RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
            for (String ref : references)
            {
                myReferences.add(getAnyReqByID(ref));
            }
            FRequirement myReq = new FRequirement(id, title, actor, description, myReferences);
            myFRequirements.add(myReq);
            return ErrorCodes.NO_ERROR;
        }
    }
    

    protected ErrorCodes addGlossaryEntry(String term, String sense, String boundary, String validity, String obscurities,
                                String label, ArrayList<String> crossRef)
    {
        ErrorCodes retValue = null;

        if (!solveGlossaryTerms(crossRef))
        {
            return ErrorCodes.REFERENCES_NOT_SOLVED;
        }
        else
        {
            GlossaryList<IGlossaryEntry> myCrossRef = new GlossaryList<IGlossaryEntry>();
            for (String ref : crossRef)
            {
                myCrossRef.add(getGlossaryEntriesByTerm(ref));
            }
            GlossaryEntry myEntry = new GlossaryEntry(term, sense, boundary, validity, obscurities, label, myCrossRef);
            myGlossaryEntries.add(myEntry);
            return ErrorCodes.NO_ERROR;
        }
    }

    ErrorCodes addNFRequirement(String id, String title, String actor, String description, ArrayList<String> references)
    {
        if (!solveReqReferences(references))
        {
            return ErrorCodes.REFERENCES_NOT_SOLVED;
        }
        else
        {
            RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
            for (String ref : references)
            {
                myReferences.add(getAnyReqByID(ref));
            }
            NFRequirement myReq = new NFRequirement(id, title, actor, description, myReferences);
            myNFRequirements.add(myReq);
            return ErrorCodes.NO_ERROR;
        }
    }

    ErrorCodes addProductData(String id, String content, String attribute, String maxCount,
                              ArrayList<String> references)
    {
        if (!solveReqReferences(references))
        {
            return ErrorCodes.REFERENCES_NOT_SOLVED;
        }
        else
        {
            RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
            for (String ref : references)
            {
                myReferences.add(getAnyReqByID(ref));
            }
            ProductData myReq = new ProductData(id, content, attribute, maxCount, myReferences);
            myProductData.add(myReq);
            return ErrorCodes.NO_ERROR;
        }
    }

    protected ErrorCodes addQualReq(String criteria, Score value)
    {
        IQualityRequirement myQualReq = new QualityRequirement(criteria, value);
        myQualityRequirements.add(myQualReq);
        return ErrorCodes.NO_ERROR;
    }

    protected ErrorCodes editAddition(String title, String description)
    {
        Addition myAdd = myAdditions.getAdditionByTerm(title);
        myAdd.edit(title, description);
        return ErrorCodes.NO_ERROR;
    }

    ErrorCodes editCustData(String companyName, String companyCity, String companyStreet, int zip, String companyCountry,
                            String custName, String custMail, String custPhone, String pmName, String pmMail, String pmPhone)
    {
        return myCustomerData.edit(companyName, companyCity, companyStreet, zip, companyCountry, custName,
                                    custMail, custPhone, pmName, pmMail, pmPhone);
    }

    ErrorCodes editFReq(String oldID, String id, String title, String actor, String description, ArrayList<String> references)
    {
        if (myFRequirements.isIncluded(oldID))
        {
            IFRequirement myIFReq = myFRequirements.getReqByID(oldID);
            if (isIDunique(id))
            {
                if (solveReqReferences(references))
                {
                    RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
                    FRequirement myFReq = (FRequirement)myIFReq;
                    for (String ref : references)
                    {
                        myReferences.add(getAnyReqByID(ref));
                    }
                    return myFReq.edit(id, title, actor, description, myReferences);
                }
                else
                {
                    return ErrorCodes.REFERENCES_NOT_SOLVED;
                }
            }
            else
            {
                return ErrorCodes.DUPLICATE;
            }
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity, String obscurities, String label, ArrayList<String> crossRef)
    {
        if (myGlossaryEntries.isIncluded(oldTerm))
        {
            IGlossaryEntry myIEntry = myGlossaryEntries.getEntryByTerm(oldTerm);
            if (!myGlossaryEntries.isIncluded(term)) // Test for duplicate Term in GlossaryEntries
            {
                if (solveGlossaryTerms(crossRef))
                {
                    GlossaryList<IGlossaryEntry> myCrossRef = new GlossaryList<IGlossaryEntry>();
                    GlossaryEntry myEntry = (GlossaryEntry)myIEntry;
                    for (String ref : crossRef)
                    {
                        myCrossRef.add(myGlossaryEntries.getEntryByTerm(ref));
                    }
                    return myEntry.edit(term, sense, boundary, validity, obscurities, label, myCrossRef);
                }
                else
                {
                    return ErrorCodes.REFERENCES_NOT_SOLVED;
                }
            }
            else
            {
                return ErrorCodes.DUPLICATE;
            }
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes editNFReq(String oldID, String id, String title, String actor, String description, ArrayList<String> references)
    {
        if (myNFRequirements.isIncluded(oldID))
        {
            INFRequirement myINFReq = myNFRequirements.getReqByID(oldID);
            if (isIDunique(id))
            {
                if (solveReqReferences(references))
                {
                    RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
                    NFRequirement myNFReq = (NFRequirement)myINFReq;
                    for (String ref : references)
                    {
                        myReferences.add(getAnyReqByID(ref));
                    }
                    return myNFReq.edit(id, title, actor, description, myReferences);
                }
                else
                {
                    return ErrorCodes.REFERENCES_NOT_SOLVED;
                }
            }
            else
            {
                return ErrorCodes.DUPLICATE;
            }
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes editProdApp(String description)
    {
        return myProductApplication.edit(description);
    }

    public ErrorCodes editProdData(String oldID, String id, String content, String attribute, String maxCount, ArrayList<String> references)
    {
        if (myProductData.isIncluded(oldID))
        {
            IProductData myIProdData = myProductData.getReqByID(oldID);
            if (isIDunique(id))
            {
                if (solveReqReferences(references))
                {
                    RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
                    ProductData myProdData = (ProductData) myIProdData;
                    for (String ref : references)
                    {
                        myReferences.add(getAnyReqByID(ref));
                    }
                    return myProdData.edit(id, content, attribute, maxCount, myReferences);
                }
                else
                {
                    return ErrorCodes.REFERENCES_NOT_SOLVED;
                }
            }
            else
            {
                return ErrorCodes.DUPLICATE;
            }
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes editQualReq(String oldCriteria, String criteria, Score value)
    {
        if (myQualityRequirements.isIncluded(oldCriteria))
        {
            IQualityRequirement myIQualReq = myQualityRequirements.getQualReqByCriteria(oldCriteria);
            if (!myQualityRequirements.isIncluded(criteria)) // Test for duplicate criteria
            {
                QualityRequirement myQualReq = (QualityRequirement) myIQualReq;
                return myQualReq.edit(criteria, value);
            }
            else
            {
                return ErrorCodes.DUPLICATE;
            }
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes editTargetDef(String description)
    {
        return myTargetDefinition.edit(description);
    }
}
