package Model;

import Model_Interfaces.IGlossaryList;
import Model_Interfaces.IGlossaryEntry;

import java.util.ArrayList;

public class GlossaryList<IGloss extends IGlossaryEntry>
    extends ArrayList<IGloss>
    implements IGlossaryList<IGloss>
{

    @Override
    public IGloss getEntryByTerm(String term)
    {
        for (IGloss myEntry : this)
        {
            if (myEntry.getTerm().equals(term))
            {
                return myEntry;
            }
        }
        return null;
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
        for (IGloss myEntry : this)
        {
            if (myEntry.getTerm().equals(term))
            {
                return super.remove(myEntry);
            }
        }
        return false;
    }


}
