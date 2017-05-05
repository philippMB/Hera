package Model;

import Model_Interfaces.IGlossaryList;
import Model_Interfaces.IGlossaryEntry;

import java.util.ArrayList;

public class GlossaryList<IGlossaryEntry>
    extends ArrayList<IGlossaryEntry>
    implements IGlossaryList<IGlossaryEntry>
{

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
        return this;
    }

}
