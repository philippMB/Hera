package Model;

import Model_Interfaces.IWeightFactor;

/**
 * The WeightFactorList is made for easy handling with more than one WeightFactors.
 * It extends the class ArrayList for the method isIncluded(String), getFactorByTitle(title) and removeByTitle(title).
 * Therefore it allows to search for Strings in a List of WeightFactors.
 *
 * @param <IWeightFac> IWeightFactor (or extended classes) defines the List as a List from the type IWeightFactor.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IWeightFactor
 */
interface IWeightFactorList<IWeightFac extends IWeightFactor>
{

    //TODO

    /**
     *
     * @param title
     * @return
     */
    boolean isIncluded(String title);

    //TODO

    /**
     *
     * @param title
     * @return
     */
    IWeightFac getFactorByTitle(String title);

    //TODO

    /**
     * 
     * @param title
     * @return
     */
    boolean removeByTitle(String title);

}
