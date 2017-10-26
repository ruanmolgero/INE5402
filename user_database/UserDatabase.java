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
        int i = 0;
        User[] usersTemp = users;
        users = new User[usersTemp.length + capacityIncrement];

        while(i < usersTemp.length)
        {
            users[i] = usersTemp[i];
            i++;
        }
    }

    private void decreaseSizeByMinimum()
    {
        int i = 0;
        int j = 0;
        User[] usersTemp = users;
        users = new User[usersTemp.length - capacityIncrement];

        while(i < usersTemp.length)
        {
            if(usersTemp[i] != null)
                users[j++] = usersTemp[i];

            i++;
        }
    }
}
