package Model;

import Model_Interfaces.IGlossaryEntry;

import java.util.ArrayList;

public class GlossaryEntry
    implements IGlossaryEntry
{
    private String term;
    private String sense;
    private String boundary;
    private String validity;
    private String obscurities;
    private String label;

    /**
     * @associates <{Model.GlossaryEntry}>
     */
    private ArrayList<GlossaryEntry> crossReferences;
}
