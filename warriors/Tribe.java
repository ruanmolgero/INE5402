public class Tribe
{
    /*
     *              NOTES
     * 1 - Implement using 2 arrays instead of only one, one array for the alive warriors, and one for the dead warriors.
     */
    
    String name;
    int maxWarriorHP;
    int existingAlive;
    int existingDead;
    Warrior[] warriors;
    
    public Tribe(String name, int maxWarriors, int maxWarriorHP)
    {
        this.name = name;
        this.maxWarriorHP = maxWarriorHP;
        this.existingAlive = 0;
        this.existingDead = 0;
        this.warriors = new Warrior[maxWarriors];
    }

    public String getName()
    {
        return this.name;
    }
    
    public int getAlive()
    {
        return existingAlive;
    }
    
    public int getDead()
    {
        return existingDead;
    }
    
    public int getExistingWarriors()
    {
        return existingAlive + existingDead;
    }
    
    public int getMaxWarriors()
    {
        return warriors.length;
    }
    
    public int addWarrior(String ID)
    {
        int ableToAdd;
        final int OK_ADDED = 0;
        final int NOK_EXISTS = 1;
        final int NOK_TRIBE_FULL = 2;
        
        if(this.getExistingWarriors() == this.getMaxWarriors())
            ableToAdd = NOK_TRIBE_FULL;
        else if(this.findWarriorPosition(ID))
            ableToAdd = NOK_EXISTS;
        else
            
        return ableToAdd;
    }
    
    private int findWarriorPosition(String ID)
    {
        int warriorPosition = -1;
        int foundWarriors = 0;
        int existingWarriors = this.getExistingWarriors();
        int i = 0;
        
        while(warriorPosition == -1 && i < existingWarriors)
        {
            while(warriors[i] == null)
                i++;
                
            foundWarriors++;
                
            if(warriors[i].getID() == ID)
                warriorPosition = i;
            else
                i++;
        }
        
        return warriorPosition;
    }
}
