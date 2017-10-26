public class Tribe
{
    String name;
    int tribeMaxHP;
    int aliveNumber;
    int deadNumber;
    Warrior[] aliveWarriors;
    Warrior[] deadWarriors;

    public Tribe(String name, int maxWarriors, int tribeMaxHP)
    {
        this.name = name;
        this.tribeMaxHP = tribeMaxHP;
        this.aliveNumber = 0;
        this.deadNumber = 0;
        this.aliveWarriors = new Warrior[maxWarriors];
        this.deadWarriors = new Warrior[maxWarriors];
    }

    public String getName()
    {
        return this.name;
    }

    public int getAlive()
    {
        return aliveNumber;
    }

    public int getDead()
    {
        return deadNumber;
    }

    public int getExistingWarriors()
    {
        return aliveNumber + deadNumber;
    }

    public int getMaxWarriors()
    {
        return aliveWarriors.length;
    }

    public int addWarrior(String ID)
    {
        int ableToAdd;
        final int OK_ADDED = 0;
        final int NOK_EXISTS = 1;
        final int NOK_TRIBE_FULL = 2;

        if(this.getExistingWarriors() == this.getMaxWarriors())
            ableToAdd = NOK_TRIBE_FULL;
        else if(this.findWarriorPosition(ID, aliveWarriors, aliveNumber) != -1 || this.findWarriorPosition(ID, deadWarriors, deadNumber) != -1)
            ableToAdd = NOK_EXISTS;
        else
        {
            int position = this.findAvailablePosition(aliveWarriors);
            aliveWarriors[position] = new Warrior(ID, this.tribeMaxHP);
            this.aliveNumber++;
            ableToAdd = OK_ADDED;
        }

        return ableToAdd;
    }

    public boolean removeWarrior(String ID)
    {
        boolean ableToRemove;

        final boolean OK_REMOVED = true;
        final boolean NOK_NO_WARRIOR = false;

        int position = findWarriorPosition(ID, aliveWarriors, aliveNumber);

        //if(position == -1)
        //    position = findWarriorPosition(ID, deadWarriors, deadNumber);

        if(position != -1)
        {
            aliveWarriors[position] = null;
            aliveNumber--;
            ableToRemove = OK_REMOVED;
        }
        else
        {
            position = findWarriorPosition(ID, deadWarriors, deadNumber);

            if(position != -1)
            {
                deadWarriors[position] = null;
                deadNumber--;
                ableToRemove = OK_REMOVED;
            }
            else
                ableToRemove = NOK_NO_WARRIOR;
        }

        return ableToRemove;
    }

    public boolean healWarrior(String ID)
    {
        boolean ableToHeal;
        int[] warriorPosition = findWarriorPositionInTribe(ID);

        final int ALIVE_ARRAY = 1;
        final int DEAD_ARRAY = 2;

        if(warriorPosition[0] == -1)
            ableToHeal = false;
        else if(warriorPosition[1] == ALIVE_ARRAY)
        {
            if(aliveWarriors[warriorPosition[0]].getActualHP() <= this.tribeMaxHP)
                aliveWarriors[warriorPosition[0]].actualHP++;

            ableToHeal = true;
        }
        else
        {
            int availablePosition = findAvailablePosition(aliveWarriors);
            deadWarriors[warriorPosition[0]].increaseHP();
            aliveWarriors[availablePosition] = deadWarriors[warriorPosition[0]].cloneWarrior();
            deadWarriors[warriorPosition[0]] = null;
            this.aliveNumber++;
            this.deadNumber--;
            ableToHeal = true;
        }

        return ableToHeal;
    }

    public boolean hurtWarrior(String ID)
    {
        boolean ableToHurt;
        int[] warriorPosition = findWarriorPositionInTribe(ID);

        final int ALIVE_ARRAY = 1;
        final int DEAD_ARRAY = 2;

        if(warriorPosition[0] == -1)
            ableToHurt = false;
        else if(warriorPosition[1] == DEAD_ARRAY)
        {
            deadWarriors[warriorPosition[0]].decreaseHP();
            ableToHurt = true;
        }
        else
        {
            if(aliveWarriors[warriorPosition[0]].getActualHP() > 1)
                aliveWarriors[warriorPosition[0]].decreaseHP();
            else
            {
                int availablePosition = findAvailablePosition(deadWarriors);
                aliveWarriors[warriorPosition[0]].decreaseHP();
                deadWarriors[availablePosition] = aliveWarriors[warriorPosition[0]].cloneWarrior();
                aliveWarriors[warriorPosition[0]] = null;
                this.deadNumber++;
                this.aliveNumber--;                
            }

            ableToHurt = true;
        }

        return ableToHurt;
    }

    public Warrior[] aliveWarriorsArray()
    {
        Warrior[] aliveWarriorsArray = new Warrior[aliveNumber];
        int foundWarriors = 0;
        int i = 0;

        while(foundWarriors < aliveNumber)
        {
            if(aliveWarriors[i] == null)
                i++;

            aliveWarriorsArray[foundWarriors] = aliveWarriors[i];
            foundWarriors++;
            i++;
        }

        return aliveWarriorsArray;
    }

    public Warrior[] deadWarriorsArray()
    {
        Warrior[] deadWarriorsArray = new Warrior[aliveNumber];
        int foundWarriors = 0;
        int i = 0;

        while(foundWarriors < deadNumber)
        {
            if(deadWarriors[i] == null)
                i++;

            deadWarriorsArray[foundWarriors] = deadWarriors[i];
            foundWarriors++;
            i++;
        }

        return deadWarriorsArray;
    }

    private int findAvailablePosition(Warrior[] warriorsArray)
    {
        int position = 0;

        while(warriorsArray[position] != null)
            position++;

        return position;
    }

    private int findWarriorPosition(String ID, Warrior[] warriorsArray, int warriorsNumber)
    {
        int warriorPosition = -1;
        int foundWarriors = 0;
        int i = 0;

        while(warriorPosition == -1 && foundWarriors < warriorsNumber)
        {
            while(warriorsArray[i] == null)
                i++;

            foundWarriors++;

            if(warriorsArray[i].getID() == ID)
                warriorPosition = i;
            else
                i++;
        }

        return warriorPosition;
    }

    private int[] findWarriorPositionInTribe(String ID)
    {
        int[] warriorPosition = new int[]{-1, 0};

        final int ALIVE_ARRAY = 1;
        final int DEAD_ARRAY = 2;

        int foundWarriors = 0;
        int i = 0;

        while(warriorPosition[0] == -1 && foundWarriors < aliveNumber)
        {
            while(this.aliveWarriors[i] == null)
                i++;

            foundWarriors++;

            if(this.aliveWarriors[i].getID() == ID)
            {
                warriorPosition[0] = i;
                warriorPosition[1] = ALIVE_ARRAY;
            }
            else
                i++;
        }

        foundWarriors = 0;
        i = 0;

        while(warriorPosition[0] == -1 && foundWarriors < deadNumber)
        {
            while(this.deadWarriors[i] == null)
                i++;

            foundWarriors++;

            if(this.deadWarriors[i].getID() == ID)
            {
                warriorPosition[0] = i;
                warriorPosition[1] = DEAD_ARRAY;
            }
            else
                i++;
        }

        return warriorPosition;
    }
}
