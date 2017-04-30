package View;

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

        myBuilder.addTitle("Edit Requirement");
        fieldTitle = myBuilder.addNamedTextField("Titel:","",isEditable);
        fieldID = myBuilder.addNamedTextField("ID:","",isEditable);
		fieldActor = myBuilder.addNamedTextField("Akteur:", "",isEditable);
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
