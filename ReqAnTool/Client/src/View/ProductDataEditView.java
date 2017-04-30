package View;

import Model_Interfaces.IModelGetData;
import Model_Interfaces.IProductData;
import Model_Interfaces.IRequirement;
import View_Interfaces.IProductDataEditView;

import javax.swing.*;

public class ProductDataEditView
	extends RequirementFormView
	implements IProductDataEditView
{

	private IProductData myReq;
	private JTextField fieldContent;
	private JTextField fieldID;
	private JTextField fieldMaxCount;
	private JTextArea fieldAttributes;



	public ProductDataEditView(IModelGetData model)
	{
		this(model,null,true);
	}

	public ProductDataEditView(IModelGetData model, String ID, boolean isEditable)
	{
		super(model,isEditable);
		if(ID != null)
		{
			myReq = myModel.getPReqByID(ID);
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
		fieldContent = myBuilder.addNamedTextField("Speicherinhalt:","",isEditable);
		fieldID = myBuilder.addNamedTextField("ID:","",isEditable);
		buildLinkTable();
		fieldMaxCount = myBuilder.addNamedTextField("Max. Anzahl","",isEditable);
		fieldAttributes = myBuilder.addNamedTextArea("Beschreibung:", "",isEditable);
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
	public String getContentEntry()
	{
		return fieldContent.getText();
	}

	@Override
	public String getMaxCountEntry()
	{
		return fieldMaxCount.getText();
	}

	@Override
	public String[] getLinkEntry()
	{
		return getTableEntries();
	}

	@Override
	public String getAttributeEntry()
	{
		return fieldAttributes.getText();
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
			fieldContent.setText(myReq.getContent());
			fieldMaxCount.setText(myReq.getMaxCount());
			fieldAttributes.setText(myReq.getAttribute());
		}
	}

}
