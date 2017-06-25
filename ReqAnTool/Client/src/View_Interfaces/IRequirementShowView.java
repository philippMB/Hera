package View_Interfaces;

import Model_Interfaces.IRequirement;

/**
 * Views of this interface show the user detailed information about a requirement. In addition it provides two
 * view actions to the user:
 * <ul>
 *     <li>{@link Controller_Interfaces.ViewActions#EDIT} - creates a {@link IRequirementFormView} to edit the
 *     requirement</li>
 *     <li>{@link Controller_Interfaces.ViewActions#DELETE} - deletes the shown requirement</li>
 * </ul>
 * The controller has to observe these actions and react to them.
 *
 * @author 9045534
 * @version 1.0
 *
 */
public interface IRequirementShowView<RequirementType extends IRequirement>
	extends IView
{

	/**
	 * Returns the requirement which is shown by the view
	 * @return Shown requirement
	 */
	public RequirementType getReq();

}
