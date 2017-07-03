package Calculations;

import Model.*;
import Model_Interfaces.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mbill on 28.06.2017.
 */
public class CalculateFP
{

    public double ibmMethod(ICostEstimation myCostEstimation)
    {
        double fpCount;

        int unweightedFPcount = getSumOfDataAndTransactionFPs(myCostEstimation);
        double factorOfInfluences = sumOfWeightFactors(myCostEstimation);
        fpCount = unweightedFPcount * factorOfInfluences;

        return fpCount;
    }

    public double sumOfWeightFactors(ICostEstimation myCostEstimation)
    {
        int sumOfFactors = 0;
        for (IWeightFactor myIWeightFactor : myCostEstimation.getWeightFactors())
        {
            WeightFactor myWeightFactor = (WeightFactor) myIWeightFactor;
            sumOfFactors += myWeightFactor.getExactValue();
        }
        return (sumOfFactors / 100 + 0.7);
    }

    public int getSumOfDataAndTransactionFPs(ICostEstimation myCostEstimation)
    {
        Map<IClassOfFP, ComplexityMatrix> myComplexityMatrices = myCostEstimation.getComplexityMatrices();
        ComplexityWeightMatrix myComplexityWeightMatrix = myCostEstimation.getComplexityWeightMatrix();
        int sumOfWeightedComplexities = 0;
        for (ITransactionFP myITransactionFP : myCostEstimation.getTransactionFPs())
        {
            TransactionFP myTransactionFP = (TransactionFP)myITransactionFP;
            int myFPvalue = myTransactionFP.getFPvalue(myComplexityMatrices.get(myITransactionFP.getType()),
                    myComplexityWeightMatrix);
            if (myFPvalue != -1) // check for error from getFPvalue (error = -1)
            {
                sumOfWeightedComplexities += myFPvalue;
            }
        }
        for (IDataFP myIDataFP : myCostEstimation.getDataFPs())
        {
            DataFP myDataFP = (DataFP)myIDataFP;
            int myFPvalue = myDataFP.getFPvalue(myComplexityMatrices.get(myIDataFP.getType()),
                    myComplexityWeightMatrix);
            if (myFPvalue != -1) // check for error from getFPvalue (error = -1)
            {
                sumOfWeightedComplexities += myFPvalue;
            }
        }
        return sumOfWeightedComplexities;

    }
}
