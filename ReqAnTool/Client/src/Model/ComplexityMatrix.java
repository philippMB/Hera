package Model;

public class ComplexityMatrix
{
    /*
    Format of Matrices:
    detFtrMatrix:
                <= x1 DET    <= x2 DET    > x2 DET
    <= y1 FTR    EASY         EASY         MEDIUM
    <= y2 FTR    EASY         MEDIUM       COMPLEX
    >  y2 FTR    MEDIUM       COMPLEX      COMPLEX
    (equals for detRetMatrix but 'ftr' replaced with 'ret'
     */

    private Complexities[][] Matrix;
    private int[] detIndexes;
    private int[] ftrIndexes;
    private int[] retIndexes;

    public ComplexityMatrix(int[] detIndexes, int[] ftrIndexes, int[] retIndexes)
    {
        this.detIndexes = detIndexes;
        this.ftrIndexes = ftrIndexes;
        this.retIndexes = retIndexes;
        this.Matrix = new Complexities[][] {{Complexities.EASY, Complexities.EASY, Complexities.MEDIUM},
                                            {Complexities.EASY, Complexities.MEDIUM, Complexities.COMPLEX},
                                            {Complexities.MEDIUM, Complexities.COMPLEX, Complexities.COMPLEX}};
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
            retValue = Matrix[x][y];
        }
        return retValue;

    }

    public Complexities getDetRetValue(int det, int ret)
    {
        int x = -1, y = -1;
        Complexities retValue = Complexities.ERROR;
        for (int i = 1; i < Matrix[0].length; i++)
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
            retValue = Matrix[x][y];
        }
        return retValue;
    }
}
