package Model;

import Model_Interfaces.ErrorCodes;
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

    public ErrorCodes setValue(double value)
    {
        ErrorCodes retValue = ErrorCodes.INVALID_ARGUMENT;
        if (value >= 0 && value <= maxValue)
        {
            this.score = value;
            retValue = ErrorCodes.NO_ERROR;
        }
        return retValue;

    }
}
