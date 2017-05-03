package Model_Interfaces;

public interface IApplications
{
   public boolean existsID(String id);

    public int saveReqAn(String path);

    public int deleteReqAn();

    public boolean isReqAnUnsaved();

    public boolean checkReferenceOnID(String id);

    public boolean isIDUnique(String id);

    public boolean existsActualState();

    public boolean existsFPCount();

    public boolean existsManMonthCount();

    public boolean setDataFP(String type, String id, int det, int ret);

    public boolean setTransactionFP(String type, String ref, int det, int ftr);

    public boolean rateWeightFactor(int cat1, int cat2, int cat3, int cat4a, int cat4b, int cat4c, int cat4d, int cat5,
                                    int cat6, int cat7);

    public boolean calcManMonth();

    public boolean setActualState(double actStat);

    public boolean calcOptWeightFactor();

    public boolean existsOptWeightFactor();

    public boolean checkIDFormat(String id);

    public boolean checkMailFormat(String mail);

    public boolean checkPhoneFormat(String phone);

    public boolean checkAddressFormat(String addr);

    public boolean checkCountry(String country);

    public boolean checkZIP(int zip);

    public boolean checkDET_FTR_RET(int value);

}
