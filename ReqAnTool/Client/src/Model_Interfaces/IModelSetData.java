package Model_Interfaces;

import Exceptions.*;

import java.util.ArrayList;

public interface IModelSetData
{

    void addFReq(String id, String title, String actor, String description, ArrayList<String> references) throws MissingReqAnException, ListOverflowException, ArgumentPatternException, UnknownReferenceException, DuplicateIDException;

    void addNFReq(String id, String title, String actor, String description, ArrayList<String> references) throws MissingReqAnException, ListOverflowException, DuplicateIDException, UnknownReferenceException, ArgumentPatternException;

    void addProdData(String id, String content, String attribute, String maxCount, ArrayList<String> references) throws MissingReqAnException, ListOverflowException, ArgumentPatternException, UnknownReferenceException, DuplicateIDException;

    void editFReq(String oldID, String id, String title, String actor, String description, ArrayList<String> references) throws MissingReqAnException, UnknownIDException, UnknownReferenceException, ArgumentPatternException, DuplicateIDException;

    void editNFReq(String oldID, String id, String title, String actor, String description, ArrayList<String> references) throws MissingReqAnException, UnknownIDException, UnknownReferenceException, ArgumentPatternException, DuplicateIDException;

    void editProdData(String oldID, String id, String content, String attribute, String maxCount,
                      ArrayList<String> references) throws MissingReqAnException, UnknownIDException, UnknownReferenceException, ArgumentPatternException, DuplicateIDException;

    void remFReqByID(String id) throws MissingReqAnException, UnknownIDException;

    void remNFReqByID(String id) throws MissingReqAnException, UnknownIDException;

    void remProdDataByID(String id) throws MissingReqAnException, UnknownIDException;

    void editCustData(String companyName, String companyCity, String companyStreet, String zip, String companyCountry,
                      String custName, String custMail, String custPhone, String pmName, String pmMail,
                      String pmPhone) throws MissingReqAnException, ArgumentPatternException;

    void editTargetDef(String description) throws MissingReqAnException, ListOverflowException;

    void editProdApp(String description) throws MissingReqAnException, ListOverflowException;

    void editProdEnv(String description) throws Exception;

    void addQualReq(String criteria, Score value) throws MissingReqAnException, ListOverflowException, DuplicateIDException;

    void editQualReq(String oldCriteria, String criteria, Score value) throws MissingReqAnException, DuplicateIDException, UnknownIDException;

    void remQualReqByCrit(String criteria) throws MissingReqAnException, UnknownIDException;

    void addAddition(String title, String description)
            throws MissingReqAnException, ListOverflowException, DuplicateIDException;

    void editAddition(String oldTitle, String newTitle, String description) throws MissingReqAnException, DuplicateIDException, UnknownIDException;

    void remAdditionByTitle(String title) throws MissingReqAnException, UnknownIDException;

    void addGlossEntry(String term, String sense, String boundary, String validity, String obscurities,
                       String label, ArrayList<String> references) throws MissingReqAnException, ListOverflowException, DuplicateIDException, UnknownReferenceException;

    void editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
                        String obscurities, String label, ArrayList<String> references) throws MissingReqAnException, UnknownIDException, DuplicateIDException, UnknownReferenceException;

    void remGlossEntryByTerm(String term) throws MissingReqAnException, UnknownIDException;

    void addCostEstimation() throws MissingReqAnException;

    void remCostEstimation() throws MissingReqAnException, MissingCostEstimationException;

}
