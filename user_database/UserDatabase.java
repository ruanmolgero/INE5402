public class UserDatabase
{   
    int minimumCapacity;
    int capacityIncrement;
    float minimumOccupationRate;
    int registeredUsers;
    User[] users;

    public UserDatabase(int minimumCapacity, int capacityIncrement, float minimumOccupationRate)
    {
        this.minimumCapacity = minimumCapacity;
        this.capacityIncrement = capacityIncrement;
        this.minimumOccupationRate = minimumOccupationRate;
        this.registeredUsers = 0;
        users = new User[this.minimumCapacity];
    }

    public int getRegisteredNumber()
    {
        return this.registeredUsers;
    }
    
    public float getActualOccupationRate()
    {
        return this.registeredUsers / users.length * 1.00f;
    }

    public boolean addUser(String userName, String userLogin, String userPassword)
    {
        boolean ableToAdd = this.findUser(userName) != -1;

        if(ableToAdd)
        {
            if(this.getRegisteredNumber() == users.length)
                this.increaseSizeByMinimum();
                
            int availablePosition = this.findAvailablePosition();
            users[availablePosition] = new User(userName, userLogin, userPassword);
            this.registeredUsers++;
        }

        return ableToAdd;
    }

    public boolean removeUser(String userLogin)
    {
        int userPosition = this.findUser(userLogin);
        boolean ableToRemove = userPosition != -1;

        if(ableToRemove)
        {
            users[userPosition] = null;
            this.registeredUsers--;
            
            if(getActualOccupationRate() < this.minimumOccupationRate && users.length > minimumCapacity)
                this.decreaseSizeByMinimum();
        }

        return ableToRemove;
    }

    private int findUser(String userLogin)
    {
        int position = -1;
        int foundUsers = 0;
        int i = 0;

        while(position == -1 && foundUsers < registeredUsers)
        {
            while(users[i] == null)
                i++;

            foundUsers++;
            if(users[i].getLogin() == userLogin)
                position = i;
            else
                i++;
        }

        return position;
    }

    private int findAvailablePosition()
    {
        int position = 0;

        while(users[position] == null)
            position++;

        return position;
    }

    private void increaseSizeByMinimum()
    {
        int i = 0;
        User[] usersTemp = users;
        users = new User[usersTemp.length + capacityIncrement];

        while(i < usersTemp.length)
            users[i] = usersTemp[i];
    }
    
    private void decreaseSizeByMinimum()
    {
        
    }
}
