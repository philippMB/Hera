package Model_Interfaces;

public interface IModelSetData
{
<<<<<<< HEAD
    boolean addFReq(String id, String title, String actor, String description, String[] references);

    boolean addNFReq(String id, String title, String actor, String description, String[] references);

    boolean addProdData(String id, String content, String attribute, String maxCount, String[] references);

    boolean editFReq(String oldID, String id, String title, String actor, String description, String[] references);

    boolean editNFReq(String oldID, String id, String title, String actor, String description, String[] references);

    boolean editProdData(String oldID, String id, String content, String attribute, String maxCount,
                         String[] references);

    boolean remFReqByID(String id);

    boolean remNFReqByID(String id);

    boolean remProdDataByID(String id);

    boolean editCustData(String companyName, String companyCity, String companyStreet, int zip, String companyCountry,
                         String custName, String custMail, String custPhone, String pmName, String pmMail,
                         String pmPhone);

    boolean addTargetDef(String description);

    boolean editTargetDef(String description);

    boolean addProdApp(String description);

    boolean editProdApp(String description);

    boolean addQualReq(String criteria, String value);

    boolean editQualReq(String oldCriteria, String criteria, String value);

    public boolean remQualReqByCrit(String criteria);

    boolean addAddition(String title, String description);

    boolean editAddition(String title, String description);

    public boolean remAdditionByTitle(String title);

    boolean addGlossEntry(String term, String sense, String boundary, String validity, String obscurities,
                          String label);

    boolean editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
=======

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
>>>>>>> 9cdce7ea87eff28f9af5bcaf7ae45e8b6b35d527
                           String obscurities, String label);

    public boolean remGlossEntryByTerm(String term);

    public boolean addCostEstimation();

    public boolean remCostEstimation();
<<<<<<< HEAD
=======

>>>>>>> 9cdce7ea87eff28f9af5bcaf7ae45e8b6b35d527
}
