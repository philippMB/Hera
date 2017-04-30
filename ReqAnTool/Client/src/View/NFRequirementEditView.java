package View;

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

		myBuilder.addTitle("Edit Requirement");
		fieldTitle = myBuilder.addNamedTextField("Titel:","",isEditable);
		fieldID = myBuilder.addNamedTextField("ID:","",isEditable);
		buildLinkTable();
		fieldDescription = myBuilder.addNamedTextArea("Beschreibung", "",isEditable);
		buildButtonBar();

		updateAll();

		getContentPane().add(myBuilder.getResult());
		pack();
		setLocationRelativeTo(null);

		setVisible(true);
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
			fieldID.setText(myReq.getID());
			fieldTitle.setText(myReq.getTitle());
			fieldDescription.setText(myReq.getDescription());
		}
	}

}
