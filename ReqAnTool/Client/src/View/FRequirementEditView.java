package View;

import Controller_Interfaces.ButtonActions;
import Model_Interfaces.IFRequirement;
import View_Interfaces.IFRequirementEditView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Observable;

public class FRequirementEditView
    extends FormWindow <IFRequirement>
	implements IFRequirementEditView
{

	private JTextField fieldTitle;
    private JTextField fieldID;
    private JTextField fieldActor;
    private JTextArea fieldDescription;
    private JButton buttonSave;
    private JButton buttonCancel;
    private TableSelectionPanel tableSelectionLinks;

    public FRequirementEditView()
	{
        super();
    }

//    public FRequirementEditView(IModel myModel)
//	{
//        super(req);
//    }

    @Override
    protected void init()
    {
        String[] buttonNames = {"Speichern","Abbrechen"};
		String[] requirementFields = {"","","",""};
		if(myReq != null)
		{
			requirementFields[0] = myReq.getTitle();
			requirementFields[1] = myReq.getID();
			requirementFields[2] = myReq.getActor();
			requirementFields[3] = myReq.getDescription();
		}

		setSize(100,500);
        setResizable(false);

        myBuilder.addTitle("Edit Requirement");
        fieldTitle = myBuilder.addNamedTextField("Titel:", requirementFields[0]);
        fieldID = myBuilder.addNamedTextField("ID:", requirementFields[1]);
		fieldActor = myBuilder.addNamedTextField("Akteur:", requirementFields[2]);
		tableSelectionLinks = myBuilder.addTableSelection("Verweise",buttonNames,new String[0]);
		fieldDescription = myBuilder.addNamedTextArea("Beschreibung", requirementFields[3]);
        JButton[] lButton = myBuilder.addButtonBar(buttonNames);
        buttonSave = lButton[0];
        buttonCancel = lButton[1];

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
		return tableSelectionLinks.getTableEntries();
	}

	@Override
	public String getDescriptionEntry()
	{
		return fieldDescription.getText();
	}

	@Override
	public void addController(ActionListener actionListener)
	{
		buttonSave.addActionListener(actionListener);
		buttonSave.setActionCommand(ButtonActions.SAVE.toString());

		buttonCancel.addActionListener(actionListener);
		buttonCancel.setActionCommand(ButtonActions.CANCEL.toString());

		tableSelectionLinks.addController(actionListener);
	}

	@Override
	public void destruct()
	{

	}

	@Override
	public void update(Observable o, Object arg)
	{

	}
}
