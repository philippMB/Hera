package Model;

public class ComplexityMatrix
{
    private int[][] detFtrMat;
    private int[][] detRetMat;

    public ComplexityMatrix(int[][] detFtrMat, int[][] detRetMat)
    {
        this.detFtrMat = detFtrMat;
        this.detRetMat = detRetMat;
    }

    public int getDetFtrValue(int det, int ftr)
    {
        int x = 0, y = 0;
        for (int j = 1; j < detFtrMat[0].length; j++)
        {
            if (detFtrMat[j][0] >= ftr)
            {
                x = j;
                break;
            }
        }
        for (int i = 1; i < detFtrMat[0].length; i++)
        {
            if (detFtrMat[0][i] >= det)
            {
                y = i;
                break;
            }
        }
        return detFtrMat[x][y];

    }

    public int getDetRetValue(int det, int ret)
    {
        int x = 0, y = 0;
        for (int j = 1; j < detRetMat[0].length; j++)
        {
            if (detRetMat[j][0] >= ret)
            {
                x = j;
                break;
            }
        }
        for (int i = 1; i < detRetMat[0].length; i++)
        {
            if (detFtrMat[0][i] >= det)
            {
                y = i;
                break;
            }
        }
        return detFtrMat[x][y];

    }

    public int getMaxValue()
    {
        int maxValue = 0;
        for (int i = 1; i < detRetMat.length; i++)
        {
            for (int j = 1; j < detRetMat[0].length; j++)
            {
                if (detRetMat[i][j] > maxValue)
                {
                    maxValue = detRetMat[i][j];
                }
            }
        }
        for (int i = 0; i < detFtrMat.length; i++)
        {
            for (int j = 0; j < detFtrMat[0].length; j++)
            {
                if (detFtrMat[i][j] > maxValue)
                {
                    maxValue = detFtrMat[i][j];
                }
            }
        }
        return maxValue;
    }
}
