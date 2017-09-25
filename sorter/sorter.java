public class sorter
{
    //private int[] testArray = new int[]{8, 3, 34, 12, 9};
    //private int[] testArray = new int[]{1, 999999999, 333, 4444, 22, 666666, 77777777, 55555, 88888888};

    private int[] copy(int[] array)
    {
        int[] result = new int[array.length];

        for(int i = 0; i < array.length; i++)
            result[i] = array[i];

        return result;
    }

    public sorter()
    {
    }

    public void bubbleSort(int[] array)
    {
        int iteraction = array.length - 1;
        int temp;

        for(int j = iteraction; j > 0; j--)
        {
            for(int i = 0; i < iteraction; i++)
            {
                if(array[i] > array[i+1])
                {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            iteraction--;
        }
    }

    public int[] returnBubbleSort(int[] array)
    {
        int[] result = copy(array);

        bubbleSort(result);

        return result;
    }

    public void selectionSort(int[] array)
    {
        int biggest;
        int pos;
        
        for(int j = 0; j < array.length - 1; j++)
        {
            biggest = array[0];
            pos = 0;

            for(int i = 0; i < array.length - 1 - j; i++)
                if(array[i+1] > biggest)
                {
                    biggest = array[i+1];
                    pos = i + 1;
                }

            array[pos] = array[array.length - 1 - j];
            array[array.length - 1 - j] = biggest;
        }
    }

    public int[] returnSelectionSort(int[] array)
    {
        int[] result = copy(array);

        selectionSort(result);

        return result;
    }
}
