package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IFRequirement;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IRequirement;
import View_Interfaces.IFRequirementEditView;

import javax.swing.*;

public class FRequirementEditView
    extends RequirementFormView
	implements IFRequirementEditView
{

	private IFRequirement myReq;
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
        super(model,isEditable);
        if(ID != null)
		{
			myReq = myModel.getFReqByID(ID);
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
		fieldActor = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_ACTOR),
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
	public IRequirement getMyRequirement()
	{
		return myReq;
	}

	@Override
	protected void setIDEntry(String ID)
	{
		fieldID.setText(ID);
	}

}
