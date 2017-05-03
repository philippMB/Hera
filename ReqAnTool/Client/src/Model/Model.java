package Model;

import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IAddition;
import Model_Interfaces.IApplications;
import Model_Interfaces.ICostEstimation;
import Model_Interfaces.ICustomerData;
import Model_Interfaces.IFRequirement;
import Model_Interfaces.IGlossaryEntry;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IModelSetData;
import Model_Interfaces.INFRequirement;
import Model_Interfaces.IProductApplication;
import Model_Interfaces.IProductData;
import Model_Interfaces.IQualityRequirement;
import Model_Interfaces.ITargetDefinition;
import Model_Interfaces.IWeightFactor;

import java.util.ArrayList;

import org.omg.CORBA.PolicyErrorCodeHelper;

public class Model
    implements IModelGetData, IModelSetData, IApplications
{

    private RequirementAnalysis myReqAn;
    private Configuration myConfig;

    public Model()
    {
    }

    @Override
    public ErrorCodes addAddition(String title, String description)
    {
        ErrorCodes retValue = ErrorCodes.LIST_OVERFLOW;
        if (myReqAn.getAdditions().size() <= 100)
        {
            retValue = ErrorCodes.NO_ERROR;
            myReqAn.addAddition(title, description);
        }
        return retValue;
    }

    @Override
    public ErrorCodes addCostEstimation()
    {
        // TODO
        return null;
    }

    @Override
    public ErrorCodes addFReq(String id, String title, String actor, String description, ArrayList<String> references)
    {
        ErrorCodes retValue = ErrorCodes.LIST_OVERFLOW;
        if (myReqAn.getFRequirements().size() <= 2000)
        {
            retValue = myReqAn.addFRequirement(id, title, actor, description, references);
        }
        return retValue;
    }

    @Override
    public ErrorCodes addGlossEntry(String term, String sense, String boundary, String validity, String obscurities,
                                 String label, ArrayList<String> crossRef)
    {
        ErrorCodes retValue = ErrorCodes.LIST_OVERFLOW;
        if (myReqAn.getGlossaryEntries().size() <= 3000)
        {
            retValue = myReqAn.addGlossaryEntry(term, sense, boundary, validity,obscurities, label, crossRef);
        }
        return retValue;
    }

    @Override
    public ErrorCodes addNFReq(String id, String title, String actor, String description, ArrayList<String> references)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes addProdData(String id, String content, String attribute, String maxCount, ArrayList<String> references)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes addQualReq(String criteria, String value)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public boolean calcManMonth()
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean calcOptWeightFactor()
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean checkAddressFormat(String addr)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean checkCountry(String country)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean checkDET_FTR_RET(int value)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean checkIDFormat(String id)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean checkMailFormat(String mail)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean checkPhoneFormat(String phone)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean checkReferenceOnID(String id)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean checkZIP(int zip)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public int deleteReqAn()
    {
        // TODO Implement this method
        return 0;
    }

    @Override
    public ErrorCodes editAddition(String title, String description)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes editCustData(String companyName, String companyCity, String companyStreet, int zip,
                                String companyCountry, String custName, String custMail, String custPhone,
                                String pmName, String pmMail, String pmPhone)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes editFReq(String oldID, String id, String title, String actor, String description,
                            ArrayList<String> references)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
                                  String obscurities, String label, ArrayList<String> crossRef)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes editNFReq(String oldID, String id, String title, String actor, String description,
                             ArrayList<String> references)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes editProdApp(String description)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes editProdData(String oldID, String id, String content, String attribute, String maxCount,
                                ArrayList<String> references)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes editQualReq(String oldCriteria, String criteria, String value)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes editTargetDef(String description)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public boolean existsActualState()
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean existsFPCount()
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean existsID(String id)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean existsManMonthCount()
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean existsOptWeightFactor()
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public ArrayList<IAddition> getAllAddition()
    {
        return myReqAn.getAdditions();
    }

    @Override
    public ICostEstimation getCostEstimation()
    {
        return myReqAn.getCostEstimation();
    }

    @Override
    public ICustomerData getCustomerData()
    {
        return myReqAn.getCustomerData();
    }

    @Override
    public IGlossaryEntry getGlossaryEntryByTerm(String term)
    {
        return myReqAn.getGlossaryEntriesByTerm(term);
    }
    
    @Override
    public IProductApplication getProdApp()
    {
        return myReqAn.getProductApplication();
    }

    @Override
    public IQualityRequirement getQualReqByCriteria(String criteria)
    {
        return myReqAn.getQualityRequirementsByCriteria(criteria);
    }

    @Override
    public ITargetDefinition getTargetDef()
    {
        return myReqAn.getTargetDefinition();
    }

    @Override
    public boolean isIDUnique(String id)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean isReqAnUnsaved()
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean rateWeightFactor(int cat1, int cat2, int cat3, int cat4a, int cat4b, int cat4c, int cat4d, int cat5,
                                    int cat6, int cat7)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public ErrorCodes remAdditionByTitle(String title)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes remCostEstimation()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes remFReqByID(String id)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes remGlossEntryByTerm(String term)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes remNFReqByID(String id)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes remProdDataByID(String id)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ErrorCodes remQualReqByCrit(String criteria)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public int saveReqAn(String path)
    {
        // TODO Implement this method
        return 0;
    }

    @Override
    public boolean setActualState(double actStat)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean setDataFP(String type, String id, int det, int ret)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean setTransactionFP(String type, String ref, int det, int ftr)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public IAddition getAdditionByTitle(String title)
    {
        return myReqAn.getAdditionByTitle(title);
    }

    @Override
    public ArrayList<IFRequirement> getAllFReq()
    {
        // TODO
        return myReqAn.getFRequirements();
    }

    @Override
    public ArrayList<IGlossaryEntry> getAllGlossEntries()
    {
        return myReqAn.getGlossaryEntries();
    }

    @Override
    public ArrayList<INFRequirement> getAllNFReq()
    {
        // TODO Implement this method
        return myReqAn.getNFRequirements();
    }

    @Override
    public ArrayList<IProductData> getAllProdData()
    {
        // TODO Implement this method
        return myReqAn.getProductData();
    }

    @Override
    public ArrayList<IQualityRequirement> getAllQualReq()
    {
        return myReqAn.getQualityRequirements();
    }

    @Override
    public ArrayList<IWeightFactor> getAllWeightFactor()
    {
        return myReqAn.getWeightFactors();
    }

    @Override
    public IWeightFactor getWeightFactorByTitle(String title)
    {
        return myReqAn.getWeightFactorByTitle(title);
    }

    @Override
    public ArrayList<IWeightFactor> getAllOptWeightFactor()
    {
        return myConfig.getOptWeightFactors();
    }

    @Override
    public IWeightFactor getOptWeightFactorByTitle(String title)
    {
        return myConfig.getOptWeightFactorsByTitle(title);
    }

    @Override
    public IFRequirement getFReqByID(String id)
    {
        return myReqAn.getFRequirementByID(id);
    }

    @Override
    public INFRequirement getNFReqByID(String id)
    {
        return myReqAn.getNFRequirementByID(id);
    }

    @Override
    public IProductData getProductDataByID(String id)
    {
        // TODO Implement this method
        return myReqAn.getProductDataByID(id);
    }

    @Override
    public boolean makeNewReqAn(String title, String pmName, String pmMail, String pmPhone)
    {
        RequirementAnalysis myReqAn = new RequirementAnalysis(title, pmName, pmMail, pmPhone);
        return true;
    }

    @Override
    public ArrayList<String> getAllReqIDs()
    {
        return myReqAn.getAllReqIDs();
    }
}
