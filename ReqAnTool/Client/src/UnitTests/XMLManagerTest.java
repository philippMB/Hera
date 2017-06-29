package UnitTests;

import Model.Model;
import Model.RequirementAnalysis;

import java.util.ArrayList;

/**
 * Created by Philipp on 27.06.17.
 */
class XMLManagerTest
{
    @org.junit.jupiter.api.BeforeEach
    void setUp()
    {
        Model myModel = new Model();
        myModel.makeNewReqAn("myTitle", "Horst", "horst@gmail.com", "123908643",
                "Hansa","Stuttgart", "Palmenwaldstraße", "Germany", "73733",
                "Maier", "maier@gmx.de", "56439287");
        myModel.addAddition("New Addition", "Eine tolle Beschreibung");
        myModel.addAddition("Anther Addition", "Eine viel schönere Beschreibung");
        ArrayList<String> leer = new ArrayList<>();
        myModel.addFReq("/1/", "1 FR", "Justus", "Eine ganz tolle Beschreibung", leer);
        myModel.getReqAnalysis();
    }

    @org.junit.jupiter.api.Test
    void exportAnalysis()
    {
        assert (true);
    }

    @org.junit.jupiter.api.Test
    void importAnalysis()
    {
    }

}