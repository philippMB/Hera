package View;

import View_Interfaces.ITargetDefinitionTab;
import java.awt.*;

/**
 * Created by phlippe on 28.04.17.
 */
public class TargetDefinitionTab
	extends TextTab
	implements ITargetDefinitionTab
{

	public TargetDefinitionTab()
	{
		super("Zielbestimmung");
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle("Zielbestimmung");
		buildTextPanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

}
