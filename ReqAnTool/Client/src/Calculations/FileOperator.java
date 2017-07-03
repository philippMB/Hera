package Calculations;

import Logging.ILogger;
import Logging.ILoggerFactory;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by mbill on 13.05.2017.
 */
public class FileOperator
{

	private ILogger myLogger;


    public FileOperator()
    {
		myLogger = ILoggerFactory.getInstance().createLogger();
    }

    public ArrayList<String> readLinesFromInnerFile(String path)
    {
        ArrayList<String> lines = new ArrayList<String>();
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
            myLogger.error("Could not open inner file for reading: "+path, e);
        }
        return lines;

    }

	public ArrayList<String> readLinesFromOuterFile(String path)
	{
		ArrayList<String> lines = new ArrayList<String>();
		try
		{
			path = getPathNextToJAR(path);
			File f = new File(path);
			if(f.exists())
			{
				FileReader fileReader = new FileReader(path);
				BufferedReader br = new BufferedReader(fileReader);
				String line;
				while ((line = br.readLine()) != null)
				{
					lines.add(line);
				}
			}
			else
			{
				lines = null;
			}
		}
		catch (IOException e)
		{
			myLogger.error("Could not open outer file for reading: "+path, e);
		}
		return lines;

	}

    public void writeLinesToFile(String path, ArrayList<String> lines)
    {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try
        {
			path = getPathNextToJAR(path);
			fw = new FileWriter(path);
            bw = new BufferedWriter(fw);
            for (String line : lines)
            {
                bw.write(line);
                bw.newLine();
            }
        }
        catch (IOException e)
        {
        	myLogger.error("Could not write lines to file: "+path, e);
        }
        finally
        {
            try
            {
                if (bw != null)
                	bw.close();
            }
            catch (IOException e)
            {
				myLogger.error("Could not close buffered reader", e);
            }
            try
            {
                if (fw != null)
                	fw.close();
            }
            catch (IOException e)
            {
            	myLogger.error("Could not close file writer", e);
            }
        }
    }

    private String getPathNextToJAR(String path)
	{
		String pathStartingOfJar = "";
		try
		{
			pathStartingOfJar = this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
			pathStartingOfJar = pathStartingOfJar.substring(0,pathStartingOfJar.lastIndexOf(File.separator) + 1);
		}
		catch(URISyntaxException ex)
		{
			myLogger.warning("Could not create file next to jar: "+path, ex);
		}
		return pathStartingOfJar + path;
	}
}
