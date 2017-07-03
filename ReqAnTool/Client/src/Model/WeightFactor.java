package Model;

import Exceptions.NumberOutOfBoundsException;
import Model_Interfaces.IWeightFactor;

public class WeightFactor
    implements IWeightFactor
{
    private double score;
    private int maxValue;
    private String title;

    public WeightFactor(String title, int score, int maxValue)
    {
        this.title = title;
        this.maxValue = maxValue;
        this.score = score;
    }

    @Override
    public String getTitle()
    {
        return title;

    }

    @Override
    public int getValue()
    {
        return (int) Math.round(score);
    }


    public double getExactValue()
    {
        return score;

    }

    @Override
    public int getMaxValue()
    {
        return maxValue;

    }

    public void setValue(double value) throws NumberOutOfBoundsException
    {
        if (!(value >= 0 && value <= maxValue))
        {
            throw new NumberOutOfBoundsException(value, 0, maxValue);
        }
        this.score = value;

    }
}
