package Calculations_Interfaces;

import Exceptions.MissingParameterException;
import Model_Interfaces.ICostEstimation;

/**
 * Created by mbill on 28.06.2017.
 */
public interface IMMCalculator
{

	public double calcMM(ICostEstimation costEstimation) throws MissingParameterException;

}
