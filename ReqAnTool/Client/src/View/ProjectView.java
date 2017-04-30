package View;

import Model_Interfaces.GlossaryTab;
import Model_Interfaces.IRequirementAnalysis;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import javax.swing.*;
import java.awt.*;

/**
 * Created by phlippe on 27.04.17.
 */
public class ProjectView
	extends JFrame
{

	private JTabbedPane tabPanel;
	private IRequirementAnalysis myAnalysis;


	public ProjectView(IRequirementAnalysis analysis)
	{
		super("Anforderungsanalyse \""+analysis.getTitle()+"\"");
		init();
	}

	private void init()
	{
		setMinimumSize(new Dimension(550,400));
		setSize(823,400);

		getContentPane().setLayout(new BorderLayout());

		tabPanel = new JTabbedPane();
		ProjectTab Projektmenu = new ProjectTab();
		tabPanel.add(Projektmenu.getTabName(), Projektmenu);
		TargetDefinitionTab TargetDefinition = new TargetDefinitionTab();
		tabPanel.add(TargetDefinition.getTabName(), TargetDefinition);
		ProductApplicationTab ProductApplication = new ProductApplicationTab();
		tabPanel.add(ProductApplication.getTabName(), ProductApplication);
		ProductEnvironmentTab ProductEnvironment = new ProductEnvironmentTab();
		tabPanel.add(ProductEnvironment.getTabName(), ProductEnvironment);
		FRequirementTab FRequirements = new FRequirementTab();
		tabPanel.add(FRequirements.getTabName(), FRequirements);
		NFRequirementTab NFRequirements = new NFRequirementTab();
		tabPanel.add(NFRequirements.getTabName(), NFRequirements);
		ProductdataTab Productdata = new ProductdataTab();
		tabPanel.add(Productdata.getTabName(), Productdata);
		QualityRequirementTab QualityRequirements = new QualityRequirementTab();
		tabPanel.add(QualityRequirements.getTabName(), QualityRequirements);
		AdditionTab Addition = new AdditionTab();
		tabPanel.add(Addition.getTabName(), Addition);
		GlossaryTab Glossary = new GlossaryTab();
		tabPanel.add(Glossary.getTabName(), Glossary);
		CostEstimationTab CostEstimation = new CostEstimationTab();
		tabPanel.add(CostEstimation.getTabName(), CostEstimation);

		getContentPane().add(tabPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	protected void addTab(String tabName, JPanel newTab)
	{
		tabPanel.add(tabName, newTab);
		repaint();
	}

	protected void addTab(TabPanel newTab)
	{
		addTab(newTab.getTabName(), newTab);
	}
}
