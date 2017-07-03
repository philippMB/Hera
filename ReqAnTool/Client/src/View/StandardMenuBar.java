package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;

import javax.swing.*;

import Model_Interfaces.IModel;
import com.apple.eawt.*;

import java.util.Observable;

/**
 * Created by phlippe on 18.06.17.
 */
public class StandardMenuBar
	extends MenuBar
{

	public StandardMenuBar()
	{
		this(true);
	}

	public StandardMenuBar(boolean isProjectOpen)
	{
		super();
		createFileMenu();
		createEditMenu();
		createCEMenu();
		addAllMenus();
		setProjectOpen(isProjectOpen);
	}

	private void createFileMenu()
	{
		JMenu fileMenu = new JMenu(myTextFacade.getTitleText(TextNameConstants.TITLE_FILE_MENU));
		allMenus.add(fileMenu);

		fileMenu.add(createMenuItem(ViewActions.NEW_PROJECT, false));
		fileMenu.add(createMenuItem(ViewActions.OPEN_PROJECT, false));
		fileMenu.add(createMenuItem(ViewActions.SAVE, true));
		fileMenu.add(createMenuItem(ViewActions.SAVE_AS, true));
		fileMenu.add(createMenuItem(ViewActions.CLOSE, true));
		fileMenu.addSeparator();
		fileMenu.add(createMenuItem(ViewActions.FROM_XML, false));
		fileMenu.add(createMenuItem(ViewActions.TO_XML, true));
		fileMenu.add(createMenuItem(ViewActions.TO_PDF, true));
	}

	private void createEditMenu()
	{
		JMenu editMenu = new JMenu(myTextFacade.getTitleText(TextNameConstants.TITLE_EDIT_MENU));
		allMenus.add(editMenu);

		editMenu.add(createMenuItem(ViewActions.ADD_FREQ, true));
		editMenu.add(createMenuItem(ViewActions.ADD_NFREQ, true));
		editMenu.add(createMenuItem(ViewActions.ADD_PROD, true));
		editMenu.add(createMenuItem(ViewActions.ADD_QR, true));
		editMenu.add(createMenuItem(ViewActions.ADD_GLOS, true));
		editMenu.add(createMenuItem(ViewActions.ADD_ADDIT, true));
	}

	private void createCEMenu()
	{
		JMenu costEstMenu = new JMenu(myTextFacade.getTitleText(TextNameConstants.TITLE_COST_ESTIMATION));
		allMenus.add(costEstMenu);

		costEstMenu.add(createMenuItem(ViewActions.CREATE_CE, true));
		costEstMenu.add(createMenuItem(ViewActions.SHOW_CE, true));
		costEstMenu.add(createMenuItem(ViewActions.EDIT_CE, true));
		costEstMenu.add(createMenuItem(ViewActions.DELETE_CE, true));
		costEstMenu.addSeparator();
		costEstMenu.add(createMenuItem(ViewActions.RATE_WF, true));
		costEstMenu.add(createMenuItem(ViewActions.CALC_FP, true));
		costEstMenu.add(createMenuItem(ViewActions.ENTER_AS, true));
		costEstMenu.add(createMenuItem(ViewActions.OPTIMIZE_WF, true));
		costEstMenu.add(createMenuItem(ViewActions.SHOW_OPT_WF, true));
	}

	private void addAllMenus()
	{
		for(JMenu menu: allMenus)
		{
			add(menu);
		}
	}

	private JMenuItem createMenuItem(ViewActions viewAction, boolean needOpenProject)
	{
		JMenuItem newMenuItem = new JMenuItem(myTextFacade.getButtonText(viewAction));
		newMenuItem.setActionCommand(viewAction.toString());

		if(needOpenProject)
		{
			itemsNeedOpenProject.add(newMenuItem);
		}
		return newMenuItem;
	}

	public void setEverythingEnable(boolean isEnabled)
	{
		for(JMenu menu: allMenus)
		{
			for(int menuItemIndex = 0;menuItemIndex < menu.getItemCount(); menuItemIndex++)
			{
				if(menu.getItem(menuItemIndex) != null)
				{
					menu.getItem(menuItemIndex).setEnabled(isEnabled);
				}
			}
		}
	}

}
