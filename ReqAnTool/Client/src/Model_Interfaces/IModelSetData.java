package Model_Interfaces;

import java.util.ArrayList;

public interface IModelSetData
{

    public void addFReq(String id, String title, String actor, String description, ArrayList<String> references) throws Exception;

    public void addNFReq(String id, String title, String actor, String description, ArrayList<String> references) throws Exception;

    public void addProdData(String id, String content, String attribute, String maxCount, ArrayList<String> references) throws Exception;

    public void editFReq(String oldID, String id, String title, String actor, String description, ArrayList<String> references) throws Exception;

    public void editNFReq(String oldID, String id, String title, String actor, String description, ArrayList<String> references) throws Exception;

    public void editProdData(String oldID, String id, String content, String attribute, String maxCount,
                         ArrayList<String> references) throws Exception;

    public void remFReqByID(String id) throws Exception;

    public void remNFReqByID(String id) throws Exception;

    public void remProdDataByID(String id) throws Exception;

    public void editCustData(String companyName, String companyCity, String companyStreet, String zip, String companyCountry,
                         String custName, String custMail, String custPhone, String pmName, String pmMail,
                         String pmPhone) throws Exception;

    public void editTargetDef(String description) throws Exception;

    public void editProdApp(String description) throws Exception;

    public void editProdEnv(String description) throws Exception;

    public void addQualReq(String criteria, Score value) throws Exception;

    public void editQualReq(String oldCriteria, String criteria, Score value) throws Exception;

    public void remQualReqByCrit(String criteria) throws Exception;

    public void addAddition(String title, String description) throws Exception;

    public void editAddition(String oldTitle, String newTitle, String description) throws Exception;

    public void remAdditionByTitle(String title) throws Exception;

    public void addGlossEntry(String term, String sense, String boundary, String validity, String obscurities,
                          String label, ArrayList<String> references) throws Exception;

    public void editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
                           String obscurities, String label, ArrayList<String> references) throws Exception;

    public void remGlossEntryByTerm(String term) throws Exception;

    public void addCostEstimation() throws Exception;

    public void remCostEstimation() throws Exception;

}
