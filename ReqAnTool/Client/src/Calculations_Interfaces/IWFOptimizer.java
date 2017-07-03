package Calculations_Interfaces;

import Exceptions.MissingParameterException;
import Exceptions.NumberOutOfBoundsException;
import Model_Interfaces.ICostEstimation;
import Model_Interfaces.IWeightFactor;

import java.util.ArrayList;

/**
 * Created by phlippe on 02.07.17.
 */
public interface IWFOptimizer
{

	public ArrayList<IWeightFactor> getOptimizedWF();

	void optimizeWF(ICostEstimation costEstimation, double actualState) throws MissingParameterException;
}
