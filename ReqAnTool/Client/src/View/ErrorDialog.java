package View;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by phlippe on 27.04.17.
 */
public class ErrorDialog
	extends DialogView
{

	private static final Path errorSignURL = Paths.get("/Users/phlippe/Documents/DHBW Stuttgart/4. Semester/Softwareengineering/Bilder/Fehlerschild.png");

	private String descriptionText;
	private String title;

	public ErrorDialog(String title, String errorDescription){
		super("Fehlermeldung");
		this.title = title;
		descriptionText = errorDescription;
		init();
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle(title);
		myBuilder.addImage(errorSignURL);
		myBuilder.addText(descriptionText);
		getContentPane().add(new BorderDecorater(myBuilder.getResult(), Color.RED, "Fehlermeldung"));

		pack();
		setVisible(true);
	}
}
