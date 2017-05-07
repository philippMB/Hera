package Model_Interfaces;

import Model.Addition;

import java.util.ArrayList;

/**
 * Created by mbill on 04.05.2017.
 */
public interface IAdditionList<IAddition>
{

    public boolean add(IAddition myAdd);

    public boolean isIncluded(String term);

    public Addition getAdditionByTitle(String term);

    public ArrayList<IAddition> toArrayList();

    public boolean remove(IAddition myAdd);

}
