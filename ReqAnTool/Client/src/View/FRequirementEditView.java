package View;

import Controller_Interfaces.ITextController;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IFRequirement;
import Model_Interfaces.IModelGetData;
import View_Interfaces.IFRequirementEditView;
import View_Interfaces.IFRequirementShowView;
import View_Interfaces.IRequirementFormView;

import javax.swing.*;

/**
 * This class implements {@link IFRequirementEditView} and {@link IFRequirementShowView} to add, edit or show a
 * {@link IFRequirement}. It is based on {@link RequirementFormView}.
 *
 * @author 9045534
 * @version 1.0
 * @see RequirementFormView
 */
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
	protected IFRequirement getReqFromModel(String ID)
	{
		return myModel.getFReqByID(ID);
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
	public String getActorEntry()
	{
		return fieldActor.getText();
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
	public void addTextController(ITextController textfieldController)
	{
		TextAreaListener textAreaListener = new TextAreaListener(textfieldController);
		fieldID.getDocument().addDocumentListener(textAreaListener);
		fieldDescription.getDocument().addDocumentListener(textAreaListener);
		fieldTitle.getDocument().addDocumentListener(textAreaListener);
		fieldActor.getDocument().addDocumentListener(textAreaListener);
	}
}
