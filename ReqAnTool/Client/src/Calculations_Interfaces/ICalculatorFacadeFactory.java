package Calculations_Interfaces;

import Calculations.CalculationFacadeFactory;

/**
 * Created by phlippe on 02.07.17.
 */
public interface ICalculatorFacadeFactory
{

	public static ICalculatorFacadeFactory getInstance()
	{
		return CalculationFacadeFactory.getInstance();
	}

	public IFPCalculator createFPCalculator(FPCalcType calculatorType);

	public IMMCalculator createMMCalculator(MMCalcType calculatorType);

	public IWFOptimizer createWFOptimizer(WFOptimizerType optimizerType);
}
