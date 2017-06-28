package Model;

import Model_Interfaces.IGlossaryEntry;

interface IGlossaryList<IGloss extends IGlossaryEntry>
{

    boolean isIncluded(String term);
    
    IGloss getEntryByTerm(String term);
    
    boolean removeEntryByTerm(String term);
    
}
