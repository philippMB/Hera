package Model_Interfaces;

import Model.Addition;

import java.util.ArrayList;

/**
 * Created by mbill on 04.05.2017.
 */
public interface IAdditionList<IAdd extends IAddition>
{

    public boolean isIncluded(String term);

    public IAdd getAdditionByTitle(String title);

    public boolean removeByTitle(String title);

}
