package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.INFRequirement;
import Model_Interfaces.IRequirement;
import View_Interfaces.INFRequirementEditView;

import javax.swing.*;

public class NFRequirementEditView
    extends RequirementFormView
    implements INFRequirementEditView
{

	private INFRequirement myReq;
	private JTextField fieldTitle;
	private JTextField fieldID;
	private JTextArea fieldDescription;


	public NFRequirementEditView(IModelGetData model)
	{
		this(model,null,true);
	}

    public NFRequirementEditView(IModelGetData model, String ID, boolean isEditable)
    {
    	super(model,isEditable);
		if(ID != null)
		{
			myReq = myModel.getNFReqByID(ID);
		}
		else
		{
			myReq = null;
			//Falls keine ID übergeben wird, muss die View editierbar sein
			if(!isEditable)
			{
				this.isEditable = true;
			}
		}
		init();
    }

    @Override
    protected void init()
    {
		setResizable(false);

		String titleText = getTitleText();

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
		buildLinkTable();
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

		setVisible(true);
    }

	private String getTitleText()
	{
		String titleText;

		if(!isEditable)
		{
			titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_NFREQ_SHOW);
		}
		else
		{
			if(myReq == null)
			{
				titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_NFREQ_ADD_NEW);
			}
			else
			{
				titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_NFREQ_EDIT);
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
    public String getTitleEntry()
    {
        return fieldTitle.getText();
    }

    @Override
    public String[] getLinkEntry()
    {
        return getTableEntries();
    }

    @Override
    public String getDescriptionEntry()
    {
        return fieldDescription.getText();
    }

	@Override
	public IRequirement getMyRequirement()
	{
		return myReq;
	}

	@Override
	protected void setIDEntry(String ID)
	{
		fieldID.setText(ID);
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
			fieldDescription.setText(myReq.getDescription());
		}
	}

}
