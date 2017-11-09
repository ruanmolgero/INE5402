public class IntegerMatrix
{
    int[][] integers;

    public IntegerMatrix(int numberOfRows, int numberOfColumns)
    {
        this.integers = new int[numberOfRows][numberOfColumns];
    }

    public void setValue(int row, int column, int value)
    {
        this.integers[row-1][column-1] = value;
    }

    public int getValue(int row, int column)
    {
        return this.integers[row-1][column-1];
    }

    public int getNumberOfRows()
    {
        return integers.length;
    }

    public int getNumberOfColumns()
    {
        return integers[0].length;
    }

    public int returnRowSum(int rowNumber)
    {
        int sumResult = 0;
        int numberOfColumns = this.getNumberOfColumns();

        for(int i = 0; i < numberOfColumns; i++)
            sumResult += integers[rowNumber-1][i];

        return sumResult;
    }

    public int returnColumnSum(int columnNumber)
    {
        int sumResult = 0;
        int numberOfRows = this.getNumberOfRows();

        for(int i = 0; i < numberOfRows; i++)
            sumResult += integers[i][columnNumber-1];

        return sumResult;
    }

    public int[] returnAllRowsSum()
    {
        int[] sumResult = new int[this.getNumberOfRows()];

        if(sumResult.length != 0)
        {
            int numberOfRows = sumResult.length;
            int numberOfColumns = this.getNumberOfColumns();

            for(int i = 0; i < numberOfRows; i++)
                for(int j = 0; j < numberOfColumns; j++)
                    sumResult[i] += integers[i][j];
        }

        return sumResult;
    }

    public int returnAllNumbersSum()
    {
        int sumResult = 0;

        for(int i = 0; i < integers.length; i++)
            for(int j = 0; j < integers[i].length; j++)
                sumResult += integers[i][j];

        return sumResult;
    }

    public void multiplyByScalar(int scalar)
    {
        for(int i = 0; i < integers.length; i++)
            for(int j = 0; j < integers[i].length; j++)
                integers[i][j] = scalar*integers[i][j];
    }

    public int[][] returnMatrixCopy()
    {
        int[][] resultMatrix = new int[integers.length][integers[0].length];

        for(int i = 0; i < integers.length; i++)
            for(int j = 0; j < integers[i].length; j++)
                resultMatrix[i][j] = integers[i][j];

        return resultMatrix;
    }

    public int[][] sumMatrix(int[][] otherIntegers)
    {
        int[][] resultMatrix;

        if(integers.length != otherIntegers.length || integers[0].length != otherIntegers[0].length)
            resultMatrix = null;
        else
        {
            resultMatrix = new int[integers.length][integers[0].length];

            for(int i = 0; i < integers.length; i++)
                for(int j = 0; j < integers[i].length; j++)
                    resultMatrix[i][j] = integers[i][j] + otherIntegers[i][j];
        }

        return resultMatrix;
    }

    public int[][] multiplyMatrix(int[][] otherIntegers)
    {
        int[][] resultMatrix;

        if(integers[0].length != otherIntegers.length)
            resultMatrix = null;
        else
        {
            resultMatrix = new int[integers.length][otherIntegers[0].length];
            
            for(int i = 0; i < integers.length; i++)
                for(int j = 0; j < otherIntegers[0].length; j++)
                    for(int k = 0; k < integers[0].length; k++)
                        resultMatrix[i][j] += integers[i][k]*otherIntegers[k][j];
        }

        return resultMatrix;
    }
}
