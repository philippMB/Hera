package Model;

import Model_Interfaces.IAddition;
import Model_Interfaces.IAdditionList;

import java.util.ArrayList;

/**
 * Created by mbill on 04.05.2017.
 */
public class AdditionList<IAdd extends IAddition>
        extends ArrayList<IAdd>
        implements IAdditionList<IAdd>
{

    @Override
    public boolean isIncluded(String term)
    {
        for (IAdd myAdd : this)
        {
            if (myAdd.getTitle().equals(term))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public IAdd getAdditionByTitle(String term)
    {
        for (IAdd myAdd : this)
        {
            if (myAdd.getTitle().equals(term))
            {
                return myAdd;
            }
        }
        return null;
    }

    @Override
    public boolean removeByTitle(String title)
    {
        for (IAdd myAdd : this)
        {
            if (myAdd.getTitle().equals(title))
            {
                return super.remove(myAdd);
            }
        }
        return false;
    }
}
