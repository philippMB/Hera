package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.ITargetDefinition;
import View_Interfaces.ITargetDefinitionTab;

import javax.xml.soap.Text;
import java.awt.*;

/**
 * Created by phlippe on 28.04.17.
 */
public class TargetDefinitionTab
	extends TextTab
	implements ITargetDefinitionTab
{

	public TargetDefinitionTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_TARGET_DEFINITION);
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_TARGET_DEFINITION));
		buildTextPanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	@Override
	protected String getDescriptionFromModel()
	{
		ITargetDefinition myTargetDefinition = myModel.getTargetDef();
		return myTargetDefinition.getDescription();
	}
}
