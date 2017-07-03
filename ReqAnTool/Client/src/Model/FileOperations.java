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
        BufferedWriter bw = null;
        FileWriter fw = null;
        try
        {
            bw = new BufferedWriter(fw = new FileWriter(path));
            for (String line : lines)
            {
                bw.write(line);
                bw.newLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
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
                e.printStackTrace();
            }
            try
            {
                if (fw != null)
                fw.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
