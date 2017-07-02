package Controller;

import Exceptions.NumberOutOfBoundsException;
import Exceptions.NumberType;
import Exceptions.StringNoNumberException;
import Model_Interfaces.ClassOfDataFP;
import Model_Interfaces.ClassOfTransactionFP;
import Model_Interfaces.IClassOfFP;
import Model_Interfaces.IModel;
import View_Interfaces.IProcessClassificationView;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by phlippe on 01.07.17.
 */
public class ProcessClassificationController
	extends BasicViewController<IProcessClassificationView>
{


	public ProcessClassificationController(IModel modelToBeControlled, IProcessClassificationView viewToBeControlled)
	{
		super(modelToBeControlled, viewToBeControlled);
	}

	@Override
	protected void executeSaveAction()
	{
		IClassOfFP selectedFPClass = myView.getSelectedClass();
		try
		{
			saveChangesInModel(selectedFPClass);
			closeView();
		}
		catch(Exception ex)
		{
			handleException(ex);
		}

	}

	private void saveChangesInModel(IClassOfFP selectedFPClass)
			throws Exception
	{
		String reqID = myView.getReqID();
		if(selectedFPClass instanceof ClassOfDataFP)
		{
			saveDFPForID((ClassOfDataFP)selectedFPClass, reqID);
		}
		else
		{
			if(selectedFPClass instanceof ClassOfTransactionFP)
			{
				saveTFPForID((ClassOfTransactionFP)selectedFPClass, reqID);
			}
			else
			{
				if(selectedFPClass == null)
				{
					remEPForID(reqID);
				}
				else
				{
					myLogger.warning("Unknown class of function point which could not be processed - "+
							selectedFPClass.getClass().getName());
				}
			}
		}
	}

	private void saveDFPForID(ClassOfDataFP dataFPClass, String reqID)
			throws Exception
	{
		int DET = convertStringToInteger(myView.getDET());
		int RET = convertStringToInteger(myView.getRET());
		if(myModel.getCostEstimation().hasIDTransactionFP(reqID))
		{
			myModel.remTransactionFPByID(reqID);
		}
		if(myModel.getCostEstimation().hasIDDataFP(reqID))
		{
			myModel.editDataFPByID(dataFPClass, reqID, DET, RET);
		}
		else
		{
			myModel.setDataFP(dataFPClass, reqID, DET, RET);
		}
	}

	private void saveTFPForID(ClassOfTransactionFP transactionFPClass, String reqID)
			throws Exception
	{
		int DET = convertStringToInteger(myView.getDET());
		int FTR = convertStringToInteger(myView.getFTR());
		if(myModel.getCostEstimation().hasIDDataFP(reqID))
		{
			myModel.remDataFPByID(reqID);
		}
		if(myModel.getCostEstimation().hasIDTransactionFP(reqID))
		{
			myModel.editTransactionFPByID(transactionFPClass, reqID, DET, FTR);
		}
		else
		{
			myModel.setTransactionFP(transactionFPClass, reqID, DET, FTR);
		}
	}

	private void remEPForID(String reqID)
			throws Exception
	{
		if(myModel.getCostEstimation().hasIDTransactionFP(reqID))
		{
			myModel.remTransactionFPByID(reqID);
		}
		if(myModel.getCostEstimation().hasIDDataFP(reqID))
		{
			myModel.remDataFPByID(reqID);
		}
	}

	private int convertStringToInteger(String stringToConvert)
			throws StringNoNumberException
	{
		Number convertedNumber = myTextBundle.convertStringToNumber(stringToConvert);
		if(convertedNumber == null)
		{
			throw new StringNoNumberException(NumberType.INTEGER, stringToConvert);
		}
		return convertedNumber.intValue();
	}



	@Override
	protected void executeCancelAction()
	{
		closeView();
	}
}
