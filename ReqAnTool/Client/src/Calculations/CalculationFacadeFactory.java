package Calculations;

import Calculations_Interfaces.*;

/**
 * Created by phlippe on 02.07.17.
 */
public class CalculationFacadeFactory
	implements ICalculatorFacadeFactory
{

	private static CalculationFacadeFactory singleton;


	private CalculationFacadeFactory()
	{

	}

	public static CalculationFacadeFactory getInstance()
	{
		if(singleton == null)
		{
			singleton = new CalculationFacadeFactory();
		}
		return singleton;
	}

	public IFPCalculator createFPCalculator(FPCalcType calcType)
	{
		IFPCalculator calculator;
		switch (calcType)
		{
			case IBM_METHOD:
				calculator = new IBMFPCalculator();
				break;
			default:
				calculator = null;
				break;
		}
		return calculator;
	}

	@Override
	public IMMCalculator createMMCalculator(MMCalcType calculatorType)
	{
		IMMCalculator calculator;
		switch (calculatorType)
		{
			case EST_OF_JONES:
				calculator = new JonesMMCalculator();
				break;
			default:
				calculator = null;
				break;
		}
		return calculator;
	}

	@Override
	public IWFOptimizer createWFOptimizer(WFOptimizerType optimizerType)
	{
		IWFOptimizer optimizer;
		switch (optimizerType)
		{
			case PERCENTAGE_OPTIMIZER:
				optimizer = new PercWFOptimizer();
				break;
			default:
				optimizer = null;
				break;
		}
		return optimizer;
	}


}
