package Model;

import Model_Interfaces.IWeightFactor;

/**
 * Created by mbill on 04.05.2017.
 */
public interface IWeightFactorList<IWeightFac extends IWeightFactor>
{

    public boolean isIncluded(String title);

    public IWeightFac getFactorByTitle(String title);

    public boolean removeByTitle(String title);

}
