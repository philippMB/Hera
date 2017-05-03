package Model_Interfaces;

public interface IApplications
{
<<<<<<< HEAD
    boolean existsID(String id);

    int saveReqAn(String path);
=======
    
    public boolean existsID(String id);

    public int saveReqAn(String path);
>>>>>>> 9cdce7ea87eff28f9af5bcaf7ae45e8b6b35d527

    public int deleteReqAn();

    public boolean isReqAnUnsaved();

<<<<<<< HEAD
    boolean checkReferenceOnID(String id);

    public boolean isIDUnique(String id);


=======
    public boolean checkReferenceOnID(String id);

    public boolean isIDUnique(String id);

>>>>>>> 9cdce7ea87eff28f9af5bcaf7ae45e8b6b35d527
    public boolean existsActualState();

    public boolean existsFPCount();

    public boolean existsManMonthCount();

<<<<<<< HEAD
    boolean setDataFP(String type, String id, int det, int ret);
=======
    public boolean setDataFP(String type, String id, int det, int ret);
>>>>>>> 9cdce7ea87eff28f9af5bcaf7ae45e8b6b35d527

    public boolean setTransactionFP(String type, String ref, int det, int ftr);

    public boolean rateWeightFactor(int cat1, int cat2, int cat3, int cat4a, int cat4b, int cat4c, int cat4d, int cat5,
                                    int cat6, int cat7);

    public boolean calcManMonth();

    public boolean setActualState(double actStat);

    public boolean calcOptWeightFactor();

    public boolean existsOptWeightFactor();
<<<<<<< HEAD
=======

    public boolean checkIDFormat(String id);

    public boolean checkMailFormat(String mail);

    public boolean checkPhoneFormat(String phone);

    public boolean checkAddressFormat(String addr);

    public boolean checkCountry(String country);

    public boolean checkZIP(int zip);

    public boolean checkDET_FTR_RET(int value);

>>>>>>> 9cdce7ea87eff28f9af5bcaf7ae45e8b6b35d527
}
