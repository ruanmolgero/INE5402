public class Warrior
{
    /*
     *                  NOTES
     * 1 - Implement using alive as an atribute.
     */
    
    String ID;
    final int MAXHP;
    int actualHP;

    public Warrior(String ID, int maxHP)
    {
        this.ID = ID;
        this.MAXHP = maxHP;
        this.actualHP = MAXHP;
    }

    private Warrior(String ID, int maxHP, int actualHP)
    {
        this.ID = ID;
        this.MAXHP = maxHP;
        this.actualHP = actualHP;
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
        return actualHP > 0;
    }

    public void increaseHP()
    {
        if(this.actualHP < MAXHP)
            this.actualHP++;
    }

    public void decreaseHP()
    {
        if(this.actualHP > 0)
            this.actualHP--;
    }

    public Warrior cloneWarrior()
    {
        return new Warrior(this.getID(), this.MAXHP, this.getActualHP());
    }
}
