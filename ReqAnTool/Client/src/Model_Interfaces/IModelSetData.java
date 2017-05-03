package Model_Interfaces;

public interface IModelSetData
{

    public boolean addFReq(String id, String title, String actor, String description, String[] references);

    public boolean addNFReq(String id, String title, String actor, String description, String[] references);

    public boolean addProdData(String id, String content, String attribute, String maxCount, String[] references);

    public boolean editFReq(String oldID, String id, String title, String actor, String description, String[] references);

    public boolean editNFReq(String oldID, String id, String title, String actor, String description, String[] references);

    public boolean editProdData(String oldID, String id, String content, String attribute, String maxCount,
                         String[] references);

    public boolean remFReqByID(String id);

    public boolean remNFReqByID(String id);

    public boolean remProdDataByID(String id);

    public boolean editCustData(String companyName, String companyCity, String companyStreet, int zip, String companyCountry,
                         String custName, String custMail, String custPhone, String pmName, String pmMail,
                         String pmPhone);

    public boolean editTargetDef(String description);

    public boolean editProdApp(String description);

    public boolean addQualReq(String criteria, String value);

    public boolean editQualReq(String oldCriteria, String criteria, String value);

    public boolean remQualReqByCrit(String criteria);

    public boolean addAddition(String title, String description);

    public boolean editAddition(String title, String description);

    public boolean remAdditionByTitle(String title);

    public boolean addGlossEntry(String term, String sense, String boundary, String validity, String obscurities,
                          String label);

    public boolean editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
                           String obscurities, String label);

    public boolean remGlossEntryByTerm(String term);

    public boolean addCostEstimation();

    public boolean remCostEstimation();

}
