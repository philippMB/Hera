package View;

import Controller_Interfaces.IMenuController;
import LanguageAndText.ITextFacade;
import View_Interfaces.IMenuBar;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by phlippe on 18.06.17.
 */
public class MenuBar
	extends JMenuBar
	implements IMenuBar
{

	protected ITextFacade myTextFacade;
	protected ArrayList<JMenu> allMenus;
	protected ArrayList<JMenuItem> itemsNeedOpenProject;


	public MenuBar()
	{
		myTextFacade = ITextFacade.getInstance();
		allMenus = new ArrayList<>();
		itemsNeedOpenProject = new ArrayList<>();
	}

	@Override
	public void setProjectOpen(boolean isProjectOpen)
	{
		for(JMenuItem item: itemsNeedOpenProject)
		{
			item.setEnabled(isProjectOpen);
		}
	}

	@Override
	public void addController(IMenuController menuController)
	{
		for(JMenu menu: allMenus)
		{
			menu.addActionListener(menuController);
			for(int menuItemIndex = 0;menuItemIndex < menu.getItemCount(); menuItemIndex++)
			{
				if(menu.getItem(menuItemIndex) != null)
				{
					menu.getItem(menuItemIndex).addActionListener(menuController);
				}
			}
		}
	}

}
