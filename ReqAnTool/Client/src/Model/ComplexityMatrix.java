package Model;

public class ComplexityMatrix
{
    private Complexities[][] detFtrMat;
    private Complexities[][] detRetMat;
    private int[] detIndexes;
    private int[] ftrIndexes;
    private int[] retIndexes;

    public ComplexityMatrix(Complexities[][] detFtrMat, Complexities[][] detRetMat, int[] detIndexes,
                            int[] ftrIndexes, int[] retIndexes)
    {
        this.detIndexes = detIndexes;
        this.ftrIndexes = ftrIndexes;
        this.retIndexes = retIndexes;
        this.detFtrMat = detFtrMat;
        this.detRetMat = detRetMat;
    }

    public Complexities getDetFtrValue(int det, int ftr)
    {
        int x = 0, y = 0;
        Complexities retValue = Complexities.ERROR;
        for (int i = 0; i < ftrIndexes.length; i++)
        {
            if (ftrIndexes[i] >= ftr)
            {
                x = i;
                break;
            }
        }
        for (int j = 0; j < detIndexes.length; j++)
        {
            if (detIndexes[j] >= det)
            {
                y = j;
                break;
            }
        }
        if (!(x == -1 || y == -1))
        {
            retValue = detFtrMat[x][y];
        }
        return retValue;

    }

    public Complexities getDetRetValue(int det, int ret)
    {
        int x = -1, y = -1;
        Complexities retValue = Complexities.ERROR;
        for (int i = 1; i < detRetMat[0].length; i++)
        {
            if (detIndexes[i] >= det)
            {
                x = i;
                break;
            }
        }
        for (int j = 1; j < retIndexes.length; j++)
        {
            if (retIndexes[j] >= ret)
            {
                y = j;
                break;
            }
        }
        if (!(x == -1 || y == -1))
        {
            retValue = detFtrMat[x][y];
        }
        return retValue;
    }
}
