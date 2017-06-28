package Model;

import Model_Interfaces.IAddition;

/**
 * Created by mbill on 04.05.2017.
 */
interface IAdditionList<IAdd extends IAddition>
{

    boolean isIncluded(String title);

    IAdd getAdditionByTitle(String title);

    boolean removeByTitle(String title);

}
