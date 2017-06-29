package Model_Interfaces;

import Exceptions.*;
import xml.*;

import java.io.FileNotFoundException;
import java.util.Map;

public interface IApplications {

    boolean existsID(String id);

    void saveReqAn(String path) throws MissingReqAnException, DataAccessException;

    void saveReqAn() throws MissingReqAnException, DataAccessException;

    void exportToXML(String path, XMLFormatType type) throws MissingReqAnException, FileNotFoundException, XMLMarschallingException, XMLFormatException, SingletonRecreationException, XMLProcessingException;

    void importFromXML(String path, XMLFormatType type) throws FileNotFoundException, NumberOutOfBoundsException, ArgumentPatternException, ListOverflowException, XMLUnmarschallException, XMLProcessingException, XMLFormatException, SingletonRecreationException;

    void deleteReqAn() throws MissingReqAnException;

    boolean makeNewReqAn(String title, String pmName, String pmMail, String pmPhone, String companyName,
                         String city, String companyStreet, String country, String zip, String cName,
                         String cMail, String cPhone) throws ArgumentPatternException;

    boolean closeReqAn() throws MissingReqAnException;

    boolean isReqAnUnsaved();

    boolean isFirstUseOfOpenedReqAn() throws MissingReqAnException;

    boolean isReferenceOnID(String id);

    boolean isIDUnique(String id);

    boolean existsActualState();

    boolean existsFPCount();

    boolean existsManMonthCount();

    void setDataFP(ClassOfDataFP type, String id, int det, int ret) throws MissingReqAnException, UnknownIDException, NumberOutOfBoundsException, DuplicateIDException, MissingCostEstimationException;

    void setTransactionFP(ClassOfTransactionFP type, String ref, int det, int ftr) throws MissingReqAnException, UnknownIDException, NumberOutOfBoundsException, DuplicateIDException, MissingCostEstimationException;

    void editDataFPByID(ClassOfDataFP type, String id, int det, int ret) throws Exception;

    void editTransactionFPByID(ClassOfTransactionFP type, String id, int det, int ftr) throws MissingReqAnException, UnknownIDException, MissingCostEstimationException, NumberOutOfBoundsException;

    void remTransactionFPByID(String id) throws MissingReqAnException, MissingCostEstimationException, UnknownIDException;

    void remDataFPByID(String id) throws MissingReqAnException, MissingCostEstimationException, UnknownIDException;

    void rateWeightFactor(Map<String, Integer> mapOfWeightFactors) throws MissingReqAnException, NumberOutOfBoundsException, MissingCostEstimationException, ListOverflowException;

    void calcFPCount() throws MissingReqAnException, MissingCostEstimationException;

    void calcManMonth() throws MissingReqAnException, MissingCostEstimationException;

    void setActualState(double actStat) throws MissingReqAnException, NumberOutOfBoundsException;

    boolean existsOptWeightFactor();

    void adjustWeightFactor() throws MissingReqAnException, MissingCostEstimationException, MissingFPException, NumberOutOfBoundsException;

    void openReqAnFile(String path) throws DataAccessException;

}