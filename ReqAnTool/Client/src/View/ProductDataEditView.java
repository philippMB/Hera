package View;

import LanguageAndText.TextNameConstants;
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
			myReq = myModel.getProductDataByID(ID);
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
		fieldContent = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_CONTENT)+":",
				"",
				isEditable
		);
		fieldID = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_ID)+":",
				"",
				isEditable
		);
		buildLinkTable();
		fieldMaxCount = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_MAX_COUNT),
				"",
				isEditable
		);
		fieldAttributes = myBuilder.addNamedTextArea(
				myTextBundle.getParameterText(TextNameConstants.PAR_ATTRIBUTES),
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
			titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_PRODUCTDATA_SHOW);
		}
		else
		{
			if(myReq == null)
			{
				titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_PRODUCTDATA_ADD_NEW);
			}
			else
			{
				titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_PRODUCTDATA_EDIT);
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
			setFieldEntries();
		}
	}

	private void setFieldEntries()
	{
		if(myReq != null)
		{
			fieldID.setText(myReq.getID());
			fieldContent.setText(myReq.getContent());
			fieldMaxCount.setText(myReq.getMaxCount());
			fieldAttributes.setText(myReq.getAttribute());
		}
	}

}
