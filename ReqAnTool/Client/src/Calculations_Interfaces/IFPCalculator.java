package Calculations_Interfaces;

import Exceptions.MissingEntryException;
import Exceptions.MissingParameterException;
import Model_Interfaces.ICostEstimation;

/**
 * Created by mbill on 28.06.2017.
 */
public interface IFPCalculator
{

	public double calcFP(ICostEstimation costEstimation) throws MissingParameterException;

}
