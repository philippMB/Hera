package View_Interfaces;

/**
 * Views implementing this interface show the user the new calculated weight factors. For this it has one view action:
 * <ul>
 *     <li>{@link Controller_Interfaces.ViewActions#CLOSE} - closes this view</li>
 * </ul>
 * The controller has to observe these actions and react on them.
 *
 * @author 9045534
 * @version 1.0
 */
public interface IOptimizedWeightFactorsView
	extends IView
{
}
