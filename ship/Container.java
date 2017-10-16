public class Container
{
    private String ID;
    private float weight;

    public Container(String ID, float weight)
    {
        this.ID = ID;
        this.weight = weight;
    }
    
    public String getID()
    {
        return this.ID;
    }
    
    public float getWeight()
    {
        return this.weight*1.0f;
    }
}
