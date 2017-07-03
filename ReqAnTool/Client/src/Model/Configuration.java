package Model;

import Calculations_Interfaces.*;
import Model_Interfaces.IXMLManager;

/**
 * Created by phlippe on 02.07.17.
 */
public class Configuration
{

	private static final String CONFIG_FILE_PATH = "config.init";
	private static Configuration singleton;

	private IMMCalculator myMMCalculator;
	private IFPCalculator myFPCalculator;
	private IWFOptimizer myWFOptimizer;
	private IXMLManager myXMLManager;

	private Configuration()
	{
		FileOperator fileOperator = new FileOperator();
		String[] configLines = fileOperator.readLinesFromFile(CONFIG_FILE_PATH);
		setUpCalculators(configLines[0], configLines[1], configLines[2]);
		setUpXML(configLines[3]);
	}

	public static Configuration getInstance()
	{
		if(singleton == null)
		{
			singleton = new Configuration();
		}
		return singleton;
	}

	private void setUpCalculators(String mmCalcType, String fpCalcType, String wfOptType)
	{
		ICalculatorFacadeFactory calculatorFacadeFactory = ICalculatorFacadeFactory.getInstance();
		myMMCalculator = calculatorFacadeFactory.createMMCalculator(convertStringToMMCalcType(mmCalcType));
		myFPCalculator = calculatorFacadeFactory.createFPCalculator(convertStringToFPCalcType(fpCalcType));
		myWFOptimizer = calculatorFacadeFactory.createWFOptimizer(convertStringToWFOptType(wfOptType));
	}

	private MMCalcType convertStringToMMCalcType(String type)
	{
		MMCalcType calcType;
		try
		{
			calcType = MMCalcType.valueOf(type);
		}
		catch(Exception ex)
		{
			//TODO: Log wrong config
			calcType = MMCalcType.EST_OF_JONES;	//DEFAULT
		}
		return calcType;
	}

	private FPCalcType convertStringToFPCalcType(String type)
	{
		FPCalcType calcType;
		try
		{
			calcType = FPCalcType.valueOf(type);
		}
		catch(Exception ex)
		{
			//TODO: Log wrong config
			calcType = FPCalcType.IBM_METHOD;	//DEFAULT
		}
		return calcType;
	}

	private WFOptimizerType convertStringToWFOptType(String type)
	{
		WFOptimizerType calcType;
		try
		{
			calcType = WFOptimizerType.valueOf(type);
		}
		catch(Exception ex)
		{
			//TODO: Log wrong config
			calcType = WFOptimizerType.PERCENTAGE_OPTIMIZER;	//DEFAULT
		}
		return calcType;
	}

	private void setUpXML(String xmlType)
	{
		//Due to only one XML component is developed yet the value is not evaluated
		myXMLManager = IXMLManager.getInstance();
	}

	public IMMCalculator getMMCalculator()
	{
		return myMMCalculator;
	}

	public IFPCalculator getFPCalculator()
	{
		return myFPCalculator;
	}

	public IWFOptimizer getWFOptimizer()
	{
		return myWFOptimizer;
	}

	public IXMLManager getXMLManager()
	{
		return myXMLManager;
	}

}
