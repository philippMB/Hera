package Model_Interfaces;

import Exceptions.*;
import xml.*;

import java.io.FileNotFoundException;
import java.util.Map;

public interface IApplications {
    //TODO

    /**
     *
     * @param id
     * @return
     */
    boolean existsID(String id);
    //TODO

    /**
     *
     * @param path
     * @throws MissingReqAnException
     * @throws DataAccessException
     */
    void saveReqAn(String path) throws MissingReqAnException, DataAccessException;
    //TODO

    /**
     *
     * @throws MissingReqAnException
     * @throws DataAccessException
     */
    void saveReqAn() throws MissingReqAnException, DataAccessException;
    //TODO

    /**
     *
     * @param path
     * @param type
     * @throws MissingReqAnException
     * @throws FileNotFoundException
     * @throws XMLMarschallingException
     * @throws XMLFormatException
     * @throws SingletonRecreationException
     * @throws XMLProcessingException
     */
    void exportToXML(String path, XMLFormatType type) throws MissingReqAnException, FileNotFoundException, XMLMarschallingException, XMLFormatException, SingletonRecreationException, XMLProcessingException;
    //TODO

    /**
     *
     * @param path
     * @param type
     * @throws FileNotFoundException
     * @throws NumberOutOfBoundsException
     * @throws ArgumentPatternException
     * @throws ListOverflowException
     * @throws XMLUnmarschallException
     * @throws XMLProcessingException
     * @throws XMLFormatException
     * @throws SingletonRecreationException
     */
    void importFromXML(String path, XMLFormatType type) throws FileNotFoundException, NumberOutOfBoundsException, ArgumentPatternException, ListOverflowException, XMLUnmarschallException, XMLProcessingException, XMLFormatException, SingletonRecreationException;
    //TODO

    /**
     *
     * @throws MissingReqAnException
     */
    void deleteReqAn() throws MissingReqAnException;
    //TODO

    /**
     *
     * @param title
     * @param pmName
     * @param pmMail
     * @param pmPhone
     * @param companyName
     * @param city
     * @param companyStreet
     * @param country
     * @param zip
     * @param cName
     * @param cMail
     * @param cPhone
     * @return
     * @throws ArgumentPatternException
     */
    boolean makeNewReqAn(String title, String pmName, String pmMail, String pmPhone, String companyName,
                         String city, String companyStreet, String country, String zip, String cName,
                         String cMail, String cPhone) throws ArgumentPatternException;
    //TODO

    /**
     *
     * @return
     * @throws MissingReqAnException
     */
    boolean closeReqAn() throws MissingReqAnException;
    //TODO

    /**
     *
     * @return
     */
    boolean isReqAnUnsaved();
    //TODO

    /**
     *
     * @return
     */
    boolean isFirstUseOfOpenedReqAn();
    //TODO

    /**
     *
     * @param id
     * @return
     */
    boolean isReferenceOnID(String id);
    //TODO

    /**
     *
     * @param id
     * @return
     */
    boolean isIDUnique(String id);
    //TODO

    /**
     *
     * @return
     */
    boolean existsActualState();
    //TODO

    /**
     *
     * @return
     */
    boolean existsFPCount();
    //TODO

    /**
     *
     * @return
     */
    boolean existsManMonthCount();
    //TODO

    /**
     *
     * @param type
     * @param id
     * @param det
     * @param ret
     * @throws MissingReqAnException
     * @throws UnknownIDException
     * @throws NumberOutOfBoundsException
     * @throws DuplicateIDException
     * @throws MissingCostEstimationException
     */
    void setDataFP(ClassOfDataFP type, String id, int det, int ret) throws MissingReqAnException, UnknownIDException, NumberOutOfBoundsException, DuplicateIDException, MissingCostEstimationException;
    //TODO

    /**
     *
     * @param type
     * @param ref
     * @param det
     * @param ftr
     * @throws MissingReqAnException
     * @throws UnknownIDException
     * @throws NumberOutOfBoundsException
     * @throws DuplicateIDException
     * @throws MissingCostEstimationException
     */
    void setTransactionFP(ClassOfTransactionFP type, String ref, int det, int ftr) throws MissingReqAnException, UnknownIDException, NumberOutOfBoundsException, DuplicateIDException, MissingCostEstimationException;
    //TODO

    /**
     *
     * @param type
     * @param id
     * @param det
     * @param ret
     * @throws Exception
     */
    void editDataFPByID(ClassOfDataFP type, String id, int det, int ret) throws Exception;
    //TODO

    /**
     *
     * @param type
     * @param id
     * @param det
     * @param ftr
     * @throws MissingReqAnException
     * @throws UnknownIDException
     * @throws MissingCostEstimationException
     * @throws NumberOutOfBoundsException
     */
    void editTransactionFPByID(ClassOfTransactionFP type, String id, int det, int ftr) throws MissingReqAnException, UnknownIDException, MissingCostEstimationException, NumberOutOfBoundsException;
    //TODO

    /**
     *
     * @param id
     * @throws MissingReqAnException
     * @throws MissingCostEstimationException
     * @throws UnknownIDException
     */
    void remTransactionFPByID(String id) throws MissingReqAnException, MissingCostEstimationException, UnknownIDException;
    //TODO

    /**
     *
     * @param id
     * @throws MissingReqAnException
     * @throws MissingCostEstimationException
     * @throws UnknownIDException
     */
    void remDataFPByID(String id) throws MissingReqAnException, MissingCostEstimationException, UnknownIDException;
    //TODO

    /**
     *
     * @param mapOfWeightFactors
     * @throws MissingReqAnException
     * @throws NumberOutOfBoundsException
     * @throws MissingCostEstimationException
     * @throws ListOverflowException
     */
    void rateWeightFactor(Map<String, Integer> mapOfWeightFactors) throws MissingReqAnException, NumberOutOfBoundsException, MissingCostEstimationException, ListOverflowException;
    //TODO

    /**
     *
     * @throws MissingReqAnException
     * @throws MissingCostEstimationException
     */
    void calcFPCount() throws MissingReqAnException, MissingCostEstimationException;
    //TODO

    /**
     *
     * @throws MissingReqAnException
     * @throws MissingCostEstimationException
     */
    void calcManMonth() throws MissingReqAnException, MissingCostEstimationException;
    //TODO

    /**
     *
     * @param actStat
     * @throws MissingReqAnException
     * @throws NumberOutOfBoundsException
     */
    void setActualState(double actStat) throws MissingReqAnException, NumberOutOfBoundsException;
    //TODO

    /**
     *
     * @return
     */
    boolean existsOptWeightFactor();
    //TODO

    /**
     *
     * @throws MissingReqAnException
     * @throws MissingCostEstimationException
     * @throws MissingFPException
     * @throws NumberOutOfBoundsException
     */
    void adjustWeightFactor() throws MissingReqAnException, MissingCostEstimationException, MissingFPException, NumberOutOfBoundsException;
    //TODO

    /**
     *
     * @param path
     * @throws DataAccessException
     */
    void openReqAnFile(String path) throws DataAccessException;

}