package Calculations;

import Calculations_Interfaces.IMMCalculator;
import Exceptions.MissingParameter;
import Exceptions.MissingParameterException;
import Model_Interfaces.ICostEstimation;

/**
 * Created by mbill on 28.06.2017.
 */
public class JonesMMCalculator
    implements IMMCalculator
{

    @Override
    public double calcMM(ICostEstimation costEstimation) throws MissingParameterException
    {
        if(costEstimation.getFunctionPoints() <= 0)
        {
            throw new MissingParameterException(MissingParameter.FUNCTION_POINTS);
        }
        return calcJonesEstimation(costEstimation.getFunctionPoints());
    }

    public double calcJonesEstimation(double fpCount)
    {
        double developmentTime = Math.pow(fpCount, 0.4);
        double personCount = Math.ceil(fpCount / 150);
        double manMonthCount = developmentTime * personCount;
        return manMonthCount;
    }
}
