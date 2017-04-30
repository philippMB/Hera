package Model_Interfaces;

import java.util.ArrayList;

public interface IGlossaryEntry 
{
    
    public String getTerm();

    public String getSense();
    
    public String getBoundary();
    
    public String getLabel();
    
    public String getValidity();
    
    public String getObscurities();
    
    public ArrayList<IGlossaryEntry> getReferences();
}
