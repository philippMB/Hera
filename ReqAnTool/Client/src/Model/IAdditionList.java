package Model;

import Model_Interfaces.IAddition;

/**
 * The AdditionList is made for easy handling with more than one Addition. It extends the class ArrayList for the method
 * isIncluded(String), getAdditionByTitle(title) and removeByTitle(title).
 * Therefore it allows to search for Strings in a List of Additions.
 *
 * @param <IAdd> IAddition (or extended classes) defines the List as a List from the type IAddition.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IAddition
 */
interface IAdditionList<IAdd extends IAddition>
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
    IAdd getAdditionByTitle(String title);
    //TODO

    /**
     *
     * @param title
     * @return
     */
    boolean removeByTitle(String title);

}
