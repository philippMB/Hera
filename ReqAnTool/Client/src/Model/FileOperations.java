package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
            // TODO
            e.printStackTrace();
        }
        return lines;

    }
}
