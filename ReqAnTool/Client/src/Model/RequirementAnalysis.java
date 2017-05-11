package Model;

// TODO check Map for WeightFactors

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
    private ProductEnvironment myProductEnvironment;
    private TargetDefinition myTargetDefinition;
    private CostEstimation myCostEstimation;
    private CustomerData myCustomerData;
    private Validator myValidator;
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
        this.myProductEnvironment = new ProductEnvironment();
        this.myProductData = new RequirementList<IProductData>();
        this.myQualityRequirements = new QualityRequirementList<IQualityRequirement>();
        this.myTargetDefinition = new TargetDefinition();
        this.createDate = new Date();
        this.actualState = -1.0;
        this.myValidator = new Validator();
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

    public boolean isReferenceOnID(String id)
    {
        for (IFRequirement myIFReq : myFRequirements)
        {
            FRequirement myFReq = (FRequirement)myIFReq;
            for (String refID : myFReq.getReferenceIDs())
            {
                if (refID.equals(id))
                {
                    return true;
                }
            }
        }
        for (INFRequirement myINFReq : myNFRequirements)
        {
            FRequirement myNFReq = (FRequirement)myINFReq;
            for (String refID : myNFReq.getReferenceIDs())
            {
                if (refID.equals(id))
                {
                    return true;
                }
            }
        }
        for (IProductData myIProdData : myProductData)
        {
            ProductData myProdData = (ProductData)myIProdData;
            for (String refID : myProdData.getReferenceIDs())
            {
                if (refID.equals(id))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private void refreshReferences(String oldID, String id)
    {
        IRequirement newReq = getAnyReqByID(id);
        for (IFRequirement myIFReq : myFRequirements)
        {
            FRequirement myFReq = (FRequirement)myIFReq;
            for (String refID : myFReq.getReferenceIDs())
            {
                if (refID.equals(id))
                {
                    myFReq.refreshReference(oldID, newReq);
                }
            }
        }
        for (INFRequirement myINFReq : myNFRequirements)
        {
            FRequirement myNFReq = (FRequirement)myINFReq;
            for (String refID : myNFReq.getReferenceIDs())
            {
                if (refID.equals(id))
                {
                    myNFReq.refreshReference(oldID, newReq);
                }
            }
        }
        for (IProductData myIProdData : myProductData)
        {
            ProductData myProdData = (ProductData)myIProdData;
            for (String refID : myProdData.getReferenceIDs())
            {
                if (refID.equals(id))
                {
                    myProdData.refreshReference(oldID, newReq);
                }
            }
        }
    }

    private void removeRequirementReferences(String id)
    {
        for (IFRequirement myIFReq : myFRequirements)
        {
            FRequirement myFReq = (FRequirement)myIFReq;
            for (String refID : myFReq.getReferenceIDs())
            {
                if (refID.equals(id))
                {
                    myFReq.remReference(id);
                }
            }
        }
        for (INFRequirement myINFReq : myNFRequirements)
        {
            FRequirement myNFReq = (FRequirement)myINFReq;
            for (String refID : myNFReq.getReferenceIDs())
            {
                if (refID.equals(id))
                {
                    myNFReq.remReference(id);
                }
            }
        }
        for (IProductData myIProdData : myProductData)
        {
            ProductData myProdData = (ProductData)myIProdData;
            for (String refID : myProdData.getReferenceIDs())
            {
                if (refID.equals(id))
                {
                    myProdData.remReference(id);
                }
            }
        }
    }

    private boolean isReferenceOnTerm(String term)
    {
        for (IGlossaryEntry myIEntry : myGlossaryEntries)
        {
            GlossaryEntry myEntry = (GlossaryEntry)myIEntry;
            for (String ref : myEntry.getReferenceTerms())
            {
                if (ref.equals(term))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private void removeGlossaryReferences(String term)
    {
        for (IGlossaryEntry myIEntry : myGlossaryEntries)
        {
            GlossaryEntry myEntry = (GlossaryEntry)myIEntry;
            for (String ref : myEntry.getReferenceTerms())
            {
                if (ref.equals(term))
                {
                    myEntry.remReference(term);
                }
            }
        }
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

    public boolean isIDunique(String id)
    {
        if (getAnyReqByID(id) == null)
        {
            return true;
        }
        else
        {
            return false;
        }
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
        return myFRequirements;
    }

    @Override
    public ArrayList<INFRequirement> getNFRequirements()
    {
        return myNFRequirements;
    }

    @Override
    public ArrayList<IGlossaryEntry> getGlossaryEntries()
    {
        return myGlossaryEntries;
    }

    @Override
    public ArrayList<IProductData> getProductData()
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
        return myQualityRequirements.getQualReqByCriteria(criteria);
    }

    @Override
    public IAddition getAdditionByTitle(String title)
    {
        return myAdditions.getAdditionByTitle(title);
    }

    @Override
    public IWeightFactor getWeightFactorByTitle(String title)
    {
        return myCostEstimation.getWeightFactorByTitle(title);
    }

    @Override
    public IFRequirement getFRequirementByID(String id)
    {
        return myFRequirements.getReqByID(id);
    }

    @Override
    public INFRequirement getNFRequirementByID(String id)
    {
        return myNFRequirements.getReqByID(id);
    }

    @Override
    public IProductData getProductDataByID(String id)
    {
        return myProductData.getReqByID(id);
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
            if (myValidator.isValidID(id))
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
            else
            {
                return ErrorCodes.INVALID_ID;
            }
        }
    }
    

    protected ErrorCodes addGlossaryEntry(String term, String sense, String boundary, String validity,
                                          String obscurities, String label, ArrayList<String> crossRef)
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
            if (myValidator.isValidID(id))
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
            else
            {
                return ErrorCodes.INVALID_ID;
            }
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
            if (myValidator.isValidID(id))
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
            else
            {
                return ErrorCodes.INVALID_ID;
            }
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
        IAddition myIAdd = myAdditions.getAdditionByTitle(title);
        Addition myAdd = (Addition)myIAdd;
        myAdd.edit(title, description);
        return ErrorCodes.NO_ERROR;
    }

    public ArrayList<ErrorCodes> editCustData(String companyName, String companyCity, String companyStreet, String zip,
                                              String companyCountry, String custName, String custMail, String custPhone,
                                              String pmName, String pmMail, String pmPhone)
    {
        return myCustomerData.edit(companyName, companyCity, companyStreet, zip, companyCountry, custName,
                                    custMail, custPhone, pmName, pmMail, pmPhone);
    }

    ErrorCodes editFReq(String oldID, String id, String title, String actor, String description,
                        ArrayList<String> references)
    {
        if (myFRequirements.isIncluded(oldID))
        {
            IFRequirement myIFReq = myFRequirements.getReqByID(oldID);
            if (isIDunique(id))
            {
                if (solveReqReferences(references))
                {
                    if (myValidator.isValidID(id))
                    {
                        RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
                        FRequirement myFReq = (FRequirement) myIFReq;

                        for (String ref : references)
                        {
                            myReferences.add(getAnyReqByID(ref));
                        }
                        ErrorCodes retValue = myFReq.edit(id, title, actor, description, myReferences);
                        if (isReferenceOnID(oldID))
                        {
                            refreshReferences(oldID, id);
                        }
                        return retValue;
                    }
                    else
                    {
                        return ErrorCodes.INVALID_ID;
                    }
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

    public ErrorCodes editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
                                     String obscurities, String label, ArrayList<String> crossRef)
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

    public ErrorCodes editNFReq(String oldID, String id, String title, String actor, String description,
                                ArrayList<String> references)
    {
        if (myNFRequirements.isIncluded(oldID))
        {
            INFRequirement myINFReq = myNFRequirements.getReqByID(oldID);
            if (isIDunique(id))
            {
                if (solveReqReferences(references))
                {
                    if (myValidator.isValidID(id))
                    {
                        RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
                        NFRequirement myNFReq = (NFRequirement) myINFReq;
                        for (String ref : references)
                        {
                            myReferences.add(getAnyReqByID(ref));
                        }
                        ErrorCodes retValue = myNFReq.edit(id, title, actor, description, myReferences);
                        if (isReferenceOnID(oldID))
                        {
                            refreshReferences(oldID, id);
                        }
                        return retValue;
                    }
                    else
                    {
                        return ErrorCodes.INVALID_ID;
                    }
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

    public ErrorCodes editProdData(String oldID, String id, String content, String attribute, String maxCount,
                                   ArrayList<String> references)
    {
        if (myProductData.isIncluded(oldID))
        {
            IProductData myIProdData = myProductData.getReqByID(oldID);
            if (isIDunique(id))
            {
                if (solveReqReferences(references))
                {
                    if (myValidator.isValidID(id))
                    {
                        RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
                        ProductData myProdData = (ProductData) myIProdData;
                        for (String ref : references)
                        {
                            myReferences.add(getAnyReqByID(ref));
                        }
                        ErrorCodes retValue = myProdData.edit(id, content, attribute, maxCount, myReferences);
                        if (isReferenceOnID(oldID))
                        {
                            refreshReferences(oldID, id);
                        }
                        return retValue;
                    }
                    else
                    {
                        return ErrorCodes.INVALID_ID;
                    }
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

    public ErrorCodes rateWeightFactor(ArrayList<Integer> values)
    {
        boolean success = true;
        if (getCostEstimation() != null)
        {
            ArrayList<ErrorCodes> errors = myCostEstimation.rateWeightFactor(values);
            for (ErrorCodes error : errors)
            {
                if (!(error == ErrorCodes.NO_ERROR))
                {
                    success = false;
                }
            }
            if (success)
            {
                return ErrorCodes.NO_ERROR;
            }
            else
            {
                return ErrorCodes.INVALID_ARGUMENT;
            }
        }
        else
        {
            return ErrorCodes.NO_COST_ESTIMATION;
        }
    }

    public ErrorCodes remAdditionByTitle(String title)
    {
        if (myAdditions.isIncluded(title))
        {
            myAdditions.removeByTitle(title);
            return ErrorCodes.NO_ERROR;
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes remCostEstimation()
    {
        if (myCostEstimation != null)
        {
            myCostEstimation = null;
            return ErrorCodes.NO_ERROR;
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes remFReqByID(String id)
    {
        if (myFRequirements.isIncluded(title))
        {
            myFRequirements.removeReqByID(id);
            if(isReferenceOnID(id))
            {
                return ErrorCodes.NO_ERROR;
            }
            else
            {
                removeRequirementReferences(id);
                return ErrorCodes.REFERENCES_ON_ITEM_DELETED;
            }
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes remGlossEntryByTerm(String term)
    {
        if (myGlossaryEntries.isIncluded(term))
        {
            myGlossaryEntries.removeEntryByTerm(term);
            if(!isReferenceOnTerm(term))
            {
                return ErrorCodes.NO_ERROR;
            }
            else
            {
                removeGlossaryReferences(term);
                return ErrorCodes.REFERENCES_ON_ITEM_DELETED;
            }
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes remNFReqByID(String id)
    {
        if (myNFRequirements.isIncluded(id))
        {
            myNFRequirements.removeReqByID(id);
            if (isReferenceOnID(id))
            {
                return ErrorCodes.NO_ERROR;
            }
            else
            {
                removeRequirementReferences(id);
                return ErrorCodes.REFERENCES_ON_ITEM_DELETED;
            }
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes remProdDataByID(String id)
    {
        if (myProductData.isIncluded(id))
        {
            myProductData.removeReqByID(id);
            if (!isReferenceOnID(id))
            {
                return ErrorCodes.NO_ERROR;
            }
            else
            {
                removeRequirementReferences(id);
                return ErrorCodes.REFERENCES_ON_ITEM_DELETED;
            }
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes remQualReqByCrit(String criteria)
    {
        if (myQualityRequirements.isIncluded(criteria))
        {
            myQualityRequirements.removeQualReqByCriteria(criteria);
            return ErrorCodes.NO_ERROR;
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes setActualState(double actualState)
    {
        if(actualState > 0)
        {
            this.actualState = actualState;
            return ErrorCodes.NO_ERROR;
        }
        else
        {
            return ErrorCodes.INVALID_ARGUMENT;
        }
    }

    public ErrorCodes setDataFP(ClassOfDataFP type, String id, int det, int ret)
    {
        if (isReqIncluded(id))
        {
            if (myCostEstimation != null)
            {
                if (myCostEstimation.getDataFPByID(id) == null) // Test for duplicate initialising
                {
                    IRequirement reference = getAnyReqByID(id);
                    return myCostEstimation.setDataFP(type, reference, det, ret);
                }
                else
                {
                    return ErrorCodes.DUPLICATE;
                }
            }
            else
            {
                return ErrorCodes.NO_COST_ESTIMATION;
            }
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes setTransactionFP(ClassOfTransactionFP type, String id, int det, int ftr)
    {
        if (isReqIncluded(id))
        {
            if (myCostEstimation != null)
            {
                if (myCostEstimation.getTransactionFPByID(id) == null)
                {
                    IRequirement reference = getAnyReqByID(id);
                    return myCostEstimation.setTransactionFP(type, reference, det, ftr);
                }
                else
                {
                    return ErrorCodes.DUPLICATE;
                }
            }
            else
            {
                return ErrorCodes.NO_COST_ESTIMATION;
            }
        }
        else
        {
            return ErrorCodes.NOT_EXISTENT;
        }
    }

    public ErrorCodes addCostEstimation(ComplexityMatrix myComplexityMatrix,
                                        ComplexityWeightMatrix myComplexityWeightMatrix)
    {
        myCostEstimation = new CostEstimation(myComplexityWeightMatrix, myComplexityMatrix);
        return ErrorCodes.NO_ERROR;
    }

    public ErrorCodes calcManMonth()
    {
        if (myCostEstimation != null)
        {
            myCostEstimation.calculateManMonth();
            return ErrorCodes.NO_ERROR;
        }
        else
        {
            return ErrorCodes.NO_COST_ESTIMATION;
        }
    }

    public ErrorCodes remTransactionFPByID(String id)
    {
        if (myCostEstimation != null)
        {
            if (isReqIncluded(id))
            {
                IRequirement ReferenceToRequirement = getAnyReqByID(id);
                return myCostEstimation.remTransactionFPByID(ReferenceToRequirement);
            }
            else
            {
                return ErrorCodes.NOT_EXISTENT;
            }
        }
        else
        {
            return ErrorCodes.NO_COST_ESTIMATION;
        }
    }

    public ErrorCodes remDataFPByID(String id)
    {
        if (myCostEstimation != null)
        {
            if (isReqIncluded(id))
            {
                IRequirement ReferenceToRequirement = getAnyReqByID(id);
                return myCostEstimation.remDataFPByID(ReferenceToRequirement);
            }
            else
            {
                return ErrorCodes.NOT_EXISTENT;
            }
        }
        else
        {
            return ErrorCodes.NO_COST_ESTIMATION;
        }
    }

    public ErrorCodes editTransactionFPByID(ClassOfTransactionFP type, String id, int det, int ftr)
    {
        if (myCostEstimation != null)
        {
            if (isReqIncluded(id))
            {
                IRequirement ReferenceToRequirement = getAnyReqByID(id);
                return myCostEstimation.editTransactionFPByID(type, ReferenceToRequirement, det, ftr);
            }
            else
            {
                return ErrorCodes.NOT_EXISTENT;
            }
        }
        else
        {
            return ErrorCodes.NO_COST_ESTIMATION;
        }
    }

    public ErrorCodes editDataFPByID(ClassOfDataFP type, String id, int det, int ret)
    {
        if (myCostEstimation != null)
        {
            if (isReqIncluded(id))
            {
                IRequirement ReferenceToRequirement = getAnyReqByID(id);
                return myCostEstimation.editDataFPByID(type, ReferenceToRequirement, det, ret);
            }
            else
            {
                return ErrorCodes.NOT_EXISTENT;
            }
        }
        else
        {
            return ErrorCodes.NO_COST_ESTIMATION;
        }
    }

    public IProductEnvironment getProductEnviroment()
    {
        return myProductEnvironment;
    }

    public ErrorCodes editProdEnv(String description)
    {
        return myProductEnvironment.edit(description);
    }
}
