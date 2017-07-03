package Calculations;

import Calculations_Interfaces.IWFOptimizer;
import Exceptions.MissingParameter;
import Exceptions.MissingParameterException;
import Logging.ILogger;
import Logging.ILoggerFactory;
import Model_Interfaces.ICostEstimation;
import Model_Interfaces.IWeightFactor;

import java.util.ArrayList;

/**
 *
 */
public class PercWFOptimizer
	implements IWFOptimizer
{

	private final double PERCENTAGE_NEW_WF = 0.3;
	private final double PERCENTAGE_OLD_WF = 0.7;

	private ArrayList<IWeightFactor> optWeightFactors;
	private OptimizedWFFileManager myConfig;
	private ILogger myLogger;


	public PercWFOptimizer()
	{
		myConfig = OptimizedWFFileManager.getInstance();
		optWeightFactors = myConfig.readOptWeightFactorFromInit();
		myLogger = ILoggerFactory.getInstance().createLogger("OptimizeWFLog");
	}

	@Override
	public ArrayList<IWeightFactor> getOptimizedWF()
	{
		return optWeightFactors;
	}

	@Override
	public void optimizeWF(ICostEstimation costEstimation, double actualState) throws MissingParameterException
	{
		if (actualState <= 0)
		{
			throw new MissingParameterException(MissingParameter.ACTUAL_STATE);
		}
		if(costEstimation.getManMonth() <= 0)
		{
			throw new MissingParameterException(MissingParameter.MAN_MONTH);
		}
		myLogger.info("Start optimizing weight factors...");
		logWeightFactors("Current optimized Weight factors", optWeightFactors);
		ArrayList<IWeightFactor> optimalWeightFactors = calcOptimalWeightFactors(costEstimation, actualState);
		optWeightFactors = offsetOptimalWF(optimalWeightFactors);
		logWeightFactors("New optimized Weight factors", optWeightFactors);
		myConfig.writeOptWeightFactorsToInit(optWeightFactors);
	}

	private ArrayList<IWeightFactor> calcOptimalWeightFactors(ICostEstimation costEstimation, double actualState)
	{
		ArrayList<IWeightFactor> optimalWeightFactors;
		ArrayList<IWeightFactor> currentWeightFactors = costEstimation.getWeightFactors();

		logWeightFactors("Current weight factors", currentWeightFactors);
		double optimalFP = convertMMToFP(actualState);
		myLogger.info("Actual state\tMM = "+actualState+"\n\t\tFP = "+optimalFP);
		double optimalWFSum = calcOptimalWFSum(currentWeightFactors, costEstimation.getFunctionPoints(), optimalFP);
		myLogger.info("Optimal WF sum = "+optimalWFSum);
		double sumOfDifference = calcSumOfDifference(currentWeightFactors, optimalWFSum);
		myLogger.info("Sum of difference = "+sumOfDifference);
		optimalWeightFactors = adjustWeightFactorsToDifference(currentWeightFactors, sumOfDifference);
		logWeightFactors("Optimal weight factors", optimalWeightFactors);

		return optimalWeightFactors;
	}

	private double convertMMToFP(double manMonth)
	{
		double functionPoints = Math.pow(manMonth, 1/0.4);
		return functionPoints;
	}

	private double calcOptimalWFSum(ArrayList<IWeightFactor> currentWeightFactors, double calculatedFP, double optimalFP)
	{
		double sumOfWF = calcSumOfWeightFactors(currentWeightFactors);
		double correctionFactor = optimalFP / calculatedFP;
		double optimalSumOfWF = correctionFactor * sumOfWF;
		return optimalSumOfWF;
	}

	private double calcSumOfDifference(ArrayList<IWeightFactor> weightFactors, double optimalSum)
	{
		double currentSumOfWF = calcSumOfWeightFactors(weightFactors);
		return optimalSum - currentSumOfWF;
	}

	private ArrayList<IWeightFactor> adjustWeightFactorsToDifference(ArrayList<IWeightFactor> currentWeightFactors,
																	 double sumOfDiff)
	{
		ArrayList<IWeightFactor> adjustedWFs = copyWeightFactors(currentWeightFactors);
		double appliedDistributedDiff = applyDifferenceToWeightFactors(adjustedWFs, sumOfDiff, true);
		double differenceLeft = sumOfDiff - appliedDistributedDiff;
		applyDifferenceToWeightFactors(adjustedWFs, differenceLeft, false);
		return adjustedWFs;
	}

	private double applyDifferenceToWeightFactors(ArrayList<IWeightFactor> weightFactors, double sumOfDiff,
												  boolean applyDistributed)
	{
		myLogger.info("Apply difference to weight factor\nsumOfDiff = "+sumOfDiff+"\ndistributed="+applyDistributed);
		double appliedDifference = 0;
		int numberOfWeightFactors = weightFactors.size();
		for(IWeightFactor weightFactor: weightFactors)
		{
			double currentValue = weightFactor.getExactValue();
			double adjustedValue;
			if(applyDistributed)
			{
				//Apply difference distributed over all weight factors
				adjustedValue = currentValue + sumOfDiff / numberOfWeightFactors;
			}
			else
			{
				//Apply difference as much as possible to a weight factor
				adjustedValue = currentValue + (sumOfDiff - appliedDifference);
			}
			adjustedValue = Math.min(adjustedValue, weightFactor.getMaxValue());
			adjustedValue = Math.max(adjustedValue, 0);
			myLogger.info("Adjust from "+currentValue+" to "+adjustedValue);
			try
			{
				weightFactor.setValue(adjustedValue);
				appliedDifference += adjustedValue - currentValue;
			}
			catch(Exception ex)
			{
				myLogger.error("Run out of bounds in apply difference", ex);
			}
		}
		return appliedDifference;
	}

	private ArrayList<IWeightFactor> offsetOptimalWF(ArrayList<IWeightFactor> optimalWeightFactors)
	{
		ArrayList<IWeightFactor> offsetedWF = new ArrayList<>(optimalWeightFactors);
		if(existsOptWeightFactors())
		{
			for (IWeightFactor weightFactor : offsetedWF)
			{
				IWeightFactor optWFWithTitle = getOptimizedWFByTitle(weightFactor.getTitle());
				if(optWFWithTitle != null)
				{
					double offsetedValue = optWFWithTitle.getExactValue() * PERCENTAGE_OLD_WF +
											weightFactor.getExactValue() * PERCENTAGE_NEW_WF;
					myLogger.info("Offseted value from "+optWFWithTitle.getExactValue()+"*"+PERCENTAGE_OLD_WF+"+"
							+weightFactor.getExactValue()+"*"+PERCENTAGE_NEW_WF);
					try
					{
						weightFactor.setValue(offsetedValue);
					}
					catch(Exception ex)
					{
						myLogger.error("Run out of bounds in offset WF", ex);
					}
				}
				else
				{
					myLogger.error("Unknown weight factor title "+weightFactor.getTitle());
				}
			}
		}
		else
		{
			//If no optimized weight factors exist the first calculated will be set to 100%
		}
		return offsetedWF;
	}

	private IWeightFactor getOptimizedWFByTitle(String title)
	{
		IWeightFactor optimizedWF = null;
		for(IWeightFactor weightFactor: optWeightFactors)
		{
			if(weightFactor.getTitle().equals(title))
			{
				optimizedWF = weightFactor;
			}
		}
		return optimizedWF;
	}

	private ArrayList<IWeightFactor> copyWeightFactors(ArrayList<IWeightFactor> weightFactorsToCopy)
	{
		ArrayList<IWeightFactor> copiedWeightFactors = new ArrayList<>();
		for(IWeightFactor weightFactor: weightFactorsToCopy)
		{
			copiedWeightFactors.add(weightFactor.copy());
		}
		return copiedWeightFactors;
	}

	private double calcSumOfWeightFactors(ArrayList<IWeightFactor> weightFactors)
	{
		int sumOfWF = 0;
		for (IWeightFactor myWeightFactor : weightFactors)
		{
			sumOfWF += myWeightFactor.getExactValue();
		}
		return sumOfWF;
	}

	private boolean existsOptWeightFactors()
	{
		boolean exists = false;
		for (IWeightFactor optFac : optWeightFactors)
		{
			if (optFac.getExactValue() != 0)
			{
				exists = true;
			}
		}
		return exists;
	}

	private void logWeightFactors(String name, ArrayList<IWeightFactor> weightFactorsToLog)
	{
		String logText = name + "\n==============================================================\n";
		for(IWeightFactor weightFactor: weightFactorsToLog)
		{
			logText += weightFactor.getTitle()+" | "+weightFactor.getExactValue()+"\n";
		}
		myLogger.info(logText);
	}
}
