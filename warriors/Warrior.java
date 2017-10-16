public class Warrior
{
    private String ID;
    private int maxHP;
    private int actualHP;
    private boolean alive;

    public Warrior(String ID, int maxHP)
    {
        this.ID = ID;
        this.maxHP = maxHP;
        this.actualHP = maxHP;
        this.alive = true;
    }

    public String getID()
    {
        return this.ID;
    }
    
    public int getActualHP()
    {
        return this.actualHP;
    }
    
    public boolean isAlive()
    {
        return this.alive;
    }
    
    public void increaseHP()
    {
        if(this.actualHP < this.maxHP)
            this.actualHP++;
    }
    
    public void decreaseHP()
    {
        if(this.actualHP > 0)
            this.actualHP--;
    }
    
    public void cloneWarrior()
    {
        Warrior newWarrior = new Warrior(this.ID, this.maxHP);
        
        newWarrior.actualHP = this.getActualHP();
        newWarrior.alive = this.alive;
    }
}
