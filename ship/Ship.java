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

    int actualCarrying;
    int maxWeight;
    int actualWeight;
    Container[] containers;

    public Ship(int maxCapacity, int maxWeight)
    {
        this.maxWeight = maxWeight;
        containers = new Container[maxCapacity];
        actualCarrying = 0;
        actualWeight = 0;
    }

    public int getMaxCapacity()
    {
        return containers.length;
    }

    public int getMaxWeight()
    {
        return this.maxWeight;
    }

    public int getActualCarrying()
    {
        return actualCarrying;
    }

    public int getActualWeight()
    {
        return actualWeight;
    }

    public boolean loadContainer(Container ctnr)
    {
        boolean ableToLoad;

        ableToLoad = (this.getActualCarrying() == containers.length || 
                      this.getActualWeight() + ctnr.getWeight() > this.maxWeight ||
                      !this.isCarrying(ctnr.getID()));

        if(ableToLoad)
        {
            containers[findAvailabePosition()] = ctnr;
            this.actualCarrying++;
            this.actualWeight += ctnr.getWeight();
        }

        return ableToLoad;
    }

    public Container unloadContainer(String ID)
    {
        int ctnrPosition;
        Container container = null;

        ctnrPosition = findIDPosition(ID);

        if(ctnrPosition != -1)
        {
            container = new Container(containers[ctnrPosition].getID(), containers[ctnrPosition].getWeight());
            containers[ctnrPosition] = null;
            this.actualCarrying--;
            this.actualWeight -= container.getWeight();
        }

        return container;
    }

    public boolean isCarrying(String ID)
    {
        return this.findIDPosition(ID) != -1;
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

    private int findIDPosition(String ID)
    {
        int position = -1;
        int i = 0;
        int foundQuantity = 0;
        
        while(position == -1 && foundQuantity < this.actualCarrying)
        {
            while(containers[i] == null)
                i++;
                
            foundQuantity++;
                
            if(containers[i].getID() == ID)
                position = i;
            else
                i++;
        }
        
        return position;
    }
    
    private int findAvailabePosition()
    {
        int position = 0;

        while(containers[position] != null)
            position++;

        return position;
    }
}
