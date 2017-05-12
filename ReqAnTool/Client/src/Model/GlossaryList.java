package Model;

import Model_Interfaces.IGlossaryEntry;

import java.util.ArrayList;

public class GlossaryList<IGloss extends IGlossaryEntry>
    extends ArrayList<IGloss>
    implements IGlossaryList<IGloss>
{

    @Override
    public IGloss getEntryByTerm(String term)
    {
        IGloss entryToReturn = null;
        for (IGloss myEntry : this)
        {
            if (myEntry.getTerm().equals(term))
            {
                entryToReturn = myEntry;
            }
        }
        return entryToReturn;
    }

    @Override
    public boolean isIncluded(String term)
    {
        boolean included = false;
        for (IGlossaryEntry myEntry : this)
        {
            if (myEntry.getTerm().equals(term))
            {
                included = true;
            }
        }
        return included;
    }

    @Override
    public boolean removeEntryByTerm(String term)
    {
        boolean success = false;
        for (IGloss myEntry : this)
        {
            if (myEntry.getTerm().equals(term))
            {
                success = super.remove(myEntry);
            }
        }
        return success;
    }
    
}
