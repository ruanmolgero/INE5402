public class User
{
    String name;
    String login;
    String password;

    public User(String name, String login, String password)
    {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName()
    {
        return this.name;
    }

    public String getLogin()
    {
        return this.login;
    }

    public String getPassword()
    {
        return this.password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public User cloneUser()
    {
        return new User(this.name, this.login, this.password);
    }
}
