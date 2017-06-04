package Model;

import Model_Interfaces.*;

import java.util.ArrayList;

public class Model
    implements IModelGetData, IModelSetData, IApplications, IModel
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
        if (myReqAn != null)
        {
            ErrorCodes retValue = ErrorCodes.LIST_OVERFLOW;
            if (myReqAn.getAdditions().size() <= 100)
            {
                retValue = myReqAn.addAddition(title, description);
            }
            return retValue;
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes addCostEstimation()
    {
        if (myReqAn != null)
        {
            return myReqAn.addCostEstimation(myConfig.getComplexityMatrix(), myConfig.getComplexityWeightMatrix());
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes addFReq(String id, String title, String actor, String description, ArrayList<String> references)
    {
        if (myReqAn != null)
        {
            ErrorCodes retValue = ErrorCodes.LIST_OVERFLOW;
            if (myReqAn.getFRequirements().size() <= 2000)
            {
                retValue = myReqAn.addFRequirement(id, title, actor, description, references);
            }
            return retValue;
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes addGlossEntry(String term, String sense, String boundary, String validity, String obscurities,
                                 String label, ArrayList<String> crossRef)
    {
        if (myReqAn != null)
        {
            ErrorCodes retValue = ErrorCodes.LIST_OVERFLOW;
            if (myReqAn.getGlossaryEntries().size() <= 3000)
            {
                retValue = myReqAn.addGlossaryEntry(term, sense, boundary, validity, obscurities, label, crossRef);
            }
            return retValue;
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes addNFReq(String id, String title, String actor, String description, ArrayList<String> references)
    {
        if (myReqAn != null)
        {
            ErrorCodes retValue = ErrorCodes.LIST_OVERFLOW;
            if (myReqAn.getFRequirements().size() <= 2000)
            {
                retValue = myReqAn.addNFRequirement(id, title, actor, description, references);
            }
            return retValue;
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes addProdData(String id, String content, String attribute, String maxCount,
                                  ArrayList<String> references)
    {
        if (myReqAn != null)
        {
            ErrorCodes retValue = ErrorCodes.LIST_OVERFLOW;
            if (myReqAn.getFRequirements().size() <= 300)
            {
                retValue = myReqAn.addProductData(id, content, attribute, maxCount, references);
            }
            return retValue;
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes addQualReq(String criteria, Score value)
    {
        if (myReqAn != null)
        {
            ErrorCodes retValue = ErrorCodes.LIST_OVERFLOW;
            if (myReqAn.getFRequirements().size() <= 30)
            {
                retValue = myReqAn.addQualReq(criteria, value);
            }
            return retValue;
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }

    }

    @Override
    public ErrorCodes calcManMonth()
    {
        if (myReqAn != null)
        {
            return myReqAn.calcManMonth();
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes calcOptWeightFactor()
    {
        if (myReqAn != null)
        {
            return ErrorCodes.NO_ERROR;
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
        // TODO Implement this method
    }

    @Override
    public boolean isReferenceOnID(String id)
    {
        if (myReqAn != null)
        {
            return myReqAn.isReferenceOnID(id);
        }
        else
        {
            return false;
        }
    }

    @Override
    public ErrorCodes deleteReqAn()
    {
        this.myReqAn = null;
        this.myConfig = null;
        return ErrorCodes.NO_ERROR;
    }

    @Override
    public ErrorCodes editAddition(String title, String description)
    {
        if (myReqAn != null)
        {
            return myReqAn.editAddition(title, description);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ArrayList<ErrorCodes> editCustData(String companyName, String companyCity, String companyStreet, String zip,
                                String companyCountry, String custName, String custMail, String custPhone,
                                String pmName, String pmMail, String pmPhone)
    {
        if (myReqAn != null)
        {
            return myReqAn.editCustData(companyName, companyCity, companyStreet, zip, companyCountry, custName,
                    custMail, custPhone, pmName, pmMail, pmPhone);
        }
        else
        {
            ArrayList<ErrorCodes> errors = new ArrayList<ErrorCodes>();
            errors.add(ErrorCodes.NO_REQAN);
            return errors;
        }

    }

    @Override
    public ErrorCodes editFReq(String oldID, String id, String title, String actor, String description,
                            ArrayList<String> references)
    {
        if (myReqAn != null)
        {
            return myReqAn.editFReq(oldID, id, title, actor, description, references);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }

    }

    @Override
    public ErrorCodes editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
                                  String obscurities, String label, ArrayList<String> crossRef)
    {
        if (myReqAn != null)
        {
            return myReqAn.editGlossEntry(oldTerm, term, sense, boundary, validity, obscurities, label, crossRef);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes editNFReq(String oldID, String id, String title, String actor, String description,
                             ArrayList<String> references)
    {
        if (myReqAn != null)
        {
            return myReqAn.editNFReq(oldID, id, title, actor, description, references);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }

    }

    @Override
    public ErrorCodes editProdApp(String description)
    {
        if (myReqAn != null)
        {
            return myReqAn.editProdApp(description);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes editProdData(String oldID, String id, String content, String attribute, String maxCount,
                                ArrayList<String> references)
    {
        if (myReqAn != null)
        {
            return myReqAn.editProdData(oldID, id, content, attribute, maxCount, references);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes editQualReq(String oldCriteria, String criteria, Score value)
    {
        if (myReqAn != null)
        {
            return myReqAn.editQualReq(oldCriteria, criteria, value);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes editTargetDef(String description)
    {
        if (myReqAn != null)
        {
            return myReqAn.editTargetDef(description);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public boolean existsActualState()
    {
        if (myReqAn != null)
        {
            return myReqAn.getActualState() == -1.0;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean existsFPCount()
    {
        if (myReqAn.getCostEstimation() != null)
        {
            return myReqAn.getCostEstimation().getFunctionPoints() == -1.0;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean existsID(String id)
    {
        if (myReqAn != null)
        {
            return myReqAn.isReqIncluded(id);
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean existsManMonthCount()
    {
        if (myReqAn.getCostEstimation() != null)
        {
            return myReqAn.getCostEstimation().getManMonth() == -1.0;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean existsOptWeightFactor()
    {
        if (myConfig != null)
        {
            return myConfig.getOptWeightFactors() != null;
        }
        else
        {
            return false;
        }
    }

    @Override
    public ArrayList<IAddition> getAllAddition()
    {
        if (myReqAn != null)
        {
            return myReqAn.getAdditions();
        }
        else
        {
            return null;
        }
    }

    @Override
    public ICostEstimation getCostEstimation()
    {
        if (myReqAn != null)
        {
            return myReqAn.getCostEstimation();
        }
        else
        {
            return null;
        }
    }

    @Override
    public ICustomerData getCustomerData()
    {
        if (myReqAn != null)
        {
            return myReqAn.getCustomerData();
        }
        else
        {
            return null;
        }
    }

    @Override
    public IGlossaryEntry getGlossaryEntryByTerm(String term)
    {
        if (myReqAn != null)
        {
            return myReqAn.getGlossaryEntriesByTerm(term);
        }
        else
        {
            return null;
        }
    }
    
    @Override
    public IProductApplication getProdApp()
    {
        if (myReqAn != null)
        {
            return myReqAn.getProductApplication();
        }
        else
        {
            return null;
        }
    }

    @Override
    public IQualityRequirement getQualReqByCriteria(String criteria)
    {
        if (myReqAn != null)
        {
            return myReqAn.getQualityRequirementsByCriteria(criteria);
        }
        else
        {
            return null;
        }
    }

    @Override
    public ITargetDefinition getTargetDef()
    {
        if (myReqAn != null)
        {
            return myReqAn.getTargetDefinition();
        }
        else
        {
            return null;
        }
    }

    @Override
    public boolean isIDUnique(String id)
    {
        if (myReqAn != null)
        {
            return myReqAn.isIDunique(id);
        }
        else
        {
            return true;
        }
    }

    @Override
    public boolean isReqAnUnsaved()
    {
        return unsaved;
    }

    @Override
    public ErrorCodes rateWeightFactor(ArrayList<Integer> values)
    {
        if (myReqAn != null)
        {
            return myReqAn.rateWeightFactor(values);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes remAdditionByTitle(String title)
    {
        if (myReqAn != null)
        {
            return myReqAn.remAdditionByTitle(title);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes remCostEstimation()
    {
        if (myReqAn != null)
        {
            return myReqAn.remCostEstimation();
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes remFReqByID(String id)
    {
        if (myReqAn != null)
        {
            return myReqAn.remFReqByID(id);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes remGlossEntryByTerm(String term)
    {
        if (myReqAn != null)
        {
            return myReqAn.remGlossEntryByTerm(term);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes remNFReqByID(String id)
    {
        if (myReqAn != null)
        {
            return myReqAn.remNFReqByID(id);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes remProdDataByID(String id)
    {
        if (myReqAn != null)
        {
            return myReqAn.remProdDataByID(id);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes remQualReqByCrit(String criteria)
    {
        if (myReqAn != null)
        {
            return myReqAn.remQualReqByCrit(criteria);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes saveReqAn(String path)
    {
        if (myReqAn != null)
        {
            unsaved = false;
            // TODO
            return ErrorCodes.NO_ERROR;
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes setActualState(double actStat)
    {
        if (myReqAn != null)
        {
            return myReqAn.setActualState(actStat);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes setDataFP(ClassOfDataFP type, String id, int det, int ret)
    {
        if (myReqAn != null)
        {
            return myReqAn.setDataFP(type, id, det, ret);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes setTransactionFP(ClassOfTransactionFP type, String id, int det, int ftr)
    {
        if (myReqAn != null)
        {
            return myReqAn.setTransactionFP(type, id, det, ftr);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes editDataFPByID(ClassOfDataFP type, String id, int det, int ret)
    {
        if (myReqAn != null)
        {
            return myReqAn.editDataFPByID(type, id, det, ret);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes editTransactionFPByID(ClassOfTransactionFP type, String id, int det, int ftr)
    {
        if (myReqAn != null)
        {
            return myReqAn.editTransactionFPByID(type, id, det, ftr);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes remDataFPByID(String id)
    {
        if (myReqAn != null)
        {
            return myReqAn.remDataFPByID(id);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public ErrorCodes remTransactionFPByID(String id)
    {
        if (myReqAn != null)
        {
            return myReqAn.remTransactionFPByID(id);
        }
        else
        {
            return ErrorCodes.NO_REQAN;
        }
    }

    @Override
    public IAddition getAdditionByTitle(String title)
    {
        if (myReqAn != null)
        {
            return myReqAn.getAdditionByTitle(title);
        }
        else
        {
            return null;
        }
    }

    @Override
    public ArrayList<IFRequirement> getAllFReq()
    {
        if (myReqAn != null)
        {
            return myReqAn.getFRequirements();
        }
        else
        {
            return null;
        }
    }

    @Override
    public ArrayList<IGlossaryEntry> getAllGlossEntries()
    {
        if (myReqAn != null)
        {
            return myReqAn.getGlossaryEntries();
        }
        else
        {
            return null;
        }
    }

    @Override
    public ArrayList<INFRequirement> getAllNFReq()
    {
        if (myReqAn != null)
        {
            return myReqAn.getNFRequirements();
        }
        else
        {
            return null;
        }
    }

    @Override
    public ArrayList<IProductData> getAllProdData()
    {
        if (myReqAn != null)
        {
            return myReqAn.getProductData();
        }
        else
        {
            return null;
        }
    }

    @Override
    public ArrayList<IQualityRequirement> getAllQualReq()
    {
        if (myReqAn != null)
        {
            return myReqAn.getQualityRequirements();
        }
        else
        {
            return null;
        }
    }

    @Override
    public ArrayList<IWeightFactor> getAllWeightFactor()
    {
        if (myReqAn != null)
        {
            return myReqAn.getWeightFactors();
        }
        else
        {
            return null;
        }
    }

    @Override
    public IWeightFactor getWeightFactorByTitle(String title)
    {
        if (myReqAn != null)
        {
            return myReqAn.getWeightFactorByTitle(title);
        }
        else
        {
            return null;
        }
    }

    @Override
    public ArrayList<IWeightFactor> getAllOptWeightFactor()
    {
        if (myConfig != null)
        {
            return myConfig.getOptWeightFactors();
        }
        else
        {
            return null;
        }
    }

    @Override
    public IWeightFactor getOptWeightFactorByTitle(String title)
    {
        if (myConfig != null)
        {
            return myConfig.getOptWeightFactorsByTitle(title);
        }
        else
        {
            return null;
        }
    }

    @Override
    public IFRequirement getFReqByID(String id)
    {
        if (myReqAn != null)
        {
            return myReqAn.getFRequirementByID(id);
        }
        else
        {
            return null;
        }
    }

    @Override
    public INFRequirement getNFReqByID(String id)
    {
        if (myReqAn != null)
        {
            return myReqAn.getNFRequirementByID(id);
        }
        else
        {
            return null;
        }
    }

    @Override
    public IProductData getProductDataByID(String id)
    {
        if (myReqAn != null)
        {
            return myReqAn.getProductDataByID(id);
        }
        else
        {
            return null;
        }
    }

    @Override
    public boolean makeNewReqAn(String title, String pmName, String pmMail, String pmPhone)
    {
        if (myReqAn != null)
        {
            return false;
        }
        else
        {
            this.myReqAn = new RequirementAnalysis(title, pmName, pmMail, pmPhone);
            return true;
        }
    }

    @Override
    public ArrayList<String> getAllReqIDs()
    {
        if (myReqAn != null)
        {
            return myReqAn.getAllReqIDs();
        }
        else
        {
            return null;
        }
    }

    @Override
    public IRequirementAnalysis getReqAnalysis()
    {
        return myReqAn;
    }

}
