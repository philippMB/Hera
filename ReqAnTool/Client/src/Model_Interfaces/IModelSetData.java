package Model_Interfaces;

import Exceptions.*;

import java.util.ArrayList;

/**
 * This class is meant for organizing changes at the opened Requirement Analysis.
 * It contains the methods for adding, editing and removing the attributes of the Requirement Analysis.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IRequirementAnalysis
 */

public interface IModelSetData
{
    // TODO
    /**
     * Adds a new FunctionalRequirement to the
     * @param id
     * @param title
     * @param actor
     * @param description
     * @param references
     * @throws MissingReqAnException
     * @throws ListOverflowException
     * @throws ArgumentPatternException
     * @throws UnknownReferenceException
     * @throws DuplicateIDException
     */
    void addFReq(String id, String title, String actor, String description, ArrayList<String> references)
            throws MissingReqAnException, ListOverflowException, ArgumentPatternException, UnknownReferenceException,
            DuplicateIDException;

    //TODO
    /**
     *
     * @param id
     * @param title
     * @param actor
     * @param description
     * @param references
     * @throws MissingReqAnException
     * @throws ListOverflowException
     * @throws DuplicateIDException
     * @throws UnknownReferenceException
     * @throws ArgumentPatternException
     */
    void addNFReq(String id, String title, String actor, String description, ArrayList<String> references)
            throws MissingReqAnException, ListOverflowException, DuplicateIDException, UnknownReferenceException,
            ArgumentPatternException;

    //TODO

    /**
     *
     * @param id
     * @param content
     * @param attribute
     * @param maxCount
     * @param references
     * @throws MissingReqAnException
     * @throws ListOverflowException
     * @throws ArgumentPatternException
     * @throws UnknownReferenceException
     * @throws DuplicateIDException
     */
    void addProdData(String id, String content, String attribute, String maxCount, ArrayList<String> references)
            throws MissingReqAnException, ListOverflowException, ArgumentPatternException, UnknownReferenceException,
            DuplicateIDException;

    //TODO

    /**
     *
     * @param oldID
     * @param id
     * @param title
     * @param actor
     * @param description
     * @param references
     * @throws MissingReqAnException
     * @throws UnknownIDException
     * @throws UnknownReferenceException
     * @throws ArgumentPatternException
     * @throws DuplicateIDException
     */
    void editFReq(String oldID, String id, String title, String actor, String description, ArrayList<String> references)
            throws MissingReqAnException, UnknownIDException, UnknownReferenceException, ArgumentPatternException,
            DuplicateIDException;

    //TODO

    /**
     *
     * @param oldID
     * @param id
     * @param title
     * @param actor
     * @param description
     * @param references
     * @throws MissingReqAnException
     * @throws UnknownIDException
     * @throws UnknownReferenceException
     * @throws ArgumentPatternException
     * @throws DuplicateIDException
     */
    void editNFReq(String oldID, String id, String title, String actor, String description, ArrayList<String> references)
            throws MissingReqAnException, UnknownIDException, UnknownReferenceException, ArgumentPatternException,
            DuplicateIDException;
    //TODO

    /**
     *
     * @param oldID
     * @param id
     * @param content
     * @param attribute
     * @param maxCount
     * @param references
     * @throws MissingReqAnException
     * @throws UnknownIDException
     * @throws UnknownReferenceException
     * @throws ArgumentPatternException
     * @throws DuplicateIDException
     */
    void editProdData(String oldID, String id, String content, String attribute, String maxCount,
                      ArrayList<String> references)
            throws MissingReqAnException, UnknownIDException, UnknownReferenceException, ArgumentPatternException,
            DuplicateIDException;

    //TODO

    /**
     *
     * @param id
     * @throws MissingReqAnException
     * @throws UnknownIDException
     */
    void remFReqByID(String id) throws MissingReqAnException, UnknownIDException;

    //TODO

    /**
     *
     * @param id
     * @throws MissingReqAnException
     * @throws UnknownIDException
     */
    void remNFReqByID(String id) throws MissingReqAnException, UnknownIDException;

    //TODO

    /**
     *
     * @param id
     * @throws MissingReqAnException
     * @throws UnknownIDException
     */
    void remProdDataByID(String id) throws MissingReqAnException, UnknownIDException;

    //TODO

