package Controller;

import Controller_Interfaces.ITextController;
import View_Interfaces.ITextTab;

/**
 * Created by phlippe on 25.06.17.
 */
public class TextFieldController
	implements ITextController
{

	private boolean hasTextChangedSinceSaving;


	public TextFieldController(ITextTab myView)
	{
		setView(myView);
		hasTextChangedSinceSaving = false;
	}

	public void setView(ITextTab myView)
	{
		if(myView != null)
		{
			myView.addTextController(this);
		}
	}

	@Override
	public void textChanged()
	{
		hasTextChangedSinceSaving = true;
	}

	public void setSaved()
	{
		hasTextChangedSinceSaving = false;
	}

	public boolean hasTextChangedSinceSaving()
	{
		return hasTextChangedSinceSaving;
	}

}
