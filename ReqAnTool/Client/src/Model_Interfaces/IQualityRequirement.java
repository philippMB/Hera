package Model_Interfaces;

import Model.Score;

/**
 * Created by phlippe on 26.04.17.
 */
public interface IQualityRequirement 
{
    
    public String getCriteria();

    /**
     * @return
     */
    public Score getValue();

}