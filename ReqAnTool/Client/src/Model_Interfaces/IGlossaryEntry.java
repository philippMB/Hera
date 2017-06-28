package Model_Interfaces;

import java.util.ArrayList;

/**
 * Created by phlippe on 26.04.17.
 */
public interface IGlossaryEntry 
{
    
    String getTerm();

    String getSense();
    
    String getBoundary();
    
    String getLabel();
    
    String getValidity();
    
    String getObscurities();
    
    ArrayList<IGlossaryEntry> getReferences();
    
    ArrayList<String> getReferenceTerms();
    
}