package Model_Interfaces;

import java.util.ArrayList;
import java.util.Map;

public interface IApplications
{
    
    public boolean existsID(String id);

    public void saveReqAn(String path) throws Exception;

    public void deleteReqAn() throws Exception;
    
    public boolean makeNewReqAn(String title, String pmName, String pmMail, String pmPhone, String companyName,
                                String city, String companyStreet, String country, String zip, String cName,
                                String cMail, String cPhone);

    public boolean isReqAnUnsaved();

    public boolean isReferenceOnID(String id);

    public boolean isIDUnique(String id);

    public boolean existsActualState();

    public boolean existsFPCount();

    public boolean existsManMonthCount();

    public void setDataFP(ClassOfDataFP type, String id, int det, int ret) throws Exception;

    public void setTransactionFP(ClassOfTransactionFP type, String ref, int det, int ftr) throws Exception;

    public void editDataFPByID(ClassOfDataFP type, String id, int det, int ret) throws Exception;

    public void editTransactionFPByID(ClassOfTransactionFP type, String id, int det, int ftr) throws Exception;

    public void remTransactionFPByID(String id) throws Exception;

    public void remDataFPByID(String id) throws Exception;

    public void rateWeightFactor(Map<String, Integer> mapOfWeightFactors) throws Exception;

    public void calcFPCount() throws Exception;

    public void calcManMonth() throws Exception;

    public void setActualState(double actStat) throws Exception;

    public boolean existsOptWeightFactor();

    public void adjustWeightFactor() throws Exception;

}
