package View_Interfaces;

import Model_Interfaces.IRequirement;

/**
 * Created by phlippe on 04.06.17.
 */
public interface IRequirementShowView<RequirementType extends IRequirement>
	extends IView
{

	public RequirementType getReq();

}
