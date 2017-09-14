public class sorter
{
    //private int[] testArray = new int[]{8, 3, 34, 12, 9};
    //private int[] testArray = new int[]{1, 999999999, 333, 4444, 22, 666666, 77777777, 55555, 88888888};
    
    public sorter()
    {
    }

    public int[] bubbleSort(int[] testArray)
    {
        int iteraction = testArray.length - 1;
        
        for(int j = iteraction; j > 0; j--)
        {
            for(int i = 0; i < iteraction; i++)
            {
                if(testArray[i] > testArray[i+1])
                {
                    int temp = testArray[i];
                    testArray[i] = testArray[i+1];
                    testArray[i+1] = temp;
                }
            }
            iteraction--;
        }
        
        return testArray;
    }
    
    public int[] selectionSort(int[] testArray)
    {
        for(int j = 0; j < testArray.length - 1; j++)
        {
            int biggest= testArray[0];
            int pos = 0;
            
            for(int i = 0; i < testArray.length - 1 - j; i++)
                if(testArray[i+1] > biggest)
                {
                    biggest = testArray[i+1];
                    pos = i + 1;
                }
            
            testArray[pos] = testArray[testArray.length - 1 - j];
            testArray[testArray.length - 1 - j] = biggest;
        }
                     
        return testArray;
    }
    
        
}
