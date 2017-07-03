package Model_Interfaces;

import java.util.ArrayList;

/**
 * A GlossaryEntry for the glossary of the requirement analysis.
 * The glossary of the requirement analysis can contain multiple GlossaryEntries, every consisting of a term, sense,
 * boundary, label, validity, obscurities, a list of references and a list of reference terms.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IRequirementAnalysis
 */
public interface IGlossaryEntry
{

    /**
     * Get the term of the GlossaryEntry.
     * @return A String containing the term.
     */
    String getTerm();

    /**
     * Get the sense of the GlossaryEntry.
     * @return A String containing the sense.
     */
    String getSense();

    /**
     * Get the boundary of the GLossaryEntry.
     * @return A String containing the boundary.
     */
    String getBoundary();

    /**
     * Get the label of the GlossaryEntry.
     * @return A String containing the label.
     */
    String getLabel();

    /**
     * Get the validity of the GlossaryEntry.
     * @return A String containing the validity.
     */
    String getValidity();

    /**
     * Get the obsurities of the GlossaryEntry.
     * @return A String containing the obscurities.
     */
    String getObscurities();

    /**
     * Get the list of references of the GlossaryEntry.
     * @return An Arraylist containing the referenced GlossaryEntries.
     */
    ArrayList<IGlossaryEntry> getReferences();

    /**
     * Get the list of reference terms of the GlossaryEntry.
     * @return An Arraylist containing the reference terms as String.
     */
    ArrayList<String> getReferenceTerms();

}
