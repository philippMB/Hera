package Model;

import Model_Interfaces.IWeightFactor;

/**
 * Created by mbill on 04.05.2017.
 */
interface IWeightFactorList<IWeightFac extends IWeightFactor>
{

    boolean isIncluded(String title);

    IWeightFac getFactorByTitle(String title);

    boolean removeByTitle(String title);

}
