package Model;

import Model_Interfaces.IAddition;
import Model_Interfaces.IApplications;
import Model_Interfaces.ICostEstimation;
import Model_Interfaces.ICustomerData;
import Model_Interfaces.IGlossaryEntry;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IModelSetData;
import Model_Interfaces.IProductApplication;
import Model_Interfaces.IQualityRequirement;
import Model_Interfaces.IRequirement;
import Model_Interfaces.ITargetDefinition;
import Model_Interfaces.IWeightFactor;

public class Model
    implements IModelGetData, IModelSetData, IApplications
{

    private RequirementAnalysis myRequirementAnalysis;

    public Model()
    {
    }

    @Override
    public boolean addAddition(String title, String description)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean addCostEstimation()
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean addFReq(String id, String title, String actor, String description, String[] references)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean addGlossEntry(String term, String sense, String boundary, String validity, String obscurities,
                                 String label)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean addNFReq(String id, String title, String actor, String description, String[] references)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean addProdApp(String description)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean addProdData(String id, String content, String attribute, String maxCount, String[] references)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean addQualReq(String criteria, String value)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean addTargetDef(String description)
    {
        // TODO Implement this method
        return false;
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
    public boolean editAddition(String title, String description)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean editCustData(String companyName, String companyCity, String companyStreet, int zip,
                                String companyCountry, String custName, String custMail, String custPhone,
                                String pmName, String pmMail, String pmPhone)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean editFReq(String oldID, String id, String title, String actor, String description,
                            String[] references)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
                                  String obscurities, String label)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean editNFReq(String oldID, String id, String title, String actor, String description,
                             String[] references)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean editProdApp(String description)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean editProdData(String oldID, String id, String content, String attribute, String maxCount,
                                String[] references)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean editQualReq(String oldCriteria, String criteria, String value)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean editTargetDef(String description)
    {
        // TODO Implement this method
        return false;
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
    public IAddition getAddition()
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
    public ICustomerData getCustomerData()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public IGlossaryEntry getGlossaryEntryByTerm(String term)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public IWeightFactor getOptWeightFactor()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public IProductApplication getProdApp()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public IQualityRequirement getQualReqByCriteria(String criteria)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public IRequirement getReqByID(String ID)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ITargetDefinition getTargetDef()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public IWeightFactor getWeightFactor()
    {
        // TODO Implement this method
        return null;
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
    public boolean remAdditionByTitle(String title)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean remCostEstimation()
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean remFReqByID(String id)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean remGlossEntryByTerm(String term)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean remNFReqByID(String id)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean remProdDataByID(String id)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean remQualReqByCrit(String criteria)
    {
        // TODO Implement this method
        return false;
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
}
