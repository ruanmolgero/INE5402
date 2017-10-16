public class Ship
{
    /*
     * Re-do exercise:
     * 1 - Adding actualCarrying and actualWeight atributes, and correct other methods according to it.
     * 2 - Use "Container c" instead of: "String ID, float weight".
     * 3 - Change some methods to improve object orientation ideas in it,
     *     such as "loadContainer" testing all the possibilities before loading the container.
     * 4 - Implement private methods to help writing the other methods (ex.: findAvailablePosition).
     */
    
    private int maxCapacity;
    private float maxWeight;
    private Container[] containers;

    public Ship(int maxCapacity, float maxWeight)
    {
        this.maxCapacity = maxCapacity;
        this.maxWeight = maxWeight;
        containers = new Container[maxCapacity];
    }

    public int getMaxCapacity()
    {
        return this.maxCapacity;
    }

    public float getMaxWeight()
    {
        return this.maxWeight*1.00f;
    }

    public int getActualCarrying()
    {
        int actualCarrying = 0;

        for(int i = 0; i < containers.length; i++)
        {
            if(containers[i] == null)
                i = i;
            else
                actualCarrying++;
        }
                
        return actualCarrying;
    }

    public float getActualWeight()
    {
        float actualWeight = 0;

        for(int i = 0; i < containers.length; i++)
        {
            if(containers[i] == null)
                i = i;
            else
                actualWeight += containers[i].getWeight();
        }

        return actualWeight*1.00f;
    }

    public boolean loadContainer(String ID, float weight)
    {
        boolean ableToLoad = true;
        boolean operationSuccess = false;
        int i = 0;

        if(this.getActualCarrying() == this.maxCapacity || this.getActualWeight() + weight > this.maxWeight)
            ableToLoad = false;

        while(ableToLoad && i < containers.length)
        {
            if(containers[i] == null)
                i++;
            else if(containers[i].getID() == ID)
                ableToLoad = false;
            else
                i++;
        }

        i = 0;

        if(ableToLoad)
        {
            while(containers[i] != null)
                i++;

            containers[i] = new Container(ID, weight);

            operationSuccess = true;
        }

        return operationSuccess;                            //could use ableToLoad instead of operationSuccess
    }

    public Container unloadContainer(String ID)
    {
        boolean ctnr = false;
        int i = 0;
        Container container = null;

        while(!ctnr && i < containers.length)
        {
            if(containers[i] == null)
                i++;
            else if(containers[i].getID() == ID)
                ctnr = true;
            else
                i++;
        }

        if(ctnr)
        {
            container = new Container(containers[i].getID(), containers[i].getWeight());
            containers[i] = null;
        }

        return container;
    }

    public boolean isCarryingContainer(String ID)
    {
        boolean carrying = false;
        int i = 0;

        while(!carrying && i < containers.length)
        {
            if(containers[i] == null)                //if(containers[i] != null && containers[i].getID() == ID); test for the number of tested containers and the actualCarrying
                i++;
            else if(containers[i].getID() == ID)
                carrying = true;
            else
                i++;
        }

        return carrying;
    }

    public String[] containersUnderBoundary(float weightBoundary)
    {
        String[] containersUnder = null;
        int counter = 0;
        int i = 0;       

        for(i = 0; i < containers.length; i++)
        {
            if(containers[i] == null)
                i = i;
            else if(containers[i].getWeight() < weightBoundary)
                counter++;
        }

        if(counter > 0)
        {
            containersUnder = new String[counter];
            i = 0;
            counter = 0;        

            while(i < containersUnder.length)
            {
                if(containers[i] == null)
                    i = i;
                else if(containers[i].getWeight() < weightBoundary)
                    containersUnder[counter++] = containers[i].getID();
                    
                i++;
            }
        }

        return containersUnder;
    }
    
    private int findAvailabePosition()
    {
        int position = 0;
        
        while(containers[position] != null)
            position++;
            
        return position;
    }
}
