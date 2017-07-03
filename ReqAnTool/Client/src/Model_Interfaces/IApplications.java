package Model_Interfaces;

import Exceptions.*;
import xml.*;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Sets the Methods which are needed for Applications on the Requirement Analysis.
 * The class allows the users to interact with the Analysis and to save the progress.
 * An user can calculate, manipulate and set Data for the Requirement Analysis.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IRequirementAnalysis
 */
public interface IApplications {


    /**
     * Test, if an ID is already existing in the opened RequirementAnalysis
     * @param id The ID which will be tested
     * @return True, if the ID is already existing. Otherwise, false.
     */
    boolean existsID(String id);


    /**
     * Saves the opened RequirementAnalysis to the given path.
     * @param path The path under which the RequirementAnalysis is saved.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws DataAccessException Is thrown, if the Access to the given path is not possible.
     */
    void saveReqAn(String path) throws MissingReqAnException, DataAccessException;


    /**
     * Saves the opened Requirement Analysis to the former path. This method is only succesful if it was saved before
     * with the path as argument.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws DataAccessException Is thrown, if the Access to the given path is not possible.
     */
    void saveReqAn() throws MissingReqAnException, DataAccessException;


    /**
     * Exports the open Requirement Analysis to XML.
     * @param path The target path for the XML file.
     * @param type The type of the XML Format (Custom XML or RIF)
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws FileNotFoundException Is thrown, if the File could not be found under the given path.
     * @throws XMLMarschallingException XMLError while Marschalling the Requirement Analysis.
     * @throws XMLFormatException XMLError while proofing the XML Format.
     * @throws SingletonRecreationException SingletonError.
     * @throws XMLProcessingException Error while processing the XML export.
     */
    void exportToXML(String path, XMLFormatType type) throws MissingReqAnException, FileNotFoundException, XMLMarschallingException, XMLFormatException, SingletonRecreationException, XMLProcessingException;



    /**
     * Imports a Requirement Analysis from XML
     * @param path The path of the XML file to import.
     * @param type The type of the XML Format (Custom XML or RIF
     * @throws FileNotFoundException Is thrown, if the File could not be found under the given path.
     * @throws NumberOutOfBoundsException Is thrown, if the assignment of a number is out of the bounds.
     * @throws ArgumentPatternException Is thrown, if at least one of the arguments does not fit the Pattern
     * @throws ListOverflowException Is thrown if a Listelement should be assigned but the maximum count is already
     * achieved.
     * @throws XMLUnmarschallException XMLError while Unmarschalling the Requirement Analysis.
     * @throws XMLProcessingException Error while processing the XML export.
     * @throws XMLFormatException XMLError while proofing the XML Format.
     * @throws SingletonRecreationException SingletonError.
     */
    void importFromXML(String path, XMLFormatType type) throws FileNotFoundException, NumberOutOfBoundsException, ArgumentPatternException, ListOverflowException, XMLUnmarschallException, XMLProcessingException, XMLFormatException, SingletonRecreationException;


    /**
     * Deletes a Requirement Analysis
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     */
    void deleteReqAn() throws MissingReqAnException;


    /**
     * Makes a new Requirement Analysis with the given Parameters for the specified Customer Data.
     * @param title Title of the Analysis.
     * @param pmName Name of the Project manager.
     * @param pmMail Mail address of the Project Manager.
     * @param pmPhone Phone number of the Project Manager.
     * @param companyName Name of the company.
     * @param city City of the company
     * @param companyStreet Street of the company (incl. house number)
     * @param country Country of the company.
     * @param zip ZIP Code of the City.
     * @param cName Name of the customer.
     * @param cMail Mail address of the customer.
     * @param cPhone Phone number of the customer.
     * @return True, if the assignment was successful. Otherwise false.
     * @throws ArgumentPatternException Is thrown, if at least one of the arguments does not fit the Pattern
     */
    boolean makeNewReqAn(String title, String pmName, String pmMail, String pmPhone, String companyName,
                         String city, String companyStreet, String country, String zip, String cName,
                         String cMail, String cPhone) throws ArgumentPatternException;

