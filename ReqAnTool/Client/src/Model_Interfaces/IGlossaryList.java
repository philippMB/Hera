package Model_Interfaces;

import java.util.ArrayList;

public interface IGlossaryList<IGlossaryEntry>
{
    
    public boolean add(IGlossaryEntry myEntry);
    
    public boolean isIncluded(String term);
    
    public IGlossaryEntry getEntryByTerm(String term);
    
    public ArrayList<IGlossaryEntry> toArrayList();
    
    public boolean remove(IGlossaryEntry myEntry);
    
}
