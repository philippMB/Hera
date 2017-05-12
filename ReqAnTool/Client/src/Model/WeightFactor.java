package Model;

import Model_Interfaces.ErrorCodes;
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

    public ErrorCodes setValue(Integer value)
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
