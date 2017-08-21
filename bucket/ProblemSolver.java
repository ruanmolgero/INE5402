
public class ProblemSolver
{
    Bucket a = new Bucket(5);
    Bucket b = new Bucket(3);
    
    public void solveA() //Bucket firstBucket, Bucket secondBucket
    {
        a.fillBucket();
        b.receiveContent(a);
        b.emptyBucket();
        a.transferContent(b);
    }
    
    public void solveB()
    {
        b.fillBucket();
        a.receiveContent(b);
        b.fillBucket();
        a.receiveContent(b);
        a.emptyBucket();
        b.transferContent(a);
        b.fillBucket();
        b.transferContent(a);
    }
    
    /* TEACHER IMPLEMENTATIONS */
    /*
    public boolean solveA() //Bucket firstBucket, Bucket secondBucket
    {
        Bucket a = new Bucket(5);
        Bucket b = new Bucket(3);
        
        a.fillBucket();
        b.receiveContent(a);
        b.emptyBucket();
        a.transferContent(b);
        
        return b.getActualVolume() == 2;
    }
    */
   
   /*
   public void solveB()
    {
        Bucket a = new Bucket(5);
        Bucket b = new Bucket(3);
        
        b.fillBucket();
        a.receiveContent(b);
        b.fillBucket();
        a.receiveContent(b);
        a.emptyBucket();
        b.transferContent(a);
        b.fillBucket();
        b.transferContent(a);
        
        return a.getActualVolume() == 4;
    }
   */
}
 