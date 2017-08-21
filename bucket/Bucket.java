
public class Bucket
{
    int capacity;
    int actualVolume;

    public Bucket(int capacity)
    {
        this.capacity = capacity;
        actualVolume = 0;
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
}
