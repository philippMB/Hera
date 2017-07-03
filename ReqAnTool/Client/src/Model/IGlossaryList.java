package Model;

import Model_Interfaces.IGlossaryEntry;
/**
 * The GlossaryList is made for easy handling with more than one GlossaryEntry.
 * It extends the class ArrayList for the method isIncluded(String), getEntryByTerm(term) and removeEntryByTerm(term).
 * Therefore it allows to search for Strings (terms) in a List of GlossaryEntries.
 *
 * @param <IGloss> IGlossaryEntry (or extended classes) defines the List as a List from the type IGlossaryEntry.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IGlossaryEntry
 */
interface IGlossaryList<IGloss extends IGlossaryEntry>
{

    //TODO

    /**
     *
     * @param term
     * @return
     */
    boolean isIncluded(String term);
     //TODO

    /**
     *
     * @param term
     * @return
     */
    IGloss getEntryByTerm(String term);

    //TODO

    /**
     *
     * @param term
     * @return
     */
    boolean removeEntryByTerm(String term);
    
}
