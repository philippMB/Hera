package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IFRequirement;
import Model_Interfaces.IModelGetData;
import View_Interfaces.IFRequirementEditView;
import View_Interfaces.IFRequirementShowView;

import javax.swing.*;

public class FRequirementEditView
    extends RequirementFormView<IFRequirement>
	implements IFRequirementEditView, IFRequirementShowView
{

	private JTextField fieldTitle;
    private JTextField fieldID;
    private JTextField fieldActor;
    private JTextArea fieldDescription;


    public FRequirementEditView(IModelGetData model)
	{
		this(model,null,true);
	}

    public FRequirementEditView(IModelGetData model, String ID, boolean isEditable)
	{
        super(model,ID,isEditable);
    }

    @Override
    protected void init()
    {
        setResizable(false);

        String titleText = getTitleText();
		setTitle(titleText);
        myBuilder.addTitle(titleText);
        fieldTitle = myBuilder.addNamedTextField(
        		myTextBundle.getParameterText(TextNameConstants.PAR_TITLE)+":",
				"",
				isEditable
		);
        fieldID = myBuilder.addNamedTextField(
        		myTextBundle.getParameterText(TextNameConstants.PAR_ID)+":",
				"",
				isEditable
		);
		fieldActor = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_ACTOR),
				"",
				isEditable
		);
		buildRefTable();
		fieldDescription = myBuilder.addNamedTextArea(
				myTextBundle.getParameterText(TextNameConstants.PAR_DESC),
				"",
				isEditable
		);
		buildButtonBar();

		setFieldEntries();
		updateAll();

        getContentPane().add(myBuilder.getResult());
        pack();
        setLocationRelativeTo(null);
    }

    private String getTitleText()
	{
		String titleText;

		if(!isEditable)
		{
			titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_FREQ_SHOW);
		}
		else
		{
			if(myReq == null)
			{
				titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_FREQ_ADD_NEW);
			}
			else
			{
				titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_FREQ_EDIT);
			}
		}

		return titleText;
	}

    @Override
    public String getIDEntry()
    {
        return fieldID.getText();
    }

	@Override
	protected IFRequirement getReqFromModel(String ID)
	{
		return myModel.getFReqByID(ID);
	}

	@Override
    public String getTitleEntry()
	{
		return fieldTitle.getText();
	}

	@Override
	public String getActorEntry()
	{
		return fieldActor.getText();
	}

	@Override
	public String getDescriptionEntry()
	{
		return fieldDescription.getText();
	}

	@Override
	protected void updateFields()
	{
		if(!isEditable)
		{
			setFieldEntries();
		}
	}

	private void setFieldEntries()
	{
		if(myReq != null)
		{
			fieldID.setText(myReq.getID());
			fieldTitle.setText(myReq.getTitle());
			fieldActor.setText(myReq.getActor());
			fieldDescription.setText(myReq.getDescription());
		}
	}

	@Override
	protected void setIDEntry(String ID)
	{
		fieldID.setText(ID);
	}
}
