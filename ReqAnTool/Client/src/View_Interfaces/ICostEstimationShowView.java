package View_Interfaces;

/**
 * Views implementing this interface presents data of the current cost estimation to the user.
 * Due to this views are only presenting information to the user the view actions are limited to the following ones:
 * <ul>
 *     <li>{@link Controller_Interfaces.ViewActions#EDIT} - edit the cost estimation in a
 *     {@link ICostEstimationEditView}</li>
 *     <li>{@link Controller_Interfaces.ViewActions#CLOSE} - closes view</li>
 * </ul>
 * More actions are not possible for the user and so the controller has only to observe these both.
 *
 *
 * @author 9045534
 * @version 1.0
 * @see ICostEstimationEditView
 */
public interface ICostEstimationShowView
	extends IView
{

}
