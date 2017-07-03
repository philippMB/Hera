package Model;

import Model_Interfaces.IRequirement;

/**
 * The RequirementList is made for easy handling with more than one Requirement.
 * It extends the class ArrayList for the method isIncluded(String), getReqByTitle(title) and removeReqByTitle(title).
 * Therefore it allows to search for Strings in a List of Requirements.
 *
 * @param <T> IRequirement (or extended classes) defines the List as a List from the type Requirement.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IRequirement
 */
interface IRequirementList<T extends IRequirement>
{

    //TODO

    /**
     *
     * @param id
     * @return
     */
    boolean isIncluded(String id);

    //TODO

    /**
     *
     * @param id
     * @return
     */
    T getReqByID(String id);

    //TODO

    /**
     *
     * @param id
     * @return
     */
    boolean removeReqByID(String id);
    
}
