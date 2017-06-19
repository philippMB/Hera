package Model_Interfaces;

import java.util.ArrayList;
import java.util.Map;

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

    public ErrorCodes editDataFPByID(ClassOfDataFP type, String id, int det, int ret);

    public ErrorCodes editTransactionFPByID(ClassOfTransactionFP type, String id, int det, int ftr);

    public ErrorCodes remTransactionFPByID(String id);

    public ErrorCodes remDataFPByID(String id);

    public ErrorCodes rateWeightFactor(Map<String, Integer> mapOfWeightFactors);

    public ErrorCodes calcFPCount();

    public ErrorCodes calcManMonth();

    public ErrorCodes setActualState(double actStat);

    public ErrorCodes calcOptWeightFactor();

    public boolean existsOptWeightFactor();

}
