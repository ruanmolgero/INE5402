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
        return (this.registeredUsers*1.0f/users.length);
    }

    public boolean addUser(String userName, String userLogin, String userPassword)
    {
        boolean ableToAdd = this.findUser(userLogin) == -1;

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

            if(this.getActualOccupationRate() < this.minimumOccupationRate && users.length > minimumCapacity)
                this.decreaseSizeByMinimum();
        }

        return ableToRemove;
    }

    public boolean changePassword(String userLogin, String oldPassword, String newPassword)
    {
        boolean ableToChange;
        int position = findUser(userLogin);

        if(position == -1 || users[position].getPassword() != oldPassword)
            ableToChange = false;
        else
        {
            users[position].setPassword(newPassword);
            ableToChange = true;
        }

        return ableToChange;
    }

    public User returnUser(String userLogin)
    {
        int position = findUser(userLogin);
        User user;

        if(position == -1)
            user = null;
        else
            user = new User(users[position].getName(), users[position].getLogin(), users[position].getPassword());

        return user;
    }

    public User returnUser(String userLogin, String userPassword)
    {
        int position = findUser(userLogin);
        User user;

        if(position == -1 || users[position].getPassword() != userPassword)
            user = null;
        else
            user = new User(users[position].getName(), users[position].getLogin(), users[position].getPassword());

        return user;
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

        while(users[position] != null)
            position++;

        return position;
    }

    private void increaseSizeByMinimum()
    {
        User[] usersTemp = users;
        users = new User[usersTemp.length + capacityIncrement];

        for(int i = 0; i < usersTemp.length; i++)
            users[i] = usersTemp[i];
    }

    private void decreaseSizeByMinimum()
    {
        int i = 0;
        User[] usersTemp = users;
        if(registeredUsers > minimumCapacity)
            users = new User[registeredUsers];
        else
            users = new User[minimumCapacity];
            
        for(int k = 0; k < registeredUsers; k++)
        {
            while(usersTemp[i] == null)
                i++;
                
            users[k] = usersTemp[i];
            i++;
        }
    }
}

