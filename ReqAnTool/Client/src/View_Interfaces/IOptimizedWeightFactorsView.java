package View_Interfaces;

/**
 * Views implementing this interface show the user the new calculated weight factors and give him the opportunity to
 * cancel the optimization. For this it has two view actions:
 * <ul>
 *     <li>{@link Controller_Interfaces.ViewActions#SAVE} - save the new optimized weight factors</li>
 *     <li>{@link Controller_Interfaces.ViewActions#CANCEL} - cancel the calculation and old weight factors are hold</li>
 * </ul>
 * The controller has to observe these two actions and react on them.
 *
 * @author 9045534
 * @version 1.0
 */
public interface IOptimizedWeightFactorsView
	extends IView
{
}
