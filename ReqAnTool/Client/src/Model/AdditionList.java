package Model;

import Model_Interfaces.IAddition;
import Model_Interfaces.IAdditionList;

import java.util.ArrayList;

/**
 * Created by mbill on 04.05.2017.
 */
public class AdditionList<IAddition>
        extends ArrayList<IAddition>
        implements IAdditionList<IAddition>
{
    @Override
    public boolean isIncluded(String term)
    {
        return false;
    }

    @Override
    public Addition getAdditionByTerm(String term)
    {
        return null;
    }

    @Override
    public ArrayList<IAddition> toArrayList()
    {
        return null;
    }
}
