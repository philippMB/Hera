package Model;

import Model_Interfaces.IWeightFactor;

import java.util.ArrayList;
import java.util.List;

public class Configuration
{
    private static ComplexityMatrix myComplexityMatrix;
    private static ComplexityWeightMatrix myComplexityWeightMatrix;

    /**
     * @associates <{Model.WeightFactor}>
     */
    private ArrayList<IWeightFactor> optWeightFactor;

    private void getComplexityMatrix()
    {
    }

    private void getComplexityWeightMatrix()
    {
    }

    public ArrayList<IWeightFactor> getOptWeightFactors()
    {
        return optWeightFactor;
    }
    
    public IWeightFactor getOptWeightFactorsByTitle(String title)
    {
        // TODO
        return null;
    }

    public void adjustOptWeightFactors()
    {
    }
}
