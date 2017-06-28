package Model;

import Exceptions.*;
import Model_Interfaces.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

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
     * @associates <{Model_Interfaces.IFRequirement}>
     */
    private RequirementList<IFRequirement> myFRequirements;
    /**
     * @associates <{Model_Interfaces.IProductData}>
     */
    private RequirementList<IProductData> myProductData;
    /**
     * @associates <{Model_Interfaces.INFRequirement}>
     */
    private RequirementList<INFRequirement> myNFRequirements;
    /**
     * @associates <{Model_Interfaces.IAddition}>
     */
    private AdditionList<IAddition> myAdditions;
    /**
     * @associates <{Model_Interfaces.IGlossaryEntry}>
     */
    private GlossaryList<IGlossaryEntry> myGlossaryEntries;
    /**
     * @associates <{Model_Interfaces.IQualityRequirement}>
     */
    private QualityRequirementList<IQualityRequirement> myQualityRequirements;

    RequirementAnalysis(String title, String pmName, String pmMail, String pmPhone, String companyName, String city,
                        String companyStreet, String country, String zip, String cName, String cMail, String cPhone)
    {
        this.title = title;
        this.customerDescription = null;
        this.myCustomerData = new CustomerData(pmName, pmMail, pmPhone, companyName, city, companyStreet, country,  zip,
                                               cName, cMail, cPhone);
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

    public boolean isReqIncluded(String id)
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

    private void solveGlossaryTerms(ArrayList<String> terms) throws UnknownReferenceException
    {
        for (String term : terms)
        {
            if (!myGlossaryEntries.isIncluded(term))
            {
                throw new UnknownReferenceException(term);
            }
        }

    }
    
    private void solveReqReferences(ArrayList<String> references) throws UnknownReferenceException
    {
        for (String ref : references)
        {
            if (!isReqIncluded(ref))
            {
                throw new UnknownReferenceException(ref);
            }
        }

    }

    public boolean isReferenceOnID(String id)
    {
        boolean referenced = false;
        for (IFRequirement myIFReq : myFRequirements)
        {
            FRequirement myFReq = (FRequirement)myIFReq;
            for (String refID : myFReq.getReferenceIDs())
            {
                if (refID.equals(id))
                {
                    referenced = true;
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
                    referenced = true;
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
                    referenced = true;
                }
            }
        }
        return referenced;

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
        boolean referenced = false;
        for (IGlossaryEntry myIEntry : myGlossaryEntries)
        {
            GlossaryEntry myEntry = (GlossaryEntry)myIEntry;
            for (String ref : myEntry.getReferenceTerms())
            {
                if (ref.equals(term))
                {
                    referenced = true;
                }
            }
        }
        return referenced;

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
    
    private IRequirement getAnyReqByID(String id)
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
    
    public ArrayList<String> getAllReqIDs()
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
        boolean unique = false;
        if (getAnyReqByID(id) == null)
        {
            unique = true;
        }
        return unique;

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

    public WeightFactorList<IWeightFactor> getWeightFactorList()
    {
        return myCostEstimation.getWeightFactorList();

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

    public void addAddition(String title, String description) throws DuplicateIDException
    {
        if (myAdditions.isIncluded(title))
        {
            throw new DuplicateIDException(title);
        }
        else
        {
            Addition myAdd = new Addition(title, description);
            myAdditions.add(myAdd);
        }

    }

    public void addFRequirement(String id, String title, String actor, String description, ArrayList<String> references)
            throws ArgumentPatternException, DuplicateIDException, UnknownReferenceException
    {
        solveReqReferences(references);
        if (myValidator.isInvalidID(id))
        {
            throw new ArgumentPatternException(PatternType.ID, id, "/LFxxx/");
        }
        if (!isIDunique(id))
        {
            throw new DuplicateIDException(id);
        }
        RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
        for (String ref : references)
        {
            myReferences.add(getAnyReqByID(ref));
        }
        FRequirement myReq = new FRequirement(id, title, actor, description, myReferences);
        myFRequirements.add(myReq);

    }
    

    public void addGlossaryEntry(String term, String sense, String boundary, String validity,
                                          String obscurities, String label, ArrayList<String> crossRef)
            throws DuplicateIDException, UnknownReferenceException
    {
        if (myGlossaryEntries.isIncluded(term))
        {
            throw new DuplicateIDException(term);
        }
        solveGlossaryTerms(crossRef);
        GlossaryList<IGlossaryEntry> myCrossRef = new GlossaryList<IGlossaryEntry>();
        for (String ref : crossRef)
        {
            myCrossRef.add(getGlossaryEntriesByTerm(ref));
        }
        GlossaryEntry myEntry = new GlossaryEntry(term, sense, boundary, validity, obscurities, label, myCrossRef);
        myGlossaryEntries.add(myEntry);

    }

    public void addNFRequirement(String id, String title, String actor, String description, ArrayList<String> references)
            throws ArgumentPatternException, DuplicateIDException, UnknownReferenceException
    {
        solveReqReferences(references);
        if (myValidator.isInvalidID(id))
        {
            throw new ArgumentPatternException(PatternType.ID, id, "/LExxx/");
        }
        if (!isIDunique(id))
        {
            throw new DuplicateIDException(id);
        }
        RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
        for (String ref : references)
        {
            myReferences.add(getAnyReqByID(ref));
        }
        NFRequirement myReq = new NFRequirement(id, title, actor, description, myReferences);
        myNFRequirements.add(myReq);

    }

    public void addProductData(String id, String content, String attribute, String maxCount,
                              ArrayList<String> references)
            throws UnknownReferenceException, ArgumentPatternException, DuplicateIDException
    {
        solveReqReferences(references);
        if (myValidator.isInvalidID(id))
        {
            throw new ArgumentPatternException(PatternType.ID, id, "/LDxxx/");
        }
        if (!isIDunique(id))
        {
            throw new DuplicateIDException(id);
        }
        RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
        for (String ref : references)
        {
            myReferences.add(getAnyReqByID(ref));
        }
        ProductData myReq = new ProductData(id, content, attribute, maxCount, myReferences);
        myProductData.add(myReq);

    }

    public void addQualReq(String criteria, Score value) throws DuplicateIDException
    {
        if (myQualityRequirements.isIncluded(criteria))
        {
            throw new DuplicateIDException(criteria);
        }
        IQualityRequirement myQualReq = new QualityRequirement(criteria, value);
        myQualityRequirements.add(myQualReq);

    }

    public void editAddition(String oldTitle, String newTitle, String description)
            throws UnknownIDException, DuplicateIDException
    {
        if (!myAdditions.isIncluded(oldTitle))
        {
            throw new UnknownIDException(oldTitle);
        }
        if (myAdditions.isIncluded(newTitle))
        {
            throw new DuplicateIDException(newTitle);
        }
        IAddition myIAdd = myAdditions.getAdditionByTitle(title);
        Addition myAdd = (Addition) myIAdd;
        myAdd.edit(title, description);

    }

    public void editCustData(String companyName, String companyCity, String companyStreet, String zip,
                                              String companyCountry, String custName, String custMail, String custPhone,
                                              String pmName, String pmMail, String pmPhone)
            throws ArgumentPatternException
    {
        myCustomerData.edit(companyName, companyCity, companyStreet, zip, companyCountry, custName,
                                    custMail, custPhone, pmName, pmMail, pmPhone);

    }

    public void editFReq(String oldID, String id, String title, String actor, String description,
                        ArrayList<String> references)
            throws UnknownIDException, DuplicateIDException, ArgumentPatternException, UnknownReferenceException
    {
        if (!myFRequirements.isIncluded(oldID))
        {
            throw new UnknownIDException(oldID);
        }
        IFRequirement myIFReq = myFRequirements.getReqByID(oldID);
        if (!isIDunique(id))
        {
            throw new DuplicateIDException(id);
        }
        solveReqReferences(references);
        if (myValidator.isInvalidID(id))
        {
            throw new ArgumentPatternException(PatternType.ID, id, "");
        }
        RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
        FRequirement myFReq = (FRequirement) myIFReq;
        for (String ref : references)
        {
            myReferences.add(getAnyReqByID(ref));
        }
        myFReq.edit(id, title, actor, description, myReferences);
        if (isReferenceOnID(oldID))
        {
            refreshReferences(oldID, id);
        }

    }

    public void editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
                                     String obscurities, String label, ArrayList<String> crossRef)
            throws UnknownIDException, DuplicateIDException, UnknownReferenceException
    {
        if (!myGlossaryEntries.isIncluded(oldTerm))
        {
            throw new UnknownIDException(oldTerm);
        }
        IGlossaryEntry myIEntry = myGlossaryEntries.getEntryByTerm(oldTerm);
        if (myGlossaryEntries.isIncluded(term)) // Test for duplicate Term in GlossaryEntries
        {
            throw new DuplicateIDException(term);
        }
        solveGlossaryTerms(crossRef);
        GlossaryList<IGlossaryEntry> myCrossRef = new GlossaryList<IGlossaryEntry>();
        GlossaryEntry myEntry = (GlossaryEntry)myIEntry;
        for (String ref : crossRef)
        {
            myCrossRef.add(myGlossaryEntries.getEntryByTerm(ref));
        }
        myEntry.edit(term, sense, boundary, validity, obscurities, label, myCrossRef);

    }

    public void editNFReq(String oldID, String id, String title, String actor, String description,
                                ArrayList<String> references)
            throws UnknownIDException, DuplicateIDException, UnknownReferenceException, ArgumentPatternException
    {
        if (!myNFRequirements.isIncluded(oldID))
        {
            throw new UnknownIDException(oldID);
        }
        INFRequirement myINFReq = myNFRequirements.getReqByID(oldID);
        if (!isIDunique(id))
        {
            throw new DuplicateIDException(id);
        }
        solveReqReferences(references);
        if (myValidator.isInvalidID(id))
        {
            throw new ArgumentPatternException(PatternType.ID, id, "/LExxx/");
        }
        RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
        NFRequirement myNFReq = (NFRequirement) myINFReq;
        for (String ref : references)
        {
            myReferences.add(getAnyReqByID(ref));
        }
        myNFReq.edit(id, title, actor, description, myReferences);
        if (isReferenceOnID(oldID))
        {
            refreshReferences(oldID, id);
        }

    }

    public void editProdApp(String description) throws ListOverflowException
    {
        myProductApplication.edit(description);

    }

    public void editProdData(String oldID, String id, String content, String attribute, String maxCount,
                                   ArrayList<String> references)
            throws UnknownIDException, DuplicateIDException, UnknownReferenceException, ArgumentPatternException
    {
        if (!myProductData.isIncluded(oldID))
        {
            throw new UnknownIDException(oldID);
        }
        IProductData myIProdData = myProductData.getReqByID(oldID);
        if (!isIDunique(id))
        {
            throw new DuplicateIDException(id);
        }
        solveReqReferences(references);
        if (myValidator.isInvalidID(id))
        {
            throw new ArgumentPatternException(PatternType.ID, id, "/LDxxx/");
        }
        RequirementList<IRequirement> myReferences = new RequirementList<IRequirement>();
        ProductData myProdData = (ProductData) myIProdData;
        for (String ref : references)
        {
            myReferences.add(getAnyReqByID(ref));
        }
        myProdData.edit(id, content, attribute, maxCount, myReferences);
        if (isReferenceOnID(oldID))
        {
            refreshReferences(oldID, id);
        }

    }

    public void editQualReq(String oldCriteria, String criteria, Score value)
            throws UnknownIDException, DuplicateIDException
    {
        if (!myQualityRequirements.isIncluded(oldCriteria))
        {
            throw new UnknownIDException(oldCriteria);
        }
        IQualityRequirement myIQualReq = myQualityRequirements.getQualReqByCriteria(oldCriteria);
        if (myQualityRequirements.isIncluded(criteria)) // Test for duplicate criteria
        {
            throw new DuplicateIDException(criteria);
        }
        QualityRequirement myQualReq = (QualityRequirement) myIQualReq;
        myQualReq.edit(criteria, value);

    }

    public void editTargetDef(String description) throws ListOverflowException
    {
        myTargetDefinition.edit(description);

    }

    public void rateWeightFactor(Map<String, Integer> myWeightFactors)
            throws MissingCostEstimationException, ListOverflowException, NumberOutOfBoundsException
    {
        boolean success = true;
        if (getCostEstimation() != null)
        {
            throw new MissingCostEstimationException();
        }
        myCostEstimation.rateWeightFactor(myWeightFactors);

    }

    public void remAdditionByTitle(String title) throws UnknownIDException
    {
        if (!myAdditions.isIncluded(title))
        {
            throw new UnknownIDException(title);
        }
        myAdditions.removeByTitle(title);

    }

    public void remCostEstimation() throws MissingCostEstimationException
    {
        if (myCostEstimation == null)
        {
            throw new MissingCostEstimationException();
        }
        myCostEstimation = null;

    }

    public void remFReqByID(String id) throws UnknownIDException
    {
        if (!myFRequirements.isIncluded(id))
        {
            throw new UnknownIDException(id);
        }
        myFRequirements.removeReqByID(id);
        if(isReferenceOnID(id))
        {
            removeRequirementReferences(id);
        }

    }

    public void remGlossEntryByTerm(String term) throws UnknownIDException
    {
        if (!myGlossaryEntries.isIncluded(term))
        {
            throw new UnknownIDException(term);
        }
        myGlossaryEntries.removeEntryByTerm(term);
        if(isReferenceOnTerm(term))
        {
            removeGlossaryReferences(term);
        }

    }

    public void remNFReqByID(String id) throws UnknownIDException
    {
        if (!myNFRequirements.isIncluded(id))
        {
            throw new UnknownIDException(id);
        }
        myNFRequirements.removeReqByID(id);
        if (isReferenceOnID(id))
        {
            removeRequirementReferences(id);
        }

    }

    public void remProdDataByID(String id) throws UnknownIDException
    {
        if (myProductData.isIncluded(id))
        {
            throw new UnknownIDException(id);
        }
        myProductData.removeReqByID(id);
        if (isReferenceOnID(id))
        {
            removeRequirementReferences(id);
        }

    }

    public void remQualReqByCrit(String criteria) throws UnknownIDException
    {
        if (!myQualityRequirements.isIncluded(criteria))
        {
            throw new UnknownIDException(criteria);
        }
        myQualityRequirements.removeQualReqByCriteria(criteria);

    }

    public void setActualState(double actualState) throws NumberOutOfBoundsException
    {
        if (!(actualState > 0))
        {
            throw new NumberOutOfBoundsException(actualState, 0, Double.POSITIVE_INFINITY);
        }
        this.actualState = actualState;

    }

    public void setDataFP(ClassOfDataFP type, String id, int det, int ret)
            throws UnknownIDException, MissingCostEstimationException, DuplicateIDException, NumberOutOfBoundsException
    {
        if (!isReqIncluded(id))
        {
            throw new UnknownIDException(id);
        }
        if (myCostEstimation == null)
        {
            throw new MissingCostEstimationException();
        }
        if (myCostEstimation.getDataFPByID(id) != null) // Test for duplicate initialising
        {
            throw new DuplicateIDException(id);
        }
        IRequirement reference = getAnyReqByID(id);
        myCostEstimation.setDataFP(type, reference, det, ret);

    }

    public void setTransactionFP(ClassOfTransactionFP type, String id, int det, int ftr)
            throws UnknownIDException, MissingCostEstimationException, DuplicateIDException, NumberOutOfBoundsException
    {
        if (!isReqIncluded(id))
        {
            throw new UnknownIDException(id);
        }
        if (myCostEstimation == null)
        {
            throw new MissingCostEstimationException();
        }
        if (myCostEstimation.getTransactionFPByID(id) != null)
        {
            throw new DuplicateIDException(id);
        }
        IRequirement reference = getAnyReqByID(id);
        myCostEstimation.setTransactionFP(type, reference, det, ftr);

    }

    public void addCostEstimation(Map<IClassOfFP, ComplexityMatrix> myComplexityMatrices,
                                        ComplexityWeightMatrix myComplexityWeightMatrix)
    {
        myCostEstimation = new CostEstimation(myComplexityWeightMatrix, myComplexityMatrices,
                                                (WeightFactorList<IWeightFactor>) getWeightFactors());

    }

    public void calcManMonth() throws MissingCostEstimationException
    {
        if (myCostEstimation == null)
        {
            throw new MissingCostEstimationException();
        }
        myCostEstimation.calculateManMonth();

    }

    public void remTransactionFPByID(String id) throws MissingCostEstimationException, UnknownIDException
    {
        if (myCostEstimation == null)
        {
            throw new MissingCostEstimationException();
        }
        if (!isReqIncluded(id))
        {
            throw new UnknownIDException(id);
        }
        IRequirement ReferenceToRequirement = getAnyReqByID(id);
        myCostEstimation.remTransactionFPByID(ReferenceToRequirement);

    }

    public void remDataFPByID(String id) throws MissingCostEstimationException, UnknownIDException
    {
        if (myCostEstimation == null)
        {
            throw new MissingCostEstimationException();
        }
        if (!isReqIncluded(id))
        {
            throw new UnknownIDException(id);
        }
        IRequirement ReferenceToRequirement = getAnyReqByID(id);
        myCostEstimation.remDataFPByID(ReferenceToRequirement);

    }

    public void editTransactionFPByID(ClassOfTransactionFP type, String id, int det, int ftr)
            throws MissingCostEstimationException, UnknownIDException, NumberOutOfBoundsException
    {
        if (myCostEstimation != null)
        {
            throw new MissingCostEstimationException();
        }
        if (!isReqIncluded(id))
        {
            throw new UnknownIDException(id);
        }
        IRequirement ReferenceToRequirement = getAnyReqByID(id);
        myCostEstimation.editTransactionFPByID(type, ReferenceToRequirement, det, ftr);

    }

    public void editDataFPByID(ClassOfDataFP type, String id, int det, int ret)
            throws MissingCostEstimationException, UnknownIDException, NumberOutOfBoundsException
    {
        if (myCostEstimation != null)
        {
            throw new MissingCostEstimationException();
        }
        if (!isReqIncluded(id))
        {
            throw new UnknownIDException(id);
        }
        IRequirement ReferenceToRequirement = getAnyReqByID(id);
        myCostEstimation.editDataFPByID(type, ReferenceToRequirement, det, ret);

    }

    @Override
    public IProductEnvironment getProductEnviroment()
    {
        return myProductEnvironment;

    }

    public void editProdEnv(String description) throws ListOverflowException
    {
        myProductEnvironment.edit(description);

    }

    public void calcFPCount() throws MissingCostEstimationException
    {
        if (myCostEstimation == null)
        {
            throw new MissingCostEstimationException();
        }
        myCostEstimation.calculateFP();

    }

    public void setCustomerDescription(String customerDescription)
    {
        this.customerDescription = customerDescription;

    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;

    }

    public void setProductApplication(IProductApplication myProductApplication) throws ListOverflowException
    {
        this.myProductApplication = new ProductApplication();
        this.myProductApplication.edit(myProductApplication.getDescription());

    }

    public void setProductEnvironment(IProductEnvironment myProductEnvironment) throws ListOverflowException
    {
        this.myProductEnvironment = new ProductEnvironment();
        this.myProductEnvironment.edit(myProductEnvironment.getDescription());

    }

    public void setTargetDefinition(ITargetDefinition myTargetDefinition) throws ListOverflowException
    {
        this.myTargetDefinition = new TargetDefinition();
        this.myTargetDefinition.edit(myTargetDefinition.getDescription());

    }

    public void setCostEstimation(ICostEstimation myCostEstimation,
                                  Map<IClassOfFP, ComplexityMatrix> complexityMatrices,
                                  ComplexityWeightMatrix complexityWeightMatrix)
    {
        this.myCostEstimation = new CostEstimation(complexityWeightMatrix, complexityMatrices, getWeightFactorList());
        this.myCostEstimation.setWeightFactors((WeightFactorList<IWeightFactor>)myCostEstimation.getWeightFactors());
        this.myCostEstimation.setDataFPs(myCostEstimation.getDataFPs());
        this.myCostEstimation.setTransactionFPs(myCostEstimation.getTransactionFPs());
        this.myCostEstimation.calculateFP();
        this.myCostEstimation.calculateManMonth();

    }

    public void setFRequirements(ArrayList<IFRequirement> myFRequirements)
    {
        this.myFRequirements = (RequirementList<IFRequirement>) myFRequirements;

    }

    public void setProductData(ArrayList<IProductData> myProductData)
    {
        this.myProductData = (RequirementList<IProductData>) myProductData;

    }

    public void setNFRequirements(ArrayList<INFRequirement> myNFRequirements)
    {
        this.myNFRequirements = (RequirementList<INFRequirement>) myNFRequirements;

    }

    public void setAdditions(ArrayList<IAddition> myAdditions)
    {
        this.myAdditions = (AdditionList<IAddition>) myAdditions;

    }

    public void setGlossaryEntries(ArrayList<IGlossaryEntry> myGlossaryEntries)
    {
        this.myGlossaryEntries = (GlossaryList<IGlossaryEntry>) myGlossaryEntries;

    }

    public void setQualityRequirements(ArrayList<IQualityRequirement> myQualityRequirements)
    {
        this.myQualityRequirements = (QualityRequirementList<IQualityRequirement>) myQualityRequirements;

    }

}
