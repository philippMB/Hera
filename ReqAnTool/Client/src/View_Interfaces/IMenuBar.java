package View_Interfaces;

import Controller_Interfaces.IMenuController;

/**
 * Created by phlippe on 18.06.17.
 */
public interface IMenuBar
{

	public void setProjectOpen(boolean isProjectOpen);

	public void addController(IMenuController menuController);

}
