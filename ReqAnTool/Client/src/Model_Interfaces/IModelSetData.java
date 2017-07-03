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
    /**
     * Adds a new FunctionalRequirement to the Requirement Analysis.
     * @param id ID of the Functional Requirement.
     * @param title Title of the Functional Requirement.
     * @param actor Actor of the Functional Requirement.
     * @param description Description of the Functional Requirement.
     * @param references References to other Requirements of this Functional Requirement.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open. Is thrown, if there is no Requirement Analysis open.
     * @throws ListOverflowException Is thrown if a Listelement should be assigned but the maximum count is already
     * achieved.
     * @throws ArgumentPatternException Is thrown, if at least one of the arguments does not fit the Pattern
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     */
    void addFReq(String id, String title, String actor, String description, ArrayList<String> references)
            throws MissingReqAnException, ListOverflowException, ArgumentPatternException, UnknownReferenceException,
            DuplicateIDException;

    /**
     * Adds a new NonFunctional Requirement to the Requirement Analysis.
     * @param id ID of the NonFunctional Requirement.
     * @param title Title of the NonFunctional Requirement.
     * @param actor Actor of the NonFunctional Requirement.
     * @param description Description of the NonFunctional Requirement.
     * @param references References to other Requirements of this NonFunctional Requirement.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open. Is thrown, if there is no Requirement Analysis open.
     * @throws ListOverflowException Is thrown if a Listelement should be assigned but the maximum count is already
     * achieved.
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     * @throws ArgumentPatternException Is thrown, if at least one of the arguments does not fit the Pattern
     */
    void addNFReq(String id, String title, String actor, String description, ArrayList<String> references)
            throws MissingReqAnException, ListOverflowException, DuplicateIDException, UnknownReferenceException,
            ArgumentPatternException;

    /**
     * Adds a new Product Data to the Requirement Analysis
     * @param id ID of the Product Data.
     * @param content Content of the Product Data.
     * @param attribute Attribute(s) of the Product Data.
     * @param maxCount Maximum count of this Product Data.
     * @param references References to other Requirements of this Product Data.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open. Is thrown, if there is no Requirement Analysis open.
     * @throws ListOverflowException Is thrown if a Listelement should be assigned but the maximum count is already
     * achieved.
     * @throws ArgumentPatternException Is thrown, if at least one of the arguments does not fit the Pattern
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     */
    void addProdData(String id, String content, String attribute, String maxCount, ArrayList<String> references)
            throws MissingReqAnException, ListOverflowException, ArgumentPatternException, UnknownReferenceException,
            DuplicateIDException;

    /**
     * Edits a Functional Requirement given through the original ID.
     * @param oldID ID of the original Functional Requirement
     * @param id ID of the edited Functional Requirement.
     * @param title Title of the edited Functional Requirement.
     * @param actor Actor of the edited Functional Requirement.
     * @param description Description of the edited Functional Requirement.
     * @param references References to other Requirements of this edited Functional Requirement.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open. Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     * @throws ArgumentPatternException Is thrown, if at least one of the arguments does not fit the Pattern
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     */
    void editFReq(String oldID, String id, String title, String actor, String description, ArrayList<String> references)
            throws MissingReqAnException, UnknownIDException, UnknownReferenceException, ArgumentPatternException,
            DuplicateIDException;

    /**
     * Edits a NonFunctional Requirement given through the original ID.
     * @param oldID ID of the original NonFunctional Requirement
     * @param id ID of the edited NonFunctional Requirement.
     * @param title Title of the edited NonFunctional Requirement.
     * @param actor Actor of the edited NonFunctional Requirement.
     * @param description Description of the edited NonFunctional Requirement.
     * @param references References to other Requirements of this edited NonFunctional Requirement.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open. Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     * @throws ArgumentPatternException Is thrown, if at least one of the arguments does not fit the Pattern
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     */
    void editNFReq(String oldID, String id, String title, String actor, String description, ArrayList<String> references)
            throws MissingReqAnException, UnknownIDException, UnknownReferenceException, ArgumentPatternException,
            DuplicateIDException;

    /**
     * Edits a Product Data given through the original ID.
     * @param oldID ID of the original Product Data.
     * @param id ID of the edited Product Data.
     * @param content Content of the edited Product Data.
     * @param attribute Attribute(s) of th edited Product Data.
     * @param maxCount Maximum Count of this edited Product Data
     * @param references References to other Requirements of this Product Data.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open. Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     * @throws ArgumentPatternException Is thrown, if at least one of the arguments does not fit the Pattern
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     */
    void editProdData(String oldID, String id, String content, String attribute, String maxCount,
                      ArrayList<String> references)
            throws MissingReqAnException, UnknownIDException, UnknownReferenceException, ArgumentPatternException,
            DuplicateIDException;

    //TODO

    /**
     * Removes a Functional Requirement by its ID.
     * @param id ID of the Functional Requirement to Remove.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open. Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     */
    void remFReqByID(String id) throws MissingReqAnException, UnknownIDException;

    /**
     * Removes a NunFunctional Requirement by its ID.
     * @param id ID of the NonFunctioal Requirement to Remove.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     */
    void remNFReqByID(String id) throws MissingReqAnException, UnknownIDException;

    /**
     * Removes a Product Data by its ID
     * @param id ID of the Product Data to Remove.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     */
    void remProdDataByID(String id) throws MissingReqAnException, UnknownIDException;

    /**
     * Edits the Customer Data of the Requirement Analysis.
     * @param companyName Name of the company.
     * @param companyCity City of the company.
     * @param companyStreet Street of the company.
     * @param zip ZIP-Code of the company.
     * @param companyCountry Country of the company.
     * @param custName Name of the Customer.
     * @param custMail Mail address of the Customer.
     * @param custPhone Phone number of the Customer.
     * @param pmName Name of the project manager.
     * @param pmMail Mail address of the project manager.
     * @param pmPhone Phone number of the project manager.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws ArgumentPatternException Is thrown, if at least one of the arguments does not fit the Pattern
     */
    void editCustData(String companyName, String companyCity, String companyStreet, String zip, String companyCountry,
                      String custName, String custMail, String custPhone, String pmName, String pmMail,
                      String pmPhone) throws MissingReqAnException, ArgumentPatternException;

    /**
     * Edits the Target Definition of the Requirement Analysis.
     * @param description The Description for the Target Definition.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws ListOverflowException Is thrown if a Listelement should be assigned but the maximum count is already
     * achieved.
     */
    void editTargetDef(String description) throws MissingReqAnException, ListOverflowException;

    /**
     * Edits the Product Application of the Requirement Analysis
     * @param description The Desription of the Product Application.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws ListOverflowException Is thrown if a Listelement should be assigned but the maximum count is already
     * achieved.
     */
    void editProdApp(String description) throws MissingReqAnException, ListOverflowException;

    /**
     * Edits the Product Environment of the Requirement Analysis.
     * @param description The Description of the Product Environment.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws ListOverflowException Is thrown if a Listelement should be assigned but the maximum count is already
     * achieved.
     */
    void editProdEnv(String description) throws MissingReqAnException, ListOverflowException;

    /**
     * Adds a Quality Requirement to the Requirement Analysis.
     * @param criteria Criteria (String) of the Quality Requirement.
     * @param value Score of the Quality Requirement.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws ListOverflowException Is thrown if a Listelement should be assigned but the maximum count is already
     * achieved.
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     */
    void addQualReq(String criteria, Score value)
            throws MissingReqAnException, ListOverflowException, DuplicateIDException;

    /**
     * Edits a Quality Requirement of the Requirement Analysis by the criteria.
     * @param oldCriteria Criteria of the original Quality Requirement.
     * @param criteria Criteria of the edited Quality Requirement.
     * @param value Score of the Quality Requirement.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     */
    void editQualReq(String oldCriteria, String criteria, Score value)
            throws MissingReqAnException, DuplicateIDException, UnknownIDException;

    /**
     * Removes a Quality Requirement by its criteria.
     * @param criteria Criteria of the Quality Requirement which should be deleted.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     */
    void remQualReqByCrit(String criteria) throws MissingReqAnException, UnknownIDException;

    /**
     * Adds an Addition to the Requirement Analysis.
     * @param title Title of the Addition
     * @param description Description of the Addition.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws ListOverflowException Is thrown if a Listelement should be assigned but the maximum count is already
     * achieved.
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     */
    void addAddition(String title, String description)
            throws MissingReqAnException, ListOverflowException, DuplicateIDException;

    /**
     * Edits an Addition of the Requirement Analysis by its title.
     * @param oldTitle Title of the original Addition.
     * @param newTitle Title of the edited Addition.
     * @param description Description of the edited Addition.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     */
    void editAddition(String oldTitle, String newTitle, String description)
            throws MissingReqAnException, DuplicateIDException, UnknownIDException;

    /**
     * Removes an Addition of the Requirement Analysis by its title
     * @param title Title of the Addition which should be removed.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     */
    void remAdditionByTitle(String title) throws MissingReqAnException, UnknownIDException;

    /**
     * Adds an GlossaryEntry to the Glossar of the Requirement Analysis.
     * @param term Term of the Entry.
     * @param sense Sense of the Entry.
     * @param boundary Boundary of the Entry.
     * @param validity Validity of the Entry.
     * @param obscurities obscurities of the Entry.
     * @param label Label of the Entry.
     * @param references References to other Glossary Entries.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws ListOverflowException Is thrown if a Listelement should be assigned but the maximum count is already
     * achieved.
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     */
    void addGlossEntry(String term, String sense, String boundary, String validity, String obscurities,
                       String label, ArrayList<String> references)
            throws MissingReqAnException, ListOverflowException, DuplicateIDException, UnknownReferenceException;

    /**
     * Edits A Glossary Entry by its Term.
     * @param oldTerm Term of the original Entry.
     * @param term Term of the edited Entry.
     * @param sense Sense of the edited Entry.
     * @param boundary Boundary of the edited Entry.
     * @param validity Validity of the edited Entry.
     * @param obscurities obscurities of the edited Entry.
     * @param label Label of the edited Entry.
     * @param references References to other Glossary Entries.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     */
    void editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
                        String obscurities, String label, ArrayList<String> references)
            throws MissingReqAnException, UnknownIDException, DuplicateIDException, UnknownReferenceException;

    /**
     * Removes a Glossary Entry by its Term.
     * @param term Term of the Entry which should be removed.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws UnknownIDException Is thrown, if the given ID could not be matched to an existing one.
     */
    void remGlossEntryByTerm(String term)
            throws MissingReqAnException, UnknownIDException;

    /**
     * Adds an empty Cost Estimation to the Requirement Analysis.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws DuplicateIDException Is thrown, if the given ID is already part of the Requirement Analysis.
     */
    void addCostEstimation() throws MissingReqAnException, DuplicateIDException;
    //TODO

    /**
     * Removes the Cost Estimation to the Requirement Analysis.
     * @throws MissingReqAnException Is thrown, if there is no Requirement Analysis open.
     * @throws MissingCostEstimationException
     */
    void remCostEstimation() throws MissingReqAnException, MissingCostEstimationException;

}