    /**
     * Closes an opened Requirement Analysis
     * @return True, if successfully closed. Otherwise, false.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     */
    boolean closeReqAn() throws MissingReqAnException;


    /**
     * Check, if the open Requirement Analysis contains parts which are unsaved.
     * @return True, if Requirement is unsaved. Otherwwise, false.
     */
    boolean isReqAnUnsaved();


    /**
     * Check, if the opened Requirement Analysis is opened for the first time.
     * @return True, if it is opened for the first timer. Otherwise, false.
     */
    boolean isFirstUseOfOpenedReqAn();


    /**
     * Check, if there is a reference on the given Requirement ID
     * @param id ID of the Requirement which should be checked for references
     * @return True, if referenced. Otherwise, false.
     */
    boolean isReferenceOnID(String id);


    /**
     * Check, if the given ID is unique in this Requirement Analysis.
     * @param id ID, which should be checked.
     * @return Truee, if unique. Otherwise, false.
     */
    boolean isIDUnique(String id);


    /**
     * Check, if there is set an actual state for the Requirement Analysis.
     * @return True, if it is set. Otherwise, false.
     */
    boolean existsActualState();


    /**
     * Check, if the Function Point Count was calculated before and is existing.
     * @return True, if calculated. Otherwise, false.
     */
    boolean existsFPCount();


    /**
     * Check, if the Man Month Count was calculated before and is existing.
     * @return
     */
    boolean existsManMonthCount();


    /**
     * Classifies a given Requirement as a Data Function Point and sets its attributes.
     * @param type Type of the Data Function Point (EI, EQ, EO).
     * @param id The ID of the Requirement which will be classified.
     * @param det The count of the Data Element Types for the Requirement
     * @param ret The count of the Record Element Types for the Requirement
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     * @throws NumberOutOfBoundsException Is thrown, if the assignment of a number is out of the bounds.
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis
     * @throws MissingCostEstimationException Is thrown, if the Cost Estimation for the open Analysis is not assigned.
     */
    void setDataFP(ClassOfDataFP type, String id, int det, int ret) throws MissingReqAnException, UnknownIDException, NumberOutOfBoundsException, DuplicateIDException, MissingCostEstimationException;


    /**
     * Classifies a given Requirement as a Transaction Function Point and sets its attributes.
     * @param type Type of the Transaction Function Point (ELF, ILF)
     * @param id The ID of the Requirement which will be classified
     * @param det The count of the Data Element Types for the Requirement.
     * @param ftr The count of the File Type References for the Requirement.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     * @throws NumberOutOfBoundsException Is thrown, if the assignment of a number is out of the bounds.
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     * @throws MissingCostEstimationException Is thrown, if the Cost Estimation for the open Analysis is not assigned.
     */
    void setTransactionFP(ClassOfTransactionFP type, String id, int det, int ftr) throws MissingReqAnException, UnknownIDException, NumberOutOfBoundsException, DuplicateIDException, MissingCostEstimationException;


    /**
     * Edits a Data Function Point by its ID.
     * @param type Type of the Transaction Function Point (ELF, ILF)
     * @param id The ID of the Requirement which will be classified
     * @param det The count of the Data Element Types for the Requirement.
     * @param ret The count of the Record Element Types for the Requirement.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     * @throws MissingCostEstimationException Is thrown, if the Cost Estimation for the open Analysis is not assigned.
     * @throws NumberOutOfBoundsException Is thrown, if the assignment of a number is out of the bounds.
     */
    void editDataFPByID(ClassOfDataFP type, String id, int det, int ret) throws MissingReqAnException, UnknownIDException,
            MissingCostEstimationException, NumberOutOfBoundsException;


