package Model;

import Model_Interfaces.IWeightFactor;

import java.util.ArrayList;
import java.util.List;

public class Configuration
{
    private final ComplexityMatrix myComplexityMatrix;
    private final ComplexityWeightMatrix myComplexityWeightMatrix;
    /**
     * @associates <{Model.WeightFactor}>
     */
    private ArrayList<IWeightFactor> optWeightFactor;
    
    public Configuration()
    {
        myComplexityMatrix = readComplexityMatrixFromInit();
        myComplexityWeightMatrix = readComWeightMatrixFromInit();
        optWeightFactor = readOptWeightFactorFromInit();
    }

    private ArrayList<IWeightFactor> readOptWeightFactorFromInit()
    {
        // TODO
        return null;
    }

    private ComplexityWeightMatrix readComWeightMatrixFromInit()
    {
        return null;
    }

    private ComplexityMatrix readComplexityMatrixFromInit()
    {
        return null;
    }

    public ComplexityMatrix getComplexityMatrix()
    {
        return myComplexityMatrix;
    }

    public ComplexityWeightMatrix getComplexityWeightMatrix()
    {
        return myComplexityWeightMatrix;
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
