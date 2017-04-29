package Model_Interfaces;

public interface IModelSetData
{
    boolean addFReq(String id, String title, String actor, String description, String[] references);

    boolean addNFReq(String id, String title, String actor, String description, String[] references);

    boolean addProdData(String id, String content, String attribute, String maxCount, String[] references);

    boolean editFReq(String oldID, String id, String title, String actor, String description, String[] references);

    boolean editNFReq(String oldID, String id, String title, String actor, String description, String[] references);

    boolean editProdData(String oldID, String id, String content, String attribute, String maxCount,
                         String[] references);

    boolean remFReqByID(Strind id);

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
                           String obscurities, String label);

    public boolean remGlossEntryByTerm(String term);
}
