package Model_Interfaces;

import java.util.ArrayList;

public interface IModelSetData
{

    public ErrorCodes addFReq(String id, String title, String actor, String description, ArrayList<String> references);

    public ErrorCodes addNFReq(String id, String title, String actor, String description, ArrayList<String> references);

    public ErrorCodes addProdData(String id, String content, String attribute, String maxCount, ArrayList<String> references);

    public ErrorCodes editFReq(String oldID, String id, String title, String actor, String description, ArrayList<String> references);

    public ErrorCodes editNFReq(String oldID, String id, String title, String actor, String description, ArrayList<String> references);

    public ErrorCodes editProdData(String oldID, String id, String content, String attribute, String maxCount,
                         ArrayList<String> references);

    public ErrorCodes remFReqByID(String id);

    public ErrorCodes remNFReqByID(String id);

    public ErrorCodes remProdDataByID(String id);

    public ErrorCodes editCustData(String companyName, String companyCity, String companyStreet, int zip, String companyCountry,
                         String custName, String custMail, String custPhone, String pmName, String pmMail,
                         String pmPhone);

    public ErrorCodes editTargetDef(String description);

    public ErrorCodes editProdApp(String description);

    public ErrorCodes addQualReq(String criteria, Score value);

    public ErrorCodes editQualReq(String oldCriteria, String criteria, Score value);

    public ErrorCodes remQualReqByCrit(String criteria);

    public ErrorCodes addAddition(String title, String description);

    public ErrorCodes editAddition(String title, String description);

    public ErrorCodes remAdditionByTitle(String title);

    public ErrorCodes addGlossEntry(String term, String sense, String boundary, String validity, String obscurities,
                          String label, ArrayList<String> references);

    public ErrorCodes editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
                           String obscurities, String label, ArrayList<String> references);

    public ErrorCodes remGlossEntryByTerm(String term);

    public ErrorCodes addCostEstimation();

    public ErrorCodes remCostEstimation();

}
