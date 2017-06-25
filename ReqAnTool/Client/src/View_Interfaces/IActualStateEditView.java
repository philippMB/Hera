package View_Interfaces;

/**
 * In this view the user can change the actual state of the cost estimation.
 * <p>
 *     This view provides a way to enter the actual state and change it. For the controller this interface
 *     contains a method to get the string entered from the user.
 * </p>
 * @author 9045534
 * @version 1.0
 * @see IView
 */
public interface IActualStateEditView
	extends IView
{

	/**
	 * Returns the entered string of the user which belongs to the actual state.
	 * @return Entered string for actual state
	 */
	public String getActualState();

}
