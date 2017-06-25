package View_Interfaces;

import Controller_Interfaces.IMenuController;

/**
 * This interface sets up a standard for menu bars of {@link IView}.
 * Every view could have a menu bar. Due to mostly the menu bar is shared between different views they both
 * are separated and should be separately controlled. Which view actions are exactly provided in a menu is specified
 * within the implementation of the view and should be seen as every view actions would be implemented for the
 * controller.
 * <p>
 *     The scope of functions depends on if a project/requirement analysis is opened or not. To handle this case
 *     the function {@link IMenuBar#setProjectOpen(boolean)} provides a mechanism to set this restriction or not. The
 *     controller should observe the model and set or unset it when needed.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 * @see IView
 */
public interface IMenuBar
{

	/**
	 * A menu bar restricts it functionality if no project is opened. To set or unset this restriction use this method.
	 * @param isProjectOpen If a project is open set true. Otherwise false.
	 */
	public void setProjectOpen(boolean isProjectOpen);

	/**
	 * Adds a {@link IMenuController} to this menu bar.
	 * @param menuController Controller to control this menu bar.
	 */
	public void addController(IMenuController menuController);

}
