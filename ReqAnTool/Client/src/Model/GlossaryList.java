package Model;

import Model_Interfaces.IGlossaryEntry;
import Model_Interfaces.IGlossaryList;

import java.util.ArrayList;

public class GlossaryList<IGlossaryEntry>
    extends ArrayList<IGlossaryEntry>
    implements IGlossaryList
{

    @Override
    public boolean add(IGlossaryEntry myEntry)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public IGlossaryEntry getEntryByTerm(String term)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public boolean isIncluded(String term)
    {
        // TODO Implement this method
        return false;
    }



    @Override
    public ArrayList<IGlossaryEntry> toArrayList()
    {
        // TODO Implement this method
        return null;
    }

}
