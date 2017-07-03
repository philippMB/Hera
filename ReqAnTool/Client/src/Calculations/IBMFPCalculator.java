package Calculations;

import Calculations_Interfaces.IFPCalculator;
import Logging.ILogger;
import Logging.ILoggerFactory;
import Model.*;
import Model_Interfaces.*;

import java.util.Map;

/**
 * Created by mbill on 28.06.2017.
 */
public class IBMFPCalculator
    implements IFPCalculator
{

    private ILogger myLogger;
    private ComplexityCalculator myComplexityCalculator;


    public IBMFPCalculator()
    {
		ComplexityMatrixFileManager fileManager = new ComplexityMatrixFileManager();
		Map<IClassOfFP, ComplexityMatrix> myComplexityMatrices = fileManager.readComplexityMatrixFromInit();
		ComplexityWeightMatrix myComplexityWeightMatrix = fileManager.readComWeightMatrixFromInit();
		myComplexityCalculator = new ComplexityCalculator(myComplexityMatrices, myComplexityWeightMatrix);
		myLogger = ILoggerFactory.getInstance().createLogger("FPCalcLog");
    }

	@Override
	public double calcFP(ICostEstimation costEstimation)
	{
		myLogger.info("Start Function-Point calculation after IBM Standard...");
		return ibmMethod(costEstimation);
	}

    private double ibmMethod(ICostEstimation myCostEstimation)
    {
        double fpCount;

        int sumOfTFP = calcSumOfTransactionFPs(myCostEstimation);
        int sumOfDFP = calcSumOfDataFP(myCostEstimation);
        int sumOfWF = calcSumOfWeightFactors(myCostEstimation);
		myLogger.info("SumOfTFP = "+sumOfTFP+"\n"+
				"SumOfDFP = "+sumOfDFP+"\n"+
				"SumOfWF = "+sumOfWF);

        int unweightedFPcount = sumOfTFP + sumOfDFP;
        double factorOfInfluences = (sumOfWF / 100.0 + 0.7);
		myLogger.info("UnweightedFPCount = "+unweightedFPcount+"\n"+
							"Factor of incluence = "+factorOfInfluences);

        fpCount = unweightedFPcount * factorOfInfluences;
		myLogger.info("FP-Count = "+fpCount);

        return fpCount;
    }

    private int calcSumOfWeightFactors(ICostEstimation myCostEstimation)
    {
        int sumOfWF = 0;
        for (IWeightFactor myIWeightFactor : myCostEstimation.getWeightFactors())
        {
            WeightFactor myWeightFactor = (WeightFactor) myIWeightFactor;
            sumOfWF += myWeightFactor.getExactValue();
        }
        return sumOfWF;
    }

    private int calcSumOfTransactionFPs(ICostEstimation myCostEstimation)
    {
        int sumOfWeightedComplexities = 0;
        for (IDataFP dataFP : myCostEstimation.getDataFPs())
        {
            int myFPvalue = myComplexityCalculator.calcFPForDFP(dataFP);
            if (myFPvalue != -1) // check for error from getFPvalue (error = -1)
            {
                sumOfWeightedComplexities += myFPvalue;
            }
        }
        return sumOfWeightedComplexities;

    }

    private int calcSumOfDataFP(ICostEstimation costEstimation)
    {
        int sumOfWeightedComplexities = 0;
        for (ITransactionFP transactionFP : costEstimation.getTransactionFPs())
        {
            int myFPvalue = myComplexityCalculator.calcFPForTFP(transactionFP);
            if (myFPvalue != -1) // check for error from getFPvalue (error = -1)
            {
                sumOfWeightedComplexities += myFPvalue;
            }
        }
        return sumOfWeightedComplexities;
    }
}
