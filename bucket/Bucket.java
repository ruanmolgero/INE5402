
public class Bucket
{
    int capacity;
    int actualVolume;

    public Bucket(int capacity)
    {
        this.capacity = capacity;
        this.actualVolume = 0;
    }
    
    public void fillBucket()
    {
        this.actualVolume = this.capacity;
    }
    
    public void emptyBucket()
    {
        this.actualVolume = 0;
    }
    
    public boolean isFull()
    {        
        return this.actualVolume == this.capacity;
    }
    
    public boolean isEmpty()
    {
        return this.actualVolume == 0;
    }
    
    public int getActualVolume()
    {
        return this.actualVolume;
    }
    
    public void receiveContent(Bucket anotherBucket)
    {
        if(this.actualVolume < this.capacity && anotherBucket.getActualVolume() != 0)
        {
            while(this.actualVolume < this.capacity && anotherBucket.getActualVolume() > 0)
            {
                this.actualVolume++;
                anotherBucket.actualVolume--;
            }
        }
    }
    /*
    public void transferContent(Bucket anotherBucket)
    {
        if(anotherBucket.getActualVolume() < anotherBucket.capacity && this.getActualVolume() != 0)
        {
            while(anotherBucket.actualVolume < anotherBucket.capacity && this.getActualVolume() > 0)
            {
                anotherBucket.actualVolume++;
                this.actualVolume--;
            }
        }
    }
    */
    
    public void transferContent(Bucket anotherBucket)
    {
        anotherBucket.receiveContent(this);
    }
            
    
    /* CLASS IMPLEMENTATIONS */
    /*
    public int fillBucket2()                            //alternative method to fill the bucket
    {
        int result;
        
        result = this.capacity - this.actualVolume;
        this.fillBucket();
        
        return result;
    }
    */
    /*
    public int emptyBucket2()
    {
        int result = this.actualVolume;                 //can actually be implemented by only using actualVolume;
        
        this.emptyBucket();        
        return result;        
    }
    */
   
    /* TEACHER IMPLEMENTATIONS */
    /*
    public void receiveContent(Bucket anotherBucket)
    {
        int availableVolumeThis = this.capacity - this.actualVolume;
        
        if(availableVolumeThis >= anotherBucket.capacity)
        {
            this.actualVolume = this.actualVolume + anotherBucket.capacity;
            anotherBucket.actualVolume = 0;
        }
        else
        {
            this.actualVolume = this.capacity;
            anotherBucket.actualVolume = anotherBucket.actualVolume - availableVolumeThis;
        }
    }
    */
}
