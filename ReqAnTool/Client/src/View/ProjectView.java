package View;

import Controller_Interfaces.IController;
import Logging.LogSystem;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IRequirementAnalysis;
import View_Interfaces.IProjectView;
import View_Interfaces.ITab;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

/**
 * Created by phlippe on 27.04.17.
 */
public class ProjectView
	extends JFrame
	implements IProjectView
{

	private JTabbedPane tabPanel;
	private IModelGetData myModel;
	private IRequirementAnalysis myAnalysis;


	public ProjectView(IModelGetData model)
	{
		super();
		myModel = model;
		myAnalysis = myModel.getReqAnalysis();
		if(myAnalysis != null)
		{
			init();
		}
		else
		{
			LogSystem.getLogger().warning("Analysis can not be null!");
		}
	}

	private void init()
	{
		setTitle(myAnalysis.getTitle());
		setMinimumSize(new Dimension(550,400));
		setSize(823,400);

		getContentPane().setLayout(new BorderLayout());

		tabPanel = new JTabbedPane();
		getContentPane().add(tabPanel);

		setVisible(true);
	}

	protected void addTab(String tabName, JPanel newTab)
	{
		tabPanel.add(tabName, newTab);
		repaint();
	}

	@Override
	public void addTab(ITab newTab)
	{
		addTab(newTab.getTabName(), newTab.getPanel());
	}

	@Override
	public void addController(IController newController)
	{
		addWindowListener(newController);
	}

	@Override
	public void destruct()
	{
		setVisible(false);
		dispose();
	}

	@Override
	public void update(Observable o, Object arg)
	{

	}

}
