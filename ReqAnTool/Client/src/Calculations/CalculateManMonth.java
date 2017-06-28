package Calculations;

/**
 * Created by mbill on 28.06.2017.
 */
public class CalculateManMonth
{

    public double jonesEstimation(double fpCount)
    {
        double developmentTime = Math.pow(fpCount, 0.4);
        double personCount = Math.ceil(fpCount / 150);
        double manMonthCount = developmentTime * personCount;
        return manMonthCount;
    }
}
