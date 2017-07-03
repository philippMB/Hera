package Model;

import Model_Interfaces.IWeightFactor;

import java.util.ArrayList;

/**
 * Created by mbill on 04.05.2017.
 */
public class WeightFactorList<IWeightFac extends IWeightFactor>
        extends ArrayList<IWeightFac>
        implements IWeightFactorList<IWeightFac>
{

    @Override
    public boolean isIncluded(String title)
    {
        boolean included = false;
        for (IWeightFac myFac : this)
        {
            if (myFac.getTitle().equals(title))
            {
                included = true;
            }
        }
        return included;
    }

    @Override
    public IWeightFac getFactorByTitle(String title)
    {
        IWeightFac facToReturn = null;
        for (IWeightFac myFac : this)
        {
            if (myFac.getTitle().equals(title))
            {
                facToReturn = myFac;
            }
        }
        return facToReturn;
    }

    @Override
    public boolean removeByTitle(String title)
    {
        IWeightFac weightFacToRemove = null;
        for (IWeightFac myFac : this)
        {
            if (myFac.getTitle().equals(title))
            {
                weightFacToRemove = myFac;
            }
        }
        return this.remove(weightFacToRemove);
    }
}
