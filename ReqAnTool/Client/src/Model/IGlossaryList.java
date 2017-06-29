package Model;

import Model_Interfaces.IGlossaryEntry;

import java.util.ArrayList;

public interface IGlossaryList<IGloss extends IGlossaryEntry>
{

    public boolean isIncluded(String term);
    
    public IGloss getEntryByTerm(String term);
    
    public boolean removeEntryByTerm(String term);
    
}
