package Model_Interfaces;

import java.util.ArrayList;

public interface IApplications
{
    
    public boolean existsID(String id);

    public ErrorCodes saveReqAn(String path);

    public ErrorCodes deleteReqAn();
    
    public boolean makeNewReqAn(String title, String pmName, String pmMail, String pmPhone);

    public boolean isReqAnUnsaved();

    public boolean isReferenceOnID(String id);

    public boolean isIDUnique(String id);

    public boolean existsActualState();

    public boolean existsFPCount();

    public boolean existsManMonthCount();

    public ErrorCodes setDataFP(ClassOfDataFP type, String id, int det, int ret);

    public ErrorCodes setTransactionFP(ClassOfTransactionFP type, String ref, int det, int ftr);

    public ErrorCodes rateWeightFactor(ArrayList<Integer> values);

    public boolean calcManMonth();

    public ErrorCodes setActualState(double actStat);

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
