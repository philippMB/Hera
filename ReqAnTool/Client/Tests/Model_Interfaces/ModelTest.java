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
    private String pathForSaving;

    @BeforeEach
    void setUp()
    {
        myModel = new Model();
        pathForSaving = "C:\\Users\\mbill\\Documents\\test.reqan";
    }

    @Test
    void makeNewReqAnWrongPattern()
    {
        boolean wrongPattern = false;
        try
        {
            myModel.makeNewReqAn("Titel", "Karl", "karl@gmail.com", "1111115054",
                    "Karles","Stuttgart", "Karlsstrasse", "Germany", "70546",
                    "Otto", "otto@gmx.de", "0711 151484");
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
            wrongPattern = true;
        }
        assertTrue(wrongPattern);
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
            fail("Wrong Argument was not Part of this test");
        }
        assertAll("Functional Requirements",
                () -> assertEquals("Titel", myModel.getReqAnalysis().getTitle()),
                () -> assertEquals("Karles", myModel.getCustomerData().getCompanyName()),
                () -> assertEquals("Stuttgart", myModel.getCustomerData().getCompanyCity()),
                () -> assertEquals("Karlsstrasse", myModel.getCustomerData().getCompanyStreet()),
                () -> assertEquals("70546", myModel.getCustomerData().getCompanyPLZ()),
                () -> assertEquals("Germany", myModel.getCustomerData().getCompanyCountry()),
                () -> assertEquals("Otto", myModel.getCustomerData().getCName()),
                () -> assertEquals("otto@gmx.de", myModel.getCustomerData().getCEMail()),
                () -> assertEquals("0711 151484", myModel.getCustomerData().getCNumber()),
                () -> assertEquals("Karl", myModel.getCustomerData().getPMName()),
                () -> assertEquals("karl@gmail.com", myModel.getCustomerData().getPMEMail()),
                () -> assertEquals("07833 15054", myModel.getCustomerData().getPMPNumber()));
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
        assertTrue(true);
    }

    @Test
    void saveReqAnWithPath()
    {
        makeNewReqAnPass();
        putInRandomData();
        try
        {
            myModel.saveReqAn(pathForSaving);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            fail("Data Access failure was not part of this test");
        }
        assertFalse(myModel.isReqAnUnsaved());
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
            fail("MissingReq was not part of the test");
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            fail("Data Access failure was not part of this test");
        }
        assertFalse(myModel.isReqAnUnsaved());
    }

    @Test
    void openReqAnFile()
    {
        saveReqAnWithPath();
        try
        {
            myModel.openReqAnFile(pathForSaving);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            fail("Data Access failure was not part of this test");
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
            fail("MissingReq was not part of the test");
        }
        assertTrue(myModel.getReqAnalysis() == null);
    }

    @Test
    void closeNotExistingReqAn()
    {
        boolean missedReqAn = false;
        try
        {
            myModel.closeReqAn();
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            missedReqAn = true;
        }
        assertTrue(missedReqAn);
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
            fail("MissingReq was not part of the test");
        }
        assertTrue(myModel.getReqAnalysis() == null);
    }

    @Test
    void getSaveStatusForUnsavedReqAn()
    {
        makeNewReqAnPass();
        assertTrue(myModel.isReqAnUnsaved());
    }

    @Test
    void getSaveStatusForSavedReqAn()
    {
        makeNewReqAnPass();
        saveReqAnWithPath();
        assertFalse(myModel.isReqAnUnsaved());
    }

    @Test
    void isFirstUseOfOpenedReqAn()
    {
        makeNewReqAnPass();
        assertTrue(myModel.isFirstUseOfOpenedReqAn());
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
            fail("MissingReq was not part of the test");
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
            fail("ListOverFlow was not part of this test");
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
            fail("Wrong Argument Pattern was not part of this test");
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
            fail("Unknown Reference was not part of this test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        assertAll("Functional Requirements",
                () -> assertEquals("/LF001/", myModel.getFReqByID("/LF001/").getID()),
                () -> assertEquals("/LF002/", myModel.getFReqByID("/LF002/").getID()),
                () -> assertEquals("/LF003/", myModel.getFReqByID("/LF003/").getID()),
                () -> assertEquals("Öffnen", myModel.getFReqByID("/LF001/").getTitle()),
                () -> assertEquals("Arbeiten", myModel.getFReqByID("/LF002/").getTitle()),
                () -> assertEquals("Schließen", myModel.getFReqByID("/LF003/").getTitle()),
                () -> assertEquals("Chef", myModel.getFReqByID("/LF001/").getActor()),
                () -> assertEquals("Chef", myModel.getFReqByID("/LF002/").getActor()),
                () -> assertEquals("Chef", myModel.getFReqByID("/LF003/").getActor()),
                () -> assertEquals("Chef öffnet Programm", myModel.getFReqByID("/LF001/").getDescription()),
                () -> assertEquals("Chef arbeitet damit", myModel.getFReqByID("/LF002/").getDescription()),
                () -> assertEquals("Chef schließt Programm", myModel.getFReqByID("/LF003/").getDescription()),
                () -> assertEquals("/LF001/", myModel.getFReqByID("/LF002/").getReferenceIDs().get(0)),
                () -> assertEquals("/LF001/", myModel.getFReqByID("/LF003/").getReferenceIDs().get(0)),
                () -> assertEquals("/LF002/", myModel.getFReqByID("/LF003/").getReferenceIDs().get(1)));
    }

    @Test()
    void addFReqWrongRef()
    {
        boolean unknownRef = false;
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
            fail("MissingReq was not part of the test");
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
            fail("ListOverFlow was not part of this test");
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
            fail("Wrong Argument Pattern was not part of this test");
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
            unknownRef = true;
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        assertTrue(unknownRef);
    }

    @Test
    void addNFReq()
    {
        makeNewReqAnPass();
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
            fail("MissingReq was not part of the test");
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
            fail("ListOverFlow was not part of this test");
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
            fail("Wrong Argument Pattern was not part of this test");
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
            fail("Unknown Reference was not part of this test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        assertAll("Nonfunctional Requirements",
                () -> assertEquals("Robust", myModel.getNFReqByID("/LE001/").getTitle()),
                () -> assertEquals("/LE002/", myModel.getNFReqByID("/LE002/").getID()),
                () -> assertEquals("Chef", myModel.getNFReqByID("/LE001/").getActor()),
                () -> assertEquals("schnelles Programm", myModel.getNFReqByID("/LE002/").getDescription()),
                () -> assertEquals("/LE001/", myModel.getNFReqByID("/LE002/").getReferenceIDs().get(0)));
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
            fail("MissingReq was not part of the test");
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
            fail("ListOverFlow was not part of this test");
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
            fail("Wrong Argument Pattern was not part of this test");
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
            fail("Unknown Reference was not part of this test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        assertAll("Product Data",
                () -> assertEquals("Allg. Daten", myModel.getProductDataByID("/LD001/").getContent()),
                () -> assertEquals("/LD002/", myModel.getProductDataByID("/LD002/").getID()),
                () -> assertEquals("Data1", myModel.getProductDataByID("/LD001/").getAttribute()),
                () -> assertEquals("42", myModel.getProductDataByID("/LD002/").getMaxCount()),
                () -> assertEquals("/LD001/", myModel.getProductDataByID("/LD002/").getReferenceIDs().get(0)));

    }

    @Test
    void addFReqReferenceToProdData()
    {
        addProdData();
        ArrayList<String> references = new ArrayList<String>();
        references.add("/LD001/");
        try
        {
            myModel.addFReq("/LF001/", "Öffnen", "Chef", "Chef öffnet Programm", references);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
            fail("ListOverFlow was not part of this test");
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
            fail("Wrong Argument Pattern was not part of this test");
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
            fail("Unknown Reference was not part of this test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        assertAll("Functional Requirements",
            () -> assertEquals("/LF001/", myModel.getFReqByID("/LF001/").getID()),
            () -> assertEquals("Öffnen", myModel.getFReqByID("/LF001/").getTitle()),
            () -> assertEquals("Chef", myModel.getFReqByID("/LF001/").getActor()),
            () -> assertEquals("Chef öffnet Programm", myModel.getFReqByID("/LF001/").getDescription()),
            () -> assertEquals("/LD001/", myModel.getFReqByID("/LF001/").getReferenceIDs().get(0)));
    }

    @Test
    void editFReqNewID()
    {
        addFReq();
        ArrayList<String> references = new ArrayList<String>();
        try
        {
            myModel.editFReq("/LF001/", "/LF010/","Öffnen", "Chef",
                    "Chef öffnet Programm", references );
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
            fail("Unknown ID was not part of this test");
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
            fail("Unknown Reference was not part of this test");
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
            fail("Wrong Argument Pattern was not part of this test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        assertAll("Functional Requirements",
                () -> assertEquals("/LF010/", myModel.getFReqByID("/LF010/").getID()),
                () -> assertEquals("Öffnen", myModel.getFReqByID("/LF010/").getTitle()),
                () -> assertEquals("Chef", myModel.getFReqByID("/LF010/").getActor()),
                () -> assertEquals("Chef öffnet Programm", myModel.getFReqByID("/LF010/").getDescription()),
                () -> assertEquals(new ArrayList<>(), myModel.getFReqByID("/LF010/").getReferenceIDs()));
    }

    @Test
    void editFReqSameID()
    {
        addFReq();
        ArrayList<String> references = new ArrayList<String>();
        try
        {
            myModel.editFReq("/LF001/", "/LF001/","Öffnen", "Cheffe",
                    "Chef öffnet Programm", references );
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
            fail("Unknown ID was not part of this test");
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
            fail("Unknown Reference was not part of this test");
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
            fail("Wrong Argument Pattern was not part of this test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        assertAll("Functional Requirements",
                () -> assertEquals("/LF001/", myModel.getFReqByID("/LF001/").getID()),
                () -> assertEquals("Öffnen", myModel.getFReqByID("/LF001/").getTitle()),
                () -> assertEquals("Cheffe", myModel.getFReqByID("/LF001/").getActor()),
                () -> assertEquals("Chef öffnet Programm", myModel.getFReqByID("/LF001/").getDescription()),
                () -> assertEquals(new ArrayList<>(), myModel.getFReqByID("/LF001/").getReferenceIDs()));
    }

    @Test
    void editFReqNotMatchingID()
    {
        boolean notMatching = false;
        addFReq();
        try
        {
            myModel.editFReq("/LF123/", "/LF123/", "Titel", "Akteur", "Berschreibung",
                    new ArrayList<String>());
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
            notMatching = true;
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
            fail("Unknown Reference was not part of this test");
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
            fail("Wrong Argument Pattern was not part of this test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        assertTrue(notMatching);
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
            fail("MissingReq was not part of the test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
        }
        assertEquals(null, myModel.getFReqByID("/LF001/"));
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
            fail("MissingReq was not part of the test");
        }
        catch (ArgumentPatternException e)
        {
            e.printStackTrace();
            fail("Wrong Argument Pattern was not part of this test");
        }
        assertAll("Functional Requirements",
                () -> assertEquals("HansWurst AG", myModel.getCustomerData().getCompanyName()),
                () -> assertEquals("Stuttgart", myModel.getCustomerData().getCompanyCity()),
                () -> assertEquals("", myModel.getCustomerData().getCompanyStreet()),
                () -> assertEquals("70546", myModel.getCustomerData().getCompanyPLZ()),
                () -> assertEquals("D", myModel.getCustomerData().getCompanyCountry()),
                () -> assertEquals("Hans", myModel.getCustomerData().getCName()),
                () -> assertEquals("hans@hanswurst.de", myModel.getCustomerData().getCEMail()),
                () -> assertEquals("0711 123456", myModel.getCustomerData().getCNumber()),
                () -> assertEquals("Wurst", myModel.getCustomerData().getPMName()),
                () -> assertEquals("wurst@hanswurst.de", myModel.getCustomerData().getPMEMail()),
                () -> assertEquals("0711 654321", myModel.getCustomerData().getPMPNumber()));
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
            fail("MissingReq was not part of the test");
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
            fail("ListOverFlow was not part of this test");
        }
        assertEquals("Das ist die Zieldefinition!", myModel.getTargetDef().getDescription());
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
            fail("MissingReq was not part of the test");
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
            fail("ListOverFlow was not part of this test");
        }
        assertEquals("Das ist die Produktumgebung!", myModel.getProdEnv().getDescription());
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
            fail("MissingReq was not part of the test");
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
            fail("ListOverFlow was not part of this test");
        }
        assertEquals("Das ist die Produkt Applikation", myModel.getProdApp().getDescription());
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
            fail("MissingReq was not part of the test");
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
            fail("ListOverFlow was not part of this test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        assertAll("Quality Requirements",
                () -> assertEquals("Schnell", myModel.getQualReqByCriteria("Schnell").getCriteria()),
                () -> assertEquals(Score.VERYIMPORTANT, myModel.getQualReqByCriteria("Robust").getValue()));
    }

    @Test
    void editQualReq()
    {
        addQualReq();
        try
        {
            myModel.editQualReq("Schnell", "Geschwndgk.", Score.IMPORTANT);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
            fail("Unknown ID was not part of this test");
        }
        assertAll("Quality Requirements",
                () -> assertEquals("Geschwndgk.", myModel.getQualReqByCriteria("Geschwndgk.").getCriteria()),
                () -> assertEquals(Score.IMPORTANT, myModel.getQualReqByCriteria("Geschwndgk.").getValue()));
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
            fail("MissingReq was not part of the test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
            fail("Unknown ID was not part of this test");
        }
        assertEquals(null, myModel.getQualReqByCriteria("Schnell"));
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
            fail("MissingReq was not part of the test");
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
            fail("ListOverFlow was not part of this test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        assertAll("Additions",
                () -> assertEquals("Ergänzung1", myModel.getAdditionByTitle("Ergänzung1").getTitle()),
                () -> assertEquals("Es handelt sich hierbei um Ergänzung 2",
                        myModel.getAdditionByTitle("Ergänzung2").getDescription()));
    }

    @Test
    void addToManyAdditions()
    {
        boolean toMany = false;
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
            fail("MissingReq was not part of the test");
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
            toMany = true;
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        assertTrue(toMany);
    }

    @Test
    void editAddition()
    {
        addAddition();
        try
        {
            myModel.editAddition("Ergänzung1", "Ergänzung 1", "Halo i bims, 1 Ergämzumg");
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
            fail("Unknown ID was not part of this test");
        }
        assertAll("Additions",
                () -> assertEquals("Ergänzung 1", myModel.getAdditionByTitle("Ergänzung 1").getTitle()),
                () -> assertEquals("Halo i bims, 1 Ergämzumg",
                        myModel.getAdditionByTitle("Ergänzung 1").getDescription()));
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
            fail("MissingReq was not part of the test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
            fail("Unknown ID was not part of this test");
        }
        assertEquals(null, myModel.getAdditionByTitle("Ergänzung1"));
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
            fail("MissingReq was not part of the test");
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
            fail("ListOverFlow was not part of this test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
            fail("Unknown Reference was not part of this test");
        }
        assertAll("Glossary",
                () -> assertEquals("Alles was kein Glossar ist.",
                        myModel.getGlossaryEntryByTerm("Glossar").getBoundary()),
                () -> assertEquals("Gibt's auch nicht2",
                        myModel.getGlossaryEntryByTerm("Glossar2").getLabel()),
                () -> assertEquals("Gibt's nicht.",
                        myModel.getGlossaryEntryByTerm("Glossar").getObscurities()),
                () -> assertEquals("Ist ein Glossar2.",
                        myModel.getGlossaryEntryByTerm("Glossar2").getSense()),
                () -> assertEquals("Glossar",
                        myModel.getGlossaryEntryByTerm("Glossar").getTerm()),
                () -> assertEquals("In dem Projekt2",
                        myModel.getGlossaryEntryByTerm("Glossar2").getValidity()),
                () -> assertEquals(new ArrayList<String>(),
                        myModel.getGlossaryEntryByTerm("Glossar").getReferenceTerms()));
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
            fail("MissingReq was not part of the test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
            fail("Unknown ID was not part of this test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        catch (UnknownReferenceException e)
        {
            e.printStackTrace();
            fail("Unknown Reference was not part of this test");
        }
        assertAll("Glossary",
                () -> assertEquals("", myModel.getGlossaryEntryByTerm("").getBoundary()),
                () -> assertEquals("", myModel.getGlossaryEntryByTerm("").getLabel()),
                () -> assertEquals("", myModel.getGlossaryEntryByTerm("").getObscurities()),
                () -> assertEquals("", myModel.getGlossaryEntryByTerm("").getSense()),
                () -> assertEquals("", myModel.getGlossaryEntryByTerm("").getTerm()),
                () -> assertEquals("", myModel.getGlossaryEntryByTerm("").getValidity()),
                () -> assertEquals(new ArrayList<String>(), myModel.getGlossaryEntryByTerm("").getReferenceTerms()));
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
            fail("MissingReq was not part of the test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
            fail("Unknown ID was not part of this test");
        }
        assertEquals(null, myModel.getGlossaryEntryByTerm("Glossar2"));
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
            fail("MissingReq was not part of the test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        assertFalse(null == myModel.getCostEstimation());
    }

    @Test
    void addSecondCostEstimation()
    {
        boolean secondEst = false;
        addCostEstimation();
        try
        {
            myModel.addCostEstimation();
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            secondEst = true;
        }
        assertTrue(secondEst);
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
            fail("MissingReq was not part of the test");
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
            fail("Missing Cost Estimation was not part of the test");
        }
        assertTrue(null == myModel.getCostEstimation());
    }

    @Test
    void isReferenceOnID()
    {
        addFReq();
        assertTrue(myModel.isReferenceOnID("/LF001/"));
        assertFalse(myModel.isReferenceOnID("/LF003/"));
    }

    @Test
    void isIDUnique()
    {
        addFReq();
        assertFalse(myModel.isIDUnique("/LF001/"));
        assertTrue(myModel.isIDUnique("/LF010/"));
    }

    @Test
    void existsActualState()
    {
        makeNewReqAnPass();
        assertFalse(myModel.existsActualState());
    }

    @Test
    void existsFPCount()
    {
        addCostEstimation();
        assertFalse(myModel.existsFPCount());
    }

    @Test
    void existsManMonthCount()
    {
        addCostEstimation();
        assertFalse(myModel.existsManMonthCount());
    }

    @Test
    void setDataFP()
    {
        addCostEstimation();
        try
        {
            myModel.setDataFP(ClassOfDataFP.EIF_EXTERNAL_INPUT_FILE, "/LD001/", 2, 3);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
            fail("Unknown ID was not part of this test");
        }
        catch (NumberOutOfBoundsException e)
        {
            e.printStackTrace();
            fail("NumberOutOfBounds was not part of this test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
            fail("Missing Cost Estimation was not part of the test");
        }
        assertAll("Data Function Point",
                () -> assertEquals(ClassOfDataFP.EIF_EXTERNAL_INPUT_FILE,
                        myModel.getCostEstimation().getDataFPByID("/LD001/").getType()),
                () -> assertEquals("/LD001/",
                        myModel.getCostEstimation().getDataFPByID("/LD001/").getRequirement().getID()),
                () -> assertEquals(2, myModel.getCostEstimation().getDataFPByID("/LD001/").getDet()),
                () -> assertEquals(3, myModel.getCostEstimation().getDataFPByID("/LD001/").getRet()));
    }

    @Test
    void setTransactionFP()
    {
        setDataFP();
        try
        {
            myModel.setTransactionFP(ClassOfTransactionFP.EI_INPUT, "/LF001/", 5,3);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
            fail("Unknown ID was not part of this test");
        }
        catch (NumberOutOfBoundsException e)
        {
            e.printStackTrace();
            fail("NumberOutOfBounds was not part of this test");
        }
        catch (DuplicateIDException e)
        {
            e.printStackTrace();
            fail("Duplicate ID was not part of this test");
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
            fail("Missing Cost Estimation was not part of the test");
        }
        assertAll("Data Function Point",
                () -> assertEquals(ClassOfTransactionFP.EI_INPUT,
                        myModel.getCostEstimation().getTransactionFPByID("/LF001/").getType()),
                () -> assertEquals("/LF001/",
                        myModel.getCostEstimation().getTransactionFPByID("/LF001/").getRequirement().getID()),
                () -> assertEquals(5, myModel.getCostEstimation().getTransactionFPByID("/LF001/").getDet()),
                () -> assertEquals(3, myModel.getCostEstimation().getTransactionFPByID("/LF001/").getFtr()));
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
            fail("MissingReq was not part of the test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
            fail("Unknown ID was not part of this test");
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
            fail("Missing Cost Estimation was not part of the test");
        }
        catch (NumberOutOfBoundsException e)
        {
            e.printStackTrace();
            fail("NumberOutOfBounds was not part of this test");
        }
        assertAll("Data Function Point",
                () -> assertEquals(ClassOfDataFP.ILF_INTERNAL_LOGICAL_FILE,
                        myModel.getCostEstimation().getDataFPByID("/LD001/").getType()),
                () -> assertEquals("/LD001/",
                        myModel.getCostEstimation().getDataFPByID("/LD001/").getRequirement().getID()),
                () -> assertEquals(2, myModel.getCostEstimation().getDataFPByID("/LD001/").getDet()),
                () -> assertEquals(3, myModel.getCostEstimation().getDataFPByID("/LD001/").getRet()));
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
            fail("MissingReq was not part of the test");
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
            fail("Missing Cost Estimation was not part of the test");
        }
        catch (UnknownIDException e)
        {
            e.printStackTrace();
            fail("Unknown ID was not part of this test");
        }
        assertEquals(null, myModel.getCostEstimation().getTransactionFPByID("/LF001/"));
    }

    @Test
    void rateWeightFactor()
    {
        setTransactionFP();
        ArrayList<IWeightFactor> myFactors = myModel.getAllWeightFactor();
        HashMap<String, Integer> ratedFactors = new HashMap<String, Integer>();
        Random rn = new Random();
        String titleToTest = null;
        int valueToTest = 0;
        for (IWeightFactor myFactor : myFactors)
        {
            titleToTest = myFactor.getTitle();
            valueToTest = valueToTest + 1 % 11; // for test: expects that maxValue is 10
                                                // (Configuration is defaultly set to 10)
            ratedFactors.put(titleToTest, valueToTest);
        }
        try
        {
            myModel.rateWeightFactor(ratedFactors);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (NumberOutOfBoundsException e)
        {
            e.printStackTrace();
            fail("NumberOutOfBounds was not part of this test");
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
            fail("Missing Cost Estimation was not part of the test");
        }
        catch (ListOverflowException e)
        {
            e.printStackTrace();
            fail("ListOverFlow was not part of this test");
        }
        assertTrue(titleToTest.equals(myModel.getCostEstimation().getWeightFactorByTitle(titleToTest).getTitle()));
        assertTrue(valueToTest == myModel.getCostEstimation().getWeightFactorByTitle(titleToTest).getValue());
    }

    @Test
    void calcFPCount()
    {
        rateWeightFactor(); // Otherwise the factors would be zero from Config
        try
        {
            myModel.calcFPCount();
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
            fail("Missing Cost Estimation was not part of the test");
        }
        assertTrue((myModel.getCostEstimation().getFunctionPoints() > 6.99) &&
                (myModel.getCostEstimation().getFunctionPoints() < 7.01));
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
            fail("MissingReq was not part of the test");
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
            fail("Missing Cost Estimation was not part of the test");
        }
        assertTrue((myModel.getCostEstimation().getManMonth() > 2.17) &&
            (myModel.getCostEstimation().getManMonth() < 2.19));
    }

    @Test
    void setActualState()
    {
        calcManMonth();
        try
        {
            myModel.setActualState(2.0);
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (NumberOutOfBoundsException e)
        {
            e.printStackTrace();
            fail("NumberOutOfBounds was not part of this test");
        }
        assertTrue(2.0 == myModel.getReqAnalysis().getActualState());
    }

    @Test
    void existsOptWeightFactor()
    {
        adjustWeightFactor();
        assertTrue(myModel.existsOptWeightFactor());
    }

    @Test
    void adjustWeightFactor()
    {
        setActualState(); // set to 2.0
        try
        {
            myModel.adjustWeightFactor();
        }
        catch (MissingReqAnException e)
        {
            e.printStackTrace();
            fail("MissingReq was not part of the test");
        }
        catch (MissingCostEstimationException e)
        {
            e.printStackTrace();
            fail("Missing Cost Estimation was not part of the test");
        }
        catch (MissingFPException e)
        {
            e.printStackTrace();
            fail("Missing Function Points was not part of this test");
        }
        catch (NumberOutOfBoundsException e)
        {
            e.printStackTrace();
            fail("NumberOutOfBounds was not part of this test");
        }
        // Due To the minimal change of the weight factors, the optimal will have the same value than the original ones.
        // Therefore, it only tests for the same value.
        boolean sameValues = true;
        for (IWeightFactor fac : myModel.getAllWeightFactor())
        {
            if (fac.getValue() != myModel.getOptWeightFactorByTitle(fac.getTitle()).getValue())
            {
                sameValues = false;
            }
        }
        assertTrue(sameValues);
    }

    @Test
    void existsID()
    {
        putInRandomData();
        assertTrue(myModel.existsID("/LF001/"));
        assertFalse(myModel.existsID("/LF00/"));
    }

}