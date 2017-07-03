package UnitTests;

import Exceptions.*;
import Model.Model;
import Model_Interfaces.*;
import xml.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;



/**
 * Created by Philipp on 27.06.17.
 */
class XMLManagerTest
{
    IRequirementAnalysis myReqAn;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws ArgumentPatternException, ListOverflowException, UnknownReferenceException, DuplicateIDException, MissingReqAnException, UnknownIDException, MissingCostEstimationException, NumberOutOfBoundsException {
        Model myModel = new Model();
        myModel.makeNewReqAn("Titel", "Karl", "karl@gmail.com", "07833 15054",
                "Karles","Stuttgart", "Karlsstrasse", "Germany", "70546",
                "Otto", "otto@gmx.de", "0711 151484");

        ArrayList<String> references = new ArrayList<String>();

        myModel.addFReq("/LF001/", "Öffnen", "Chef", "Chef öffnet Programm", references);
        references.add("/LF001/");
        myModel.addFReq("/LF002/", "Arbeiten", "Chef", "Chef arbeitet damit", references);
        references.add("/LF002/");
        myModel.addFReq("/LF003/", "Schließen", "Chef", "Chef schließt Programm", references);

        myModel.addNFReq("/LE001/", "Robust", "Chef", "robustes Programm", references);
        references.add("/LE001/");
        myModel.addNFReq("/LE002/", "Schnell", "Chef", "schnelles Programm", references);

        myModel.addProdData("/LD001/", "Allg. Daten", "Data1", "12", references);
        references.add("/LD001/");
        myModel.addProdData("/LD002/", "spez. Daten", "Data2", "42", references);

        myModel.editTargetDef("Das ist die Zieldefinition!");

        myModel.editProdEnv("Das ist die Produktumgebung!");

        myModel.editProdApp("Das ist die Produkt Applikation");

        myModel.addQualReq("Schnell", Score.VERYIMPORTANT);
        myModel.addQualReq("Robust", Score.VERYIMPORTANT);
        myModel.addQualReq("Benutzerfreundlich", Score.VERYIMPORTANT);

        myModel.addAddition("Ergänzung1", "Es handelt sich hierbei um Ergänzung 1");
        myModel.addAddition("Ergänzung2", "Es handelt sich hierbei um Ergänzung 2");
        myModel.addAddition("Ergänzung3", "Es handelt sich hierbei um Ergänzung 3");

        ArrayList<String> crossReference = new ArrayList<String>();

        myModel.addGlossEntry("Glossar", "Ist ein Glossar.", "Alles was kein Glossar ist.",
                "In diesem Projekt.", "Gibt's nicht.", "Gibt's auch nicht", crossReference);
        myModel.addGlossEntry("Glossar2", "Ist ein Glossar2.", "Alles was kein Glossar2 ist.",
                "In dem Projekt2", "Gibt's nicht2", "Gibt's auch nicht2", crossReference);

        myModel.addCostEstimation();

        myModel.setDataFP(ClassOfDataFP.EIF_EXTERNAL_INPUT_FILE, "/LD001/", 2, 3);

        myModel.setTransactionFP(ClassOfTransactionFP.EI_INPUT, "/LF001/", 5,3);

        myModel.setActualState(2.0);

        myReqAn = myModel.getReqAnalysis();
    }

    @org.junit.jupiter.api.Test
    void exportAnalysis() {
        IXMLManager manager = IXMLManager.getInstance();
        try {
            manager.exportAnalysis(myReqAn, "myXML.xml", XMLFormatType.CUSTOM_XML_FORMAT);
        } catch (XMLMarschallingException e) {
            fail("Marschal");
        } catch (FileNotFoundException e) {
            fail("File Not Found");
        } catch (XMLFormatException e) {
            fail("XML Format");
        } catch (SingletonRecreationException e) {
            fail("Singleton Recreation");
        } catch (XMLProcessingException e) {
            fail("JAXB");
        }

        assert(true);
    }

    @org.junit.jupiter.api.Test
    void importAnalysis()
    {
        IRequirementAnalysis iReqAn = null;

        IXMLManager manager = IXMLManager.getInstance();
        try {
            iReqAn = manager.importAnalysis("myXML.xml", XMLFormatType.CUSTOM_XML_FORMAT);
        } catch (FileNotFoundException e) {
            fail("File not found");
        } catch (XMLUnmarschallException e) {
            fail("Unmarshal");
        } catch (XMLProcessingException e) {
            fail("JAXB");
        } catch (XMLFormatException e) {
            fail("XML Format");
        } catch (SingletonRecreationException e) {
            fail("Singleton Recreation");
        }

        assertEquals(iReqAn.getTitle(), myReqAn.getTitle());
        assertEquals(iReqAn.getFRequirements().size(), myReqAn.getFRequirements().size());
        assertEquals(iReqAn.getFRequirements().get(0).getReferenceIDs().size(),
                myReqAn.getFRequirements().get(0).getReferenceIDs().size());
        assertEquals(iReqAn.getNFRequirements().get(0).getActor(), iReqAn.getNFRequirements().get(0).getActor());
        assertEquals(iReqAn.getCustomerData().getCompanyStreet(), myReqAn.getCustomerData().getCompanyStreet());
        assertEquals(iReqAn.getProductEnvironment().getDescription(), myReqAn.getProductEnvironment().getDescription());
        assertEquals(iReqAn.getProductData().get(0).getID(), myReqAn.getProductData().get(0).getID());
    }

}