    /**
     *
     * @param companyName
     * @param companyCity
     * @param companyStreet
     * @param zip
     * @param companyCountry
     * @param custName
     * @param custMail
     * @param custPhone
     * @param pmName
     * @param pmMail
     * @param pmPhone
     * @throws MissingReqAnException
     * @throws ArgumentPatternException
     */
    void editCustData(String companyName, String companyCity, String companyStreet, String zip, String companyCountry,
                      String custName, String custMail, String custPhone, String pmName, String pmMail,
                      String pmPhone) throws MissingReqAnException, ArgumentPatternException;

    //TODO

    /**
     *
     * @param description
     * @throws MissingReqAnException
     * @throws ListOverflowException
     */
    void editTargetDef(String description) throws MissingReqAnException, ListOverflowException;

    //TODO

    /**
     *
     * @param description
     * @throws MissingReqAnException
     * @throws ListOverflowException
     */
    void editProdApp(String description) throws MissingReqAnException, ListOverflowException;

    //TODO

    /**
     *
     * @param description
     * @throws Exception
     */
    void editProdEnv(String description) throws Exception;


    //TODO

    /**
     *
     * @param criteria
     * @param value
     * @throws MissingReqAnException
     * @throws ListOverflowException
     * @throws DuplicateIDException
     */
    void addQualReq(String criteria, Score value)
            throws MissingReqAnException, ListOverflowException, DuplicateIDException;

    //TODO

    /**
     *
     * @param oldCriteria
     * @param criteria
     * @param value
     * @throws MissingReqAnException
     * @throws DuplicateIDException
     * @throws UnknownIDException
     */
    void editQualReq(String oldCriteria, String criteria, Score value)
            throws MissingReqAnException, DuplicateIDException, UnknownIDException;


    //TODO

    /**
     *
     * @param criteria
     * @throws MissingReqAnException
     * @throws UnknownIDException
     */
    void remQualReqByCrit(String criteria) throws MissingReqAnException, UnknownIDException;

    //TODO

    /**
     *
     * @param title
     * @param description
     * @throws MissingReqAnException
     * @throws ListOverflowException
     * @throws DuplicateIDException
     */
    void addAddition(String title, String description)
            throws MissingReqAnException, ListOverflowException, DuplicateIDException;

    //TODO

    /**
     *
     * @param oldTitle
     * @param newTitle
     * @param description
     * @throws MissingReqAnException
     * @throws DuplicateIDException
     * @throws UnknownIDException
     */
    void editAddition(String oldTitle, String newTitle, String description)
            throws MissingReqAnException, DuplicateIDException, UnknownIDException;

    //TODO

    /**
     *
     * @param title
     * @throws MissingReqAnException
     * @throws UnknownIDException
     */
    void remAdditionByTitle(String title) throws MissingReqAnException, UnknownIDException;


    //TODO

    /**
     *
     * @param term
     * @param sense
     * @param boundary
     * @param validity
     * @param obscurities
     * @param label
     * @param references
     * @throws MissingReqAnException
     * @throws ListOverflowException
     * @throws DuplicateIDException
     * @throws UnknownReferenceException
     */
    void addGlossEntry(String term, String sense, String boundary, String validity, String obscurities,
                       String label, ArrayList<String> references)
            throws MissingReqAnException, ListOverflowException, DuplicateIDException, UnknownReferenceException;
    //TODO

    /**
     *
     * @param oldTerm
     * @param term
     * @param sense
     * @param boundary
     * @param validity
     * @param obscurities
     * @param label
     * @param references
     * @throws MissingReqAnException
     * @throws UnknownIDException
     * @throws DuplicateIDException
     * @throws UnknownReferenceException
     */
    void editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
                        String obscurities, String label, ArrayList<String> references)
            throws MissingReqAnException, UnknownIDException, DuplicateIDException, UnknownReferenceException;
    //TODO

    /**
     *
     * @param term
     * @throws MissingReqAnException
     * @throws UnknownIDException
     */
    void remGlossEntryByTerm(String term)
            throws MissingReqAnException, UnknownIDException;
    //TODO

    /**
     *
     * @throws MissingReqAnException
     * @throws DuplicateIDException
     */
    void addCostEstimation() throws MissingReqAnException, DuplicateIDException;
    //TODO

    /**
     *
     * @throws MissingReqAnException
     * @throws MissingCostEstimationException
     */
    void remCostEstimation() throws MissingReqAnException, MissingCostEstimationException;

}
