package View_Interfaces;

import Model_Interfaces.ClassOfDataFP;
import Model_Interfaces.ClassOfTransactionFP;

/**
 * In this view the user can set the class and edit the data and/or transaction function point parameters of a
 * elementary process for the cost estimation. It changes its appearance depending on the selected class what handles
 * an internal controller. This is why the interface contains functions to get data independent on which class is
 * selected, but they can return null if the belonging class is not selected.
 * <p>
 *     This view provides two view actions for the user:
 * <ul>
 *     <li>{@link Controller_Interfaces.ViewActions#SAVE} - saves the new data for the elementary process</li>
 *     <li>{@link Controller_Interfaces.ViewActions#CANCEL} - cancels the changes</li>
 * </ul>
 * The controller has to observe these two actions and react on them.
 *
 * @author 9045534
 * @version 1.0
 *
 */
public interface IProcessClassificationView
	extends IView
{

	/**
	 * Returns the selected class of the elementary process
	 * @return Selected class of the elementary process
	 */
	public Class getSelectedClass();

	/**
	 * Returns the selected subclass for data function point. Only use if
	 * {@link IProcessClassificationView#getSelectedClass()} is data function point.
	 * @return Class of data function point
	 */
	public ClassOfDataFP getSelectedClassOfDFP();

	/**
	 * Returns the selected subclass for transaction function point. Only use if
	 * {@link IProcessClassificationView#getSelectedClass()} is transaction function point.
	 * @return Class of transaction function point
	 */
	public ClassOfTransactionFP getSelectedClassOfTFP();

	/**
	 * Returns the entered DET of the elementary process.
	 * @return DET of elementary process
	 */
	public String getDET();

	/**
	 * Returns the entered RET of the elementary process.
	 * @return RET of elementary process
	 */
	public String getRET();

	/**
	 * Returns the entered FTR of the elementary process.
	 * @return FTR of elementary process
	 */
	public String getFTR();

}
