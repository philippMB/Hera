package View_Interfaces;

import Model_Interfaces.ClassOfDataFP;
import Model_Interfaces.ClassOfTransactionFP;

/**
 * Created by phlippe on 01.05.17.
 */
public interface IProcessClassificationView
	extends IView
{

	public void showDataFP();

	public void showTransactionFP();

	public void showDefault();

	public Class getSelectedClass();

	public ClassOfDataFP getSelectedClassOfDFP();

	public ClassOfTransactionFP getSelectedClassOfTFP();

	public String getDET();

	public String getRET();

	public String getFTR();
}