    /**
     * Edits a Transaction Function Point by its ID
     * @param type Type of the Transaction Function Point (ELF, ILF)
     * @param id The ID of the Requirement which will be classified
     * @param det The count of the Data Element Types for the Requirement.
     * @param ftr The count of the File Type References for the Requirement.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     * @throws MissingCostEstimationException Is thrown, if the Cost Estimation for the open Analysis is not assigned.
     * @throws NumberOutOfBoundsException Is thrown, if the assignment of a number is out of the bounds.
     */
    void editTransactionFPByID(ClassOfTransactionFP type, String id, int det, int ftr) throws MissingReqAnException, UnknownIDException, MissingCostEstimationException, NumberOutOfBoundsException;


    /**
     * Removes a Transaction Function Point by its ID.
     * @param id The ID of the Requirement which belongs to the Transaction Function Point
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws MissingCostEstimationException Is thrown, if the Cost Estimation for the open Analysis is not assigned.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     */
    void remTransactionFPByID(String id) throws MissingReqAnException, MissingCostEstimationException, UnknownIDException;


    /**
     * Removes a Data Function Point by its ID.
     * @param id The ID of the Requirement which belongs to the Data Function Point
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws MissingCostEstimationException Is thrown, if the Cost Estimation for the open Analysis is not assigned.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     */
    void remDataFPByID(String id) throws MissingReqAnException, MissingCostEstimationException, UnknownIDException;


    /**
     * Rates the Weight Factor to the given Values in between the Bounds for the specific Weight Factor.
     * @param mapOfWeightFactors The Map includes a String which represents the title of the Weight Factor and the
     *                           value of the Weight Factor.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws NumberOutOfBoundsException Is thrown, if the assignment of a number is out of the bounds.
     * @throws MissingCostEstimationException Is thrown, if the Cost Estimation for the open Analysis is not assigned.
     * @throws ListOverflowException Is thrown if a Listelement should be assigned but the maximum count is already
     * achieved.
     */
    void rateWeightFactor(Map<String, Integer> mapOfWeightFactors) throws MissingReqAnException, NumberOutOfBoundsException, MissingCostEstimationException, ListOverflowException;


    /**
     * Calculates the Function Point value for the Requirement Analysis.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws MissingCostEstimationException Is thrown, if the Cost Estimation for the open Analysis is not assigned.
     */
    void calcFPCount() throws MissingReqAnException, MissingCostEstimationException;


    /**
     * Calculates the Man Month value for the Requirement Analysis based on the Function Point value.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws MissingCostEstimationException Is thrown, if the Cost Estimation for the open Analysis is not assigned.
     */
    void calcManMonth() throws MissingReqAnException, MissingCostEstimationException;


    /**
     * Sets the actual State to the given floating Point value.
     * @param actStat Value of the actual state.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws NumberOutOfBoundsException Is thrown, if the assignment of a number is out of the bounds.
     */
    void setActualState(double actStat) throws MissingReqAnException, NumberOutOfBoundsException;


    /**
     * Checks, if there are already optimized Weight Factors.
     * @return True, if they are existing. Otherwise, false.
     */
    boolean existsOptWeightFactor();


    /**
     * Adjusts the Weight Factor based on the actual state and the underlaying algorithm for optimization.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws MissingCostEstimationException Is thrown, if the Cost Estimation for the open Analysis is not assigned.
     * @throws MissingParameter Is thrown, if aa Parameter is missing for the Calculation.
     * @throws NumberOutOfBoundsException Is thrown, if the assignment of a number is out of the bounds.
     */
    void adjustWeightFactor() throws MissingReqAnException, MissingCostEstimationException, MissingFPException, NumberOutOfBoundsException;


    /**
     * Opens a Requirement Analysis from the given path.
     * @param path Path to the Requirement Analysis.
     * @throws DataAccessException Is thrown, if the Access to the given path is not possible.
     */
    void openReqAnFile(String path) throws DataAccessException;

}