package Model;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by mbill on 13.05.2017.
 */
public class FileOperations
{
    public static ArrayList<String> readLinesFromFile(String path)
    {
        ArrayList<String> lines = new ArrayList<String>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(path));
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
        return lines;

    }

    public static void writeLinesToFile(String path, ArrayList<String> lines)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (String line : lines)
            {
                bw.write(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
