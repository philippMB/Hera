    package Model_Interfaces;

import java.util.ArrayList;

/**
 * Represents attributes every kind of requirement has to implement.
 * Every kind of requirement has to have an id, list of references and list of reference ids.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IFRequirement
 * @see INFRequirement
 * @see IProductData
 */

public interface IRequirement
{
    /**
     * Get the ID of the Requirement.
     * @return A String containing the id.
     */
    String getID();

    /**
     * Get the list of references of the Requirement.
     * @return An Arraylist of the references IRequirement objects.
     */
    ArrayList<IRequirement> getReferences();

    /**
     * Get the list of reference ids of the Requirement.
     * @return An Arraylist of the reference ids as String.
     */
    ArrayList<String> getReferenceIDs();

}
