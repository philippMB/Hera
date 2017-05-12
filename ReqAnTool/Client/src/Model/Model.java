package Model;

import Model_Interfaces.*;

import java.util.ArrayList;

public class Model
    implements IModelGetData, IModelSetData, IApplications
{

    private RequirementAnalysis myReqAn;
    private Configuration myConfig;
    private boolean unsaved;

    public Model()
    {
        // TODO uncomment this: myConfig = new Configuration();
        unsaved = true;
        myReqAn = null;
    }

    @Override
    public ErrorCodes addAddition(String title, String description)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = ErrorCodes.LIST_OVERFLOW;
            if (myReqAn.getAdditions().size() <= 100)
            {
                retValue = myReqAn.addAddition(title, description);
            }
        }
        return retValue;
    }

    @Override
    public ErrorCodes addCostEstimation()
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.addCostEstimation(myConfig.getComplexityMatrix(), myConfig.getComplexityWeightMatrix());
        }
        return retValue;
    }

    @Override
    public ErrorCodes addFReq(String id, String title, String actor, String description, ArrayList<String> references)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = ErrorCodes.LIST_OVERFLOW;
            if (myReqAn.getFRequirements().size() <= 2000)
            {
                retValue = myReqAn.addFRequirement(id, title, actor, description, references);
            }
        }
        return retValue;
    }

    @Override
    public ErrorCodes addGlossEntry(String term, String sense, String boundary, String validity, String obscurities,
                                 String label, ArrayList<String> crossRef)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = ErrorCodes.LIST_OVERFLOW;
            if (myReqAn.getGlossaryEntries().size() <= 3000)
            {
                retValue = myReqAn.addGlossaryEntry(term, sense, boundary, validity, obscurities, label, crossRef);
            }
        }
        return retValue;
    }

    @Override
    public ErrorCodes addNFReq(String id, String title, String actor, String description, ArrayList<String> references)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = ErrorCodes.LIST_OVERFLOW;
            if (myReqAn.getFRequirements().size() <= 2000)
            {
                retValue = myReqAn.addNFRequirement(id, title, actor, description, references);
            }
        }
        return retValue;
    }

    @Override
    public ErrorCodes addProdData(String id, String content, String attribute, String maxCount,
                                  ArrayList<String> references)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = ErrorCodes.LIST_OVERFLOW;
            if (myReqAn.getFRequirements().size() <= 300)
            {
                retValue = myReqAn.addProductData(id, content, attribute, maxCount, references);
            }
        }
        return retValue;
    }

    @Override
    public ErrorCodes addQualReq(String criteria, Score value)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = ErrorCodes.LIST_OVERFLOW;
            if (myReqAn.getFRequirements().size() <= 30)
            {
                retValue = myReqAn.addQualReq(criteria, value);
            }
        }
        return retValue;

    }

    @Override
    public ErrorCodes calcManMonth()
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.calcManMonth();
        }
        return retValue;
    }

    @Override
    public ErrorCodes calcOptWeightFactor()
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = ErrorCodes.NO_ERROR;
        }
        return retValue;
        // TODO Implement this method
    }

    @Override
    public boolean isReferenceOnID(String id)
    {
        boolean referenced = false;
        if (myReqAn != null)
        {
            referenced = myReqAn.isReferenceOnID(id);
        }
        return referenced;
    }

    @Override
    public ErrorCodes deleteReqAn()
    {
        this.myReqAn = null;
        this.myConfig = null;
        return ErrorCodes.NO_ERROR;
    }

    @Override
    public ErrorCodes editAddition(String oldTitle, String newTitle, String description)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.editAddition(oldTitle, newTitle, description);
        }
        return retValue;

    }

    @Override
    public ArrayList<ErrorCodes> editCustData(String companyName, String companyCity, String companyStreet, String zip,
                                String companyCountry, String custName, String custMail, String custPhone,
                                String pmName, String pmMail, String pmPhone)
    {
        ArrayList<ErrorCodes> retValue = new ArrayList<ErrorCodes>();
        if (myReqAn != null)
        {
            retValue = myReqAn.editCustData(companyName, companyCity, companyStreet, zip, companyCountry, custName,
                    custMail, custPhone, pmName, pmMail, pmPhone);
        }
        else
        {
            retValue.add(ErrorCodes.NO_REQAN);
        }
        return retValue;

    }

    @Override
    public ErrorCodes editFReq(String oldID, String id, String title, String actor, String description,
                            ArrayList<String> references)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.editFReq(oldID, id, title, actor, description, references);
        }
        return retValue;

    }

    @Override
    public ErrorCodes editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
                                  String obscurities, String label, ArrayList<String> crossRef)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.editGlossEntry(oldTerm, term, sense, boundary, validity, obscurities, label, crossRef);
        }
        return retValue;
    }

    @Override
    public ErrorCodes editNFReq(String oldID, String id, String title, String actor, String description,
                             ArrayList<String> references)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.editNFReq(oldID, id, title, actor, description, references);
        }
        return retValue;

    }

    @Override
    public ErrorCodes editProdApp(String description)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.editProdApp(description);
        }
        return retValue;

    }

    @Override
    public ErrorCodes editProdEnv(String description)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.editProdEnv(description);
        }
        return retValue;

    }

    @Override
    public ErrorCodes editProdData(String oldID, String id, String content, String attribute, String maxCount,
                                ArrayList<String> references)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.editProdData(oldID, id, content, attribute, maxCount, references);
        }
        return retValue;

    }

    @Override
    public ErrorCodes editQualReq(String oldCriteria, String criteria, Score value)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.editQualReq(oldCriteria, criteria, value);
        }
        return retValue;

    }

    @Override
    public ErrorCodes editTargetDef(String description)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.editTargetDef(description);
        }
        return retValue;

    }

    @Override
    public boolean existsActualState()
    {
        boolean exists = false;
        if (myReqAn != null)
        {
            exists = myReqAn.getActualState() == -1.0;
        }
        return exists;

    }

    @Override
    public boolean existsFPCount()
    {
        boolean exists = false;
        if (myReqAn.getCostEstimation() != null)
        {
            exists = myReqAn.getCostEstimation().getFunctionPoints() == -1.0;
        }
        return exists;

    }

    @Override
    public boolean existsID(String id)
    {
        boolean exists = false;
        if (myReqAn != null)
        {
            exists = myReqAn.isReqIncluded(id);
        }
        return exists;

    }

    @Override
    public boolean existsManMonthCount()
    {
        boolean exists = false;
        if (myReqAn.getCostEstimation() != null)
        {
            exists = myReqAn.getCostEstimation().getManMonth() == -1.0;
        }
        return exists;

    }

    @Override
    public boolean existsOptWeightFactor()
    {
        boolean exists = false;
        if (myConfig != null)
        {
            exists = myConfig.getOptWeightFactors() != null;
        }
        return exists;

    }

    @Override
    public ArrayList<IAddition> getAllAddition()
    {
        ArrayList<IAddition> myAdditions = null;
        if (myReqAn != null)
        {
            myAdditions = myReqAn.getAdditions();
        }
        return myAdditions;

    }

    @Override
    public ICostEstimation getCostEstimation()
    {
        ICostEstimation myCostEstimation = null;
        if (myReqAn != null)
        {
            myCostEstimation = myReqAn.getCostEstimation();
        }
        return myCostEstimation;

    }

    @Override
    public ICustomerData getCustomerData()
    {
        ICustomerData myCustomerData = null;
        if (myReqAn != null)
        {
            myCustomerData = myReqAn.getCustomerData();
        }
        return myCustomerData;

    }

    @Override
    public IGlossaryEntry getGlossaryEntryByTerm(String term)
    {
        IGlossaryEntry myEntry = null;
        if (myReqAn != null)
        {
            myEntry = myReqAn.getGlossaryEntriesByTerm(term);
        }
        return myEntry;

    }
    
    @Override
    public IProductApplication getProdApp()
    {
        IProductApplication myProductApplication = null;
        if (myReqAn != null)
        {
            myProductApplication = myReqAn.getProductApplication();
        }
        return myProductApplication;

    }

    @Override
    public IProductEnvironment getProdEnv()
    {
        IProductEnvironment myProdEnv = null;
        if (myReqAn != null)
        {
            myProdEnv = myReqAn.getProductEnviroment();
        }
        return myProdEnv;

    }

    @Override
    public IQualityRequirement getQualReqByCriteria(String criteria)
    {
        IQualityRequirement myQualityRequirement = null;
        if (myReqAn != null)
        {
            myQualityRequirement = myReqAn.getQualityRequirementsByCriteria(criteria);
        }
        return myQualityRequirement;

    }

    @Override
    public ITargetDefinition getTargetDef()
    {
        ITargetDefinition myTargetDefinition = null;
        if (myReqAn != null)
        {
            myTargetDefinition = myReqAn.getTargetDefinition();
        }
        return myTargetDefinition;

    }

    @Override
    public boolean isIDUnique(String id)
    {
        boolean unique = true;
        if (myReqAn != null)
        {
            unique = myReqAn.isIDunique(id);
        }
        return unique;

    }

    @Override
    public boolean isReqAnUnsaved()
    {
        return unsaved;
    }

    @Override
    public ErrorCodes rateWeightFactor(ArrayList<Integer> values)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.rateWeightFactor(values);
        }
        return retValue;

    }

    @Override
    public ErrorCodes calcFPCount()
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.calcFPCount();
        }
        return retValue;
    }

    @Override
    public ErrorCodes remAdditionByTitle(String title)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.remAdditionByTitle(title);
        }
        return retValue;

    }

    @Override
    public ErrorCodes remCostEstimation()
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.remCostEstimation();
        }
        return retValue;

    }

    @Override
    public ErrorCodes remFReqByID(String id)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.remFReqByID(id);
        }
        return retValue;
    }

    @Override
    public ErrorCodes remGlossEntryByTerm(String term)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.remGlossEntryByTerm(term);
        }
        return retValue;

    }

    @Override
    public ErrorCodes remNFReqByID(String id)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.remNFReqByID(id);
        }
        return retValue;

    }

    @Override
    public ErrorCodes remProdDataByID(String id)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.remProdDataByID(id);
        }
        return retValue;

    }

    @Override
    public ErrorCodes remQualReqByCrit(String criteria)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.remQualReqByCrit(criteria);
        }
        return retValue;

    }

    @Override
    public ErrorCodes saveReqAn(String path)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            unsaved = false;
            // TODO
            retValue = ErrorCodes.NO_ERROR;
        }
        return retValue;

    }

    @Override
    public ErrorCodes setActualState(double actStat)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.setActualState(actStat);
        }
        return retValue;

    }

    @Override
    public ErrorCodes setDataFP(ClassOfDataFP type, String id, int det, int ret)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.setDataFP(type, id, det, ret);
        }
        return retValue;

    }

    @Override
    public ErrorCodes setTransactionFP(ClassOfTransactionFP type, String id, int det, int ftr)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.setTransactionFP(type, id, det, ftr);
        }
        return retValue;

    }

    @Override
    public ErrorCodes editDataFPByID(ClassOfDataFP type, String id, int det, int ret)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.editDataFPByID(type, id, det, ret);
        }
        return retValue;

    }

    @Override
    public ErrorCodes editTransactionFPByID(ClassOfTransactionFP type, String id, int det, int ftr)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.editTransactionFPByID(type, id, det, ftr);
        }
        return retValue;

    }

    @Override
    public ErrorCodes remDataFPByID(String id)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.remDataFPByID(id);
        }
        return retValue;

    }

    @Override
    public ErrorCodes remTransactionFPByID(String id)
    {
        ErrorCodes retValue = ErrorCodes.NO_REQAN;
        if (myReqAn != null)
        {
            retValue = myReqAn.remTransactionFPByID(id);
        }
        return retValue;

    }

    @Override
    public IAddition getAdditionByTitle(String title)
    {
        IAddition myAddition = null;
        if (myReqAn != null)
        {
            myAddition = myReqAn.getAdditionByTitle(title);
        }
        return myAddition;

    }

    @Override
    public ArrayList<IFRequirement> getAllFReq()
    {
        ArrayList<IFRequirement> myFRequirements = null;
        if (myReqAn != null)
        {
            myFRequirements = myReqAn.getFRequirements();
        }
        return myFRequirements;

    }

    @Override
    public ArrayList<IGlossaryEntry> getAllGlossEntries()
    {
        ArrayList<IGlossaryEntry> myEntries = null;
        if (myReqAn != null)
        {
            myEntries = myReqAn.getGlossaryEntries();
        }
        return myEntries;

    }

    @Override
    public ArrayList<INFRequirement> getAllNFReq()
    {
        ArrayList<INFRequirement> myNFRequirements = null;
        if (myReqAn != null)
        {
            myNFRequirements = myReqAn.getNFRequirements();
        }
        return myNFRequirements;

    }

    @Override
    public ArrayList<IProductData> getAllProdData()
    {
        ArrayList<IProductData> myProductData = null;
        if (myReqAn != null)
        {
            myProductData = myReqAn.getProductData();
        }
        return myProductData;

    }

    @Override
    public ArrayList<IQualityRequirement> getAllQualReq()
    {
        ArrayList<IQualityRequirement> myQualityRequirements = null;
        if (myReqAn != null)
        {
            myQualityRequirements = myReqAn.getQualityRequirements();
        }
        return myQualityRequirements;

    }

    @Override
    public ArrayList<IWeightFactor> getAllWeightFactor()
    {
        ArrayList<IWeightFactor> myWeightFactors = null;
        if (myReqAn != null)
        {
            myWeightFactors = myReqAn.getWeightFactors();
        }
        return myWeightFactors;

    }

    @Override
    public IWeightFactor getWeightFactorByTitle(String title)
    {
        IWeightFactor myWeightFactor = null;
        if (myReqAn != null)
        {
            return myReqAn.getWeightFactorByTitle(title);
        }
        return myWeightFactor;

    }

    @Override
    public ArrayList<IWeightFactor> getAllOptWeightFactor()
    {
        ArrayList<IWeightFactor> myOptWeightFactors = null;
        if (myConfig != null)
        {
            myOptWeightFactors = myConfig.getOptWeightFactors();
        }
        return myOptWeightFactors;

    }

    @Override
    public IWeightFactor getOptWeightFactorByTitle(String title)
    {
        IWeightFactor myOptWeightFactor = null;
        if (myConfig != null)
        {
            myOptWeightFactor = myConfig.getOptWeightFactorsByTitle(title);
        }
        return myOptWeightFactor;

    }

    @Override
    public IFRequirement getFReqByID(String id)
    {
        IFRequirement myFRequirement = null;
        if (myReqAn != null)
        {
            myFRequirement = myReqAn.getFRequirementByID(id);
        }
        return myFRequirement;

    }

    @Override
    public INFRequirement getNFReqByID(String id)
    {
        INFRequirement myNFRequirement = null;
        if (myReqAn != null)
        {
            myNFRequirement = myReqAn.getNFRequirementByID(id);
        }
        return myNFRequirement;

    }

    @Override
    public IProductData getProductDataByID(String id)
    {
        IProductData myProductData = null;
        if (myReqAn != null)
        {
            myProductData = myReqAn.getProductDataByID(id);
        }
        return myProductData;

    }

    @Override
    public boolean makeNewReqAn(String title, String pmName, String pmMail, String pmPhone)
    {
        boolean success = false;
        if (myReqAn == null)
        {
            this.myReqAn = new RequirementAnalysis(title, pmName, pmMail, pmPhone);
            success = true;
        }
        return success;

    }

    @Override
    public ArrayList<String> getAllReqIDs()
    {
        ArrayList<String> myIDs = null;
        if (myReqAn != null)
        {
            myIDs = myReqAn.getAllReqIDs();
        }
        return myIDs;

    }

    @Override
    public IRequirementAnalysis getReqAnalysis()
    {
        return myReqAn;

    }

}
