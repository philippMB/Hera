<<<<<<< HEAD
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
=======
package Model_Interfaces;

import java.util.ArrayList;

/**
 * Created by phlippe on 26.04.17.
 */
public interface IGlossaryEntry 
{
    
    public String getTerm();

    public String getSense();
    
    public String getBoundary();
    
    public String getLabel();
    
    public String getValidity();
    
    public String getObscurities();
    
    public ArrayList<IGlossaryEntry> getReferences();
    
    public String[] getReferenceTerms();
    
}
>>>>>>> 9cdce7ea87eff28f9af5bcaf7ae45e8b6b35d527
