package Model;

import Model_Interfaces.IWeightFactor;

public class WeightFactor
    implements IWeightFactor
{
    private int score;
    private int maxValue;
    private String title;

    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public int getValue()
    {
        return score;
    }

    @Override
    public int getMaxValue()
    {
        return maxValue;
    }
}
