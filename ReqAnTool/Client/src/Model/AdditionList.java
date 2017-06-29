package Model;

import Model_Interfaces.IAddition;

import java.util.ArrayList;

/**
 * Created by mbill on 04.05.2017.
 */
public class AdditionList<IAdd extends IAddition>
        extends ArrayList<IAdd>
        implements IAdditionList<IAdd>
{

    @Override
    public boolean isIncluded(String title)
    {
        boolean included = false;
        for (IAdd myAdd : this)
        {
            if (myAdd.getTitle().equals(title))
            {
                included = true;
            }
        }
        return included;
    }

    @Override
    public IAdd getAdditionByTitle(String title)
    {
        IAdd addToReturn = null;
        for (IAdd myAdd : this)
        {
            if (myAdd.getTitle().equals(title))
            {
                addToReturn = myAdd;
            }
        }
        return addToReturn;
    }

    @Override
    public boolean removeByTitle(String title)
    {
        boolean success = false;
        for (IAdd myAdd : this)
        {
            if (myAdd.getTitle().equals(title))
            {
                success = super.remove(myAdd);
            }
        }
        return success;
    }
}
