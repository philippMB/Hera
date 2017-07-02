package Model;

import Model_Interfaces.IQualityRequirement;

/**
 * The QualityRequirementList is made for easy handling with more than one QualityRequirement.
 * It extends the class ArrayList for the method isIncluded(String), getQualReqByCriteria(criteria)
 * and removeQualReqByCriteria(criteria).
 * Therefore it allows to search for Strings in a List of Additions.
 *
 * @param <IQualReq> IQualityReguirement (or extended classes) defines the List as a List from the type
 *                  IQualityRequirement.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IQualityRequirement
 */
interface IQualityRequirementList<IQualReq extends IQualityRequirement>
{
    //TODO

    /**
     *
     * @param criteria
     * @return
     */
    boolean isIncluded(String criteria);

    //TODO

    /**
     *
     * @param criteria
     * @return
     */
    IQualReq getQualReqByCriteria(String criteria);
    //TODO

    /**
     *
     * @param criteria
     * @return
     */
    boolean removeQualReqByCriteria(String criteria);

}
