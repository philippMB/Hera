package Model_Interfaces;

import Exceptions.*;
import Model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xml.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mbill on 30.06.2017.
 */
class ModelTest
{
    private Model myModel;
    private String pathXML, pathOthers;

    @BeforeEach
    void setUp()
    {
        myModel = new Model();
        pathXML = "test.xml";
        pathOthers = "test.reqan";
    }

    @Test
    void makeNewReqAnWrongPattern()
    {
        try
        {
            myModel.makeNewReqAn("Titel", "Karl", "karl@gmail.com", "1111115054",
                    "Karles","Stuttgart", "Karlsstrasse", "Germany", "70546",
                    "Otto", "otto@gmx.de", "0711 151484");
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void makeNewReqAnPass()
    {
        try
        {
            myModel.makeNewReqAn("Titel", "Karl", "karl@gmail.com", "07833 15054",
                    "Karles","Stuttgart", "Karlsstrasse", "Germany", "70546",
                    "Otto", "otto@gmx.de", "0711 151484");
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void putInRandomData()
    {
        makeNewReqAnPass();
        addGlossEntry();
        addAddition();
        addFReq();
        addQualReq();
        addProdData();
        addNFReq();
        editTargetDef();
        editProdEnv();
        editProdApp();
    }

    @Test
    void saveReqAnWithPath()
    {
        makeNewReqAnPass();
        putInRandomData();
        try
        {
            myModel.saveReqAn(pathOthers);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void saveReqAnWithOutPath()
    {
        saveReqAnWithPath();
        try
        {
            myModel.saveReqAn();
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void openReqAnFile()
    {
        saveReqAnWithPath();
        try
        {
            myModel.openReqAnFile(pathOthers);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void exportToCustom_XML_FormatWithData()
    {
        makeNewReqAnPass();
        putInRandomData();
        try
        {
            myModel.exportToXML(pathXML, XMLFormatType.CUSTOM_XML_FORMAT);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (XMLMarschallingException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (XMLFormatException e)
        {
            e.printStackTrace();
        }
        catch (SingletonRecreationException e)
        {
            e.printStackTrace();
        }
        catch (XMLProcessingException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void importFromCustom_XML_Format()
    {
        exportToCustom_XML_FormatWithData();
        try
        {
            myModel.importFromXML(pathXML,XMLFormatType.CUSTOM_XML_FORMAT);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (XMLUnmarschallException e)
        {
            e.printStackTrace();
        }
        catch (XMLProcessingException e)
        {
            e.printStackTrace();
        }
        catch (XMLFormatException e)
        {
            e.printStackTrace();
        }
        catch (SingletonRecreationException e)
        {
            e.printStackTrace();
        }
        catch (NumberOutOfBoundsException e)
        {
            e.printStackTrace();
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void closeReqAn()
    {
        makeNewReqAnPass();
        try
        {
            myModel.closeReqAn();
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void closeNotExistingReqAn()
    {
        try
        {
            myModel.closeReqAn();
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void deleteReqAn()
    {
        makeNewReqAnPass();
        try
        {
            myModel.deleteReqAn();
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void getSaveStatusForUnsavedReqAn()
    {
        makeNewReqAnPass();
        if(myModel.isReqAnUnsaved())
            System.out.println("ReqAn is Unsaved");
        else
            System.out.println("ReqAn is Saved");
    }

    @Test
    void getSaveStatusForSavedReqAn()
    {
        makeNewReqAnPass();
        saveReqAnWithPath();
        if(!myModel.isReqAnUnsaved())
            System.out.println("ReqAn is Saved");
        else
            System.out.println("ReqAn is Unsaved");
    }

    @Test
    void isFirstUseOfOpenedReqAn()
    {
        makeNewReqAnPass();
        if(myModel.isFirstUseOfOpenedReqAn())
            System.out.println("First use of ReqAn");
    }

    @Test
    void addFReq()
    {
        makeNewReqAnPass();
        ArrayList<String> references = new ArrayList<String>();
        try
        {
            myModel.addFReq("/LF001/", "Öffnen", "Chef", "Chef öffnet Programm", references);
            references.add("/LF001/");
            myModel.addFReq("/LF002/", "Arbeiten", "Chef", "Chef arbeitet damit", references);
            references.add("/LF002/");
            myModel.addFReq("/LF003/", "Schließen", "Chef", "Chef schließt Programm", references);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void addFReqWrongRef()
    {
        makeNewReqAnPass();
        ArrayList<String> references = new ArrayList<String>();
        references.add("/LF001/");
        try
        {
            myModel.addFReq("/LF001/", "Öffnen", "Chef", "Chef öffnet Programm", references);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void addNFReq()
    {makeNewReqAnPass();
        ArrayList<String> references = new ArrayList<String>();
        try
        {
            myModel.addNFReq("/LE001/", "Robust", "Chef", "robustes Programm", references);
            references.add("/LE001/");
            myModel.addNFReq("/LE002/", "Schnell", "Chef", "schnelles Programm", references);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void addProdData()
    {
        makeNewReqAnPass();
        ArrayList<String> references = new ArrayList<String>();
        try
        {
            myModel.addProdData("/LD001/", "Allg. Daten", "Data1", "12", references);
            references.add("/LD001/");
            myModel.addProdData("/LD002/", "spez. Daten", "Data2", "42", references);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void addFReqReferenceToProdData()
    {
        addProdData();
        ArrayList<String> references = new ArrayList<String>();
        try
        {
            myModel.addFReq("/LF001/", "Öffnen", "Chef", "Chef öffnet Programm", references);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void editFReqNewID()
    {
        addFReq();
        ArrayList<String> references = new ArrayList<String>();
        try
        {
            myModel.editFReq("/LF001/", "/LF010","Öffnen", "Chef",
                    "Chef öffnet Programm", references );
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void editFReqSameID()
    {
        addFReq();
        ArrayList<String> references = new ArrayList<String>();
        try
        {
            myModel.editFReq("/LF001/", "/LF001","Öffnen", "Cheffe",
                    "Chef öffnet Programm", references );
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void editFReqNotMatchingID()
    {
        addFReq();
        try
        {
            myModel.editFReq("/LF123/", "/LF123/", "Titel", "Akteur", "Berschreibung",
                    new ArrayList<String>());
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void remFReqByID()
    {
        addFReq();
        try
        {
            myModel.remFReqByID("/LF001/");
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void editCustData()
    {
        makeNewReqAnPass();
        try
        {
            myModel.editCustData("HansWurst AG", "Stuttgart", "", "70546",
                    "D", "Hans", "hans@hanswurst.de", "0711 123456",
                    "Wurst", "wurst@hanswurst.de", "0711 654321");
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void editTargetDef()
    {
        makeNewReqAnPass();
        try
        {
            myModel.editTargetDef("Das ist die Zieldefinition!");
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void editProdEnv()
    {
        makeNewReqAnPass();
        try
        {
            myModel.editProdEnv("Das ist die Produktumgebung!");
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void editProdApp()
    {
        makeNewReqAnPass();
        try
        {
            myModel.editProdApp("Das ist die Produkt Applikation");
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void addQualReq()
    {
        makeNewReqAnPass();
        try
        {
            myModel.addQualReq("Schnell", Score.VERYIMPORTANT);
            myModel.addQualReq("Robust", Score.VERYIMPORTANT);
            myModel.addQualReq("Benutzerfreundlich", Score.VERYIMPORTANT);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void editQualReq()
    {
        addQualReq();
        try
        {
            myModel.editQualReq("Schnell", "Geschwindigkeit", Score.VERYIMPORTANT);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void remQualReqByCrit()
    {
        addQualReq();
        try
        {
            myModel.remQualReqByCrit("Schnell");
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void addAddition()
    {
        makeNewReqAnPass();
        try
        {
            myModel.addAddition("Ergänzung1", "Es handelt sich hierbei um Ergänzung 1");
            myModel.addAddition("Ergänzung2", "Es handelt sich hierbei um Ergänzung 2");
            myModel.addAddition("Ergänzung3", "Es handelt sich hierbei um Ergänzung 3");
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void addToManyAdditions()
    {
        makeNewReqAnPass();
        try
        {
            for (int i = 0; i < 101 ; i++)
            {
                myModel.addAddition("Ergänzung" + i, "Es handelt sich hierbei um Ergänzung " + i);
            }
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void editAddition()
    {
        addAddition();
        try
        {
            myModel.editAddition("Ergänzung1", "Ergänzung 1", "Halo i bims, Ergämzumg 1");
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void remAdditionByTitle()
    {
        addAddition();
        try
        {
            myModel.remAdditionByTitle("Ergänzung1");
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void addGlossEntry()
    {
        makeNewReqAnPass();
        ArrayList<String> crossReference = new ArrayList<String>();
        try
        {
            myModel.addGlossEntry("Glossar", "Ist ein Glossar.", "Alles was kein Glossar ist.",
                    "In diesem Projekt.", "Gibt's nicht.", "Gibt's auch nicht", crossReference);
            myModel.addGlossEntry("Glossar2", "Ist ein Glossar2.", "Alles was kein Glossar2 ist.",
                    "In dem Projekt2", "Gibt's nicht2", "Gibt's auch nicht2", crossReference);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void editGlossEntry()
    {
        ArrayList<String> crossReference = new ArrayList<String>();
        addGlossEntry();
        try
        {
            myModel.editGlossEntry("Glossar", "", "","","","","",
                    crossReference);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void remGlossEntryByTerm()
    {
        addGlossEntry();
        try
        {
            myModel.remGlossEntryByTerm("Glossar2");
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void addCostEstimation()
    {
        putInRandomData();
        try
        {
            myModel.addCostEstimation();
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void addSecondCostEstimation()
    {
        addCostEstimation();
        try
        {
            myModel.addCostEstimation();
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void remCostEstimation()
    {
        addCostEstimation();
        try
        {
            myModel.remCostEstimation();
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void isReferenceOnID()
    {
        addFReq();
        if (myModel.isReferenceOnID("/LF001/"))
            System.out.println("/LF001/ is referenced");
        else
            System.out.println("/LF001/ is not referenced");
        if (myModel.isReferenceOnID("/LF010/"))
            System.out.println("/LF010/ is referenced");
        else
            System.out.println("/LF010/ is not referenced");
    }

    @Test
    void isIDUnique()
    {
        addFReq();
        if (myModel.isIDUnique("/LF001/"))
            System.out.println("/LF001/ is unique");
        else
            System.out.println("/LF001/ is not unique");
        if (myModel.isIDUnique("/LF010/"))
            System.out.println("/LF010/ is unique");
        else
            System.out.println("/LF010/ is not unique");
    }

    @Test
    void existsActualState()
    {
        makeNewReqAnPass();
        if (myModel.existsActualState())
            System.out.println("Actual state is existing");
        else
            System.out.println("Actual state is not existing");
    }

    @Test
    void existsFPCount()
    {
        addCostEstimation();
        if (myModel.existsFPCount())
            System.out.println("Function Point count is existing");
        else
            System.out.println("Function Point count is not existing");
    }

    @Test
    void existsManMonthCount()
    {
        addCostEstimation();
        if (myModel.existsManMonthCount())
            System.out.println("Man Month count is existing");
        else
            System.out.println("Man Month count is not existing");
    }

    @Test
    void setDataFP()
    {
        addCostEstimation();
        try
        {
            myModel.setDataFP(ClassOfDataFP.EIF_EXTERNAL_INPUT_FILE, "/LD001/", 5, 7);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
        catch (NumberOutOfBoundsException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void setTransactionFP()
    {
        addCostEstimation();
        try
        {
            myModel.setTransactionFP(ClassOfTransactionFP.EI_INPUT, "/LF001/", 5,3);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
        catch (NumberOutOfBoundsException e)
        {
            e.printStackTrace();
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void editDataFPByID()
    {
        setDataFP();
        try
        {
            myModel.editDataFPByID(ClassOfDataFP.ILF_INTERNAL_LOGICAL_FILE,"/LD001/", 2, 3);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
        }
        catch (NumberOutOfBoundsException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void remTransactionFPByID()
    {
        setTransactionFP();
        try
        {
            myModel.remTransactionFPByID("/LF001/");
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void rateWeightFactor()
    {
        addCostEstimation();
        ArrayList<IWeightFactor> myFactors = myModel.getAllWeightFactor();
        HashMap<String, Integer> ratedFactors = new HashMap<String, Integer>();
        Random rn = new Random();
        for (IWeightFactor myFactor : myFactors)
        {
            String title = myFactor.getTitle();
            int value = rn.nextInt(6);
            ratedFactors.put(title, value);
        }
        try
        {
            myModel.rateWeightFactor(ratedFactors);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (NumberOutOfBoundsException e)
        {
            e.printStackTrace();
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void calcFPCount()
    {
        setDataFP();
        setTransactionFP(); // Throws some DuplicateIDErrors because of second call of putInRandomData
        rateWeightFactor();
        try
        {
            myModel.calcFPCount();
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void calcManMonth()
    {
        calcFPCount();
        try
        {
            myModel.calcManMonth(); // throws Duplicate ID errors because of second call of putInRandomData
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void setActualState()
    {
        addCostEstimation();
        try
        {
            myModel.setActualState(2.0);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (NumberOutOfBoundsException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void existsOptWeightFactor()
    {
        if(myModel.existsOptWeightFactor())
            System.out.println("Optimal Weight Factors are existing");
        else
            System.out.println("Optimal Weight Factors are not existing");
    }

    @Test
    void adjustWeightFactor()
    {
        rateWeightFactor();
        calcManMonth(); // throws error because of many calls of putInRandomData
        setActualState();
        try
        {
            myModel.adjustWeightFactor();
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
        }
        catch (MissingFPException e)
        {
            e.printStackTrace();
        }
        catch (NumberOutOfBoundsException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void existsID()
    {
        putInRandomData();
        if(myModel.existsID("/LF001/"))
            System.out.println("ID /LF001/ exists");
        else
            System.out.println("ID /LF001/ does not exists");
        if(myModel.existsID("/LF00/"))
            System.out.println("ID /LF00/ exists");
        else
            System.out.println("ID /LF00/ does not exists");
    }

    @Test
    void getFReqByID()
    {
        putInRandomData();
        IFRequirement myReq = myModel.getFReqByID("/LF001/");
        System.out.println("Titel: " + myReq.getTitle());
        System.out.println("ID: " + myReq.getID());
        System.out.println("Actor: " + myReq.getActor());
        System.out.println("Description: " + myReq.getDescription());
        System.out.println("Referenzen:");
        int i = 0;
        for (String ref : myReq.getReferenceIDs())
        {
            System.out.println("Referenz " + i + ": " + ref);
        }
        if (i == 0)
        {
            System.out.println("Keine Referenzen");
        }
    }

    @Test
    void getCustomerData()
    {
        putInRandomData();
        System.out.println("Kundenname: " + myModel.getCustomerData().getCName());
        System.out.println("Kundenmail: " + myModel.getCustomerData().getCEMail());
        System.out.println("Kundentelnummer: " + myModel.getCustomerData().getCNumber());
        System.out.println("Projektmanagername: " + myModel.getCustomerData().getPMName());
        System.out.println("Projektmanagermail: " + myModel.getCustomerData().getPMEMail());
        System.out.println("Projektmanagertelnummer: " + myModel.getCustomerData().getPMPNumber());
        System.out.println("Firmenname: " + myModel.getCustomerData().getCompanyName());
        System.out.println("Straße: " + myModel.getCustomerData().getCompanyStreet());
        System.out.println("Postleitzahl: " + myModel.getCustomerData().getCompanyPLZ());
        System.out.println("Stadt: " + myModel.getCustomerData().getCompanyCity());
        System.out.println("Land: " + myModel.getCustomerData().getCompanyCountry());
    }

    @Test
    void getProdApp()
    {
        putInRandomData();
        System.out.println(myModel.getProdApp().getDescription());
    }

    @Test
    void getProdEnv()
    {
        putInRandomData();
        System.out.println(myModel.getProdEnv().getDescription());
    }

    @Test
    void getGlossaryEntryByTerm()
    {
        putInRandomData();
        IGlossaryEntry myEntry = myModel.getGlossaryEntryByTerm("Glossar2");
        System.out.println("Begriff: " + myEntry.getTerm());
        System.out.println("Bedeutung: " + myEntry.getSense());
        System.out.println("Abgrenzung: " + myEntry.getBoundary());
        System.out.println("Unklarheiten: " + myEntry.getObscurities());
        System.out.println("Bezeichnung: " + myEntry.getLabel());
        System.out.println("Gültigkeit: " + myEntry.getValidity());
        System.out.println("Referenzen:");
        int i = 0;
        for (String ref : myEntry.getReferenceTerms())
        {
            System.out.println("Referenz " + i + ": " + ref);
        }
        if (i == 0)
        {
            System.out.println("Keine Referenzen");
        }
    }

    @Test
    void getAllFReq()
    {
        putInRandomData();
        for (IFRequirement myFReq : myModel.getAllFReq())
        {
            System.out.println("Titel: " + myFReq.getTitle());
            System.out.println("ID: " + myFReq.getID());
            System.out.println("Actor: " + myFReq.getActor());
            System.out.println("Description: " + myFReq.getDescription());
            System.out.println("Referenzen:");
            int i = 0;
            for (String ref : myFReq.getReferenceIDs())
            {
                System.out.println("Referenz " + i + ": " + ref);
            }
            if (i == 0)
            {
                System.out.println("Keine Referenzen");
            }
            System.out.println();
        }
    }

    @Test
    void getAllReqIDs()
    {
        putInRandomData();
        for(String id : myModel.getAllReqIDs())
        {
            System.out.println("ID: " + id);
        }
    }
}