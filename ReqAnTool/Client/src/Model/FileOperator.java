package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by phlippe on 02.07.17.
 */
public class FileOperator
{


	public FileOperator()
	{

	}

	public String[] readLinesFromFile(String path)
	{
		ArrayList<String> lines = new ArrayList<>();
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(path)));
			String line;
			while((line = br.readLine()) != null)
			{
				lines.add(line);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return lines.toArray(new String[0]);
	}

}
