public class RandomArrayGenerator
{
    public RandomArrayGenerator()
    {
    }
    
    public int[] createArray(int arraySize, int inferiorBound, int superiorBound)
    {
        java.util.Random random = new java.util.Random();
        int[] result = new int[arraySize];
        
        /*
        int superiorBoundCorrected = superiorBound + 1;
        
        if(inferiorBound == 0)
            for(int i = 0; i < result.length; i++)
                result[i] = random.nextInt(superiorBoundCorrected);
        else
        {
            for(int i = 0; i < result.length; i++)
            {
                int temp = inferiorBound - 1;
                while(temp < inferiorBound)
                    temp = random.nextInt(superiorBoundCorrected);
                
                result[i] = temp; 
            }
        }
        */
       
        int bounds = superiorBound - inferiorBound + 1;
        
        for(int i = 0; i < result.length; i++)
            result[i] = inferiorBound + random.nextInt(bounds);        
        
        return result;
    }
}
