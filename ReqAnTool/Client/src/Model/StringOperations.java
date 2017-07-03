package Model;

/**
 * Created by mbill on 19.06.2017.
 */
public class StringOperations
{

    public static int StringToInt(String param)
    {
        int number;
        int i = 0;
        char ch = param.charAt(i);
        while (ch == ' ')
        {
            i++;
            ch = param.charAt(i);
        }
        int j = i;
        ch = param.charAt(j);
        while (ch != ' ')
        {
            j++;
            if (j >= param.length())
            {
                ch = ' ';
            }
            else
            {
                ch = param.charAt(j);
            }
        }
        String cleanString = param.substring(i,j);
        number = Integer.parseInt(cleanString);
        return number;
    }
}
