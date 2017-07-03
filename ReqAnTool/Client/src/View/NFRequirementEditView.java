package View;

import Controller_Interfaces.ITextController;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IFRequirement;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.INFRequirement;
import View_Interfaces.IFRequirementEditView;
import View_Interfaces.IFRequirementShowView;
import View_Interfaces.INFRequirementEditView;
import View_Interfaces.INFRequirementShowView;

import javax.swing.*;

/**
 * This class implements {@link INFRequirementEditView} and {@link INFRequirementShowView} to add, edit or show a
 * {@link INFRequirement}. It is based on {@link RequirementFormView}.
 *
 * @author 9045534
 * @version 1.0
 * @see RequirementFormView
 */
public class NFRequirementEditView
    extends RequirementFormView<INFRequirement>
    implements INFRequirementEditView, INFRequirementShowView
{

	private JTextField fieldTitle;
	private JTextField fieldID;
	private JTextArea fieldDescription;


	public NFRequirementEditView(IModelGetData model)
	{
		this(model,null,true);
	}

    public NFRequirementEditView(IModelGetData model, String ID, boolean isEditable)
    {
    	super(model,ID,isEditable);
    }

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
    @Override
    public String getIDEntry()
    {
        return fieldID.getText();
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected INFRequirement getReqFromModel(String ID)
	{
		return myModel.getNFReqByID(ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
    public String getTitleEntry()
    {
        return fieldTitle.getText();
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public String getDescriptionEntry()
    {
        return fieldDescription.getText();
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setIDEntry(String ID)
	{
		fieldID.setText(ID);
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addTextController(ITextController textfieldController)
	{
		TextAreaListener textAreaListener = new TextAreaListener(textfieldController);
		fieldID.getDocument().addDocumentListener(textAreaListener);
		fieldDescription.getDocument().addDocumentListener(textAreaListener);
		fieldTitle.getDocument().addDocumentListener(textAreaListener);
	}
}
