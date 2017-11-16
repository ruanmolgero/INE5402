public class RandomIntegerMatrixGenerator
{
    public RandomIntegerMatrixGenerator()
    {
    }

    public IntegerMatrix createMatrix(int numberOfRows, int numberOfColumns, int number)
    {
        IntegerMatrix randomMatrix = new IntegerMatrix(numberOfRows, numberOfColumns);
        java.util.Random random = new java.util.Random();

        number++;
        for(int i = 0; i < numberOfRows; i++)
            for(int j = 0; j< numberOfColumns; j++)
                randomMatrix.setValue(i+1, j+1, random.nextInt(number));

        return randomMatrix;
    }
}
