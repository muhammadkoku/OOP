/**
 * @author Muhammad Koku
 * @version 2020-02-27
 */
public class Customer
{
    /**
     * The variable for class Customer
     */
    private int id;
    private String name;
    private String email;
    private String joinDate;
    private String password;

     /**
     * Constructor for objects in class Customer
     * 
     * @param id (customer's id)
     * @param name (customer's name)
     * @param email (customer's email)
     * @param password (customer's password)
     * @param joinDate (customer's join date)
     */
    public Customer(int id, String name, String email, String password, String joinDate)
    {
        this.id =  id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }

    /**
     * Gets the customer's id
     *
     * @return id
     */
    
    public int getId()
    {
        return id;
    }
     /**
     * Gets the customer's name
     *
     * @return name
     */
    
    public String getName()
    {
        return name;
    }
    /**
     * Gets the customer's email
     *
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * Gets the customer's password
     *
     * @return password
     */
    public String getPassword()
    {
        return password;
    }
    /**
     * Gets the customer's join date
     *
     * @return joinDate
     */
    public String getJoinDate()
    {
        return joinDate;
    }
    /**
     * Sets the customer's id
     * 
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * Sets the customer's name
     * 
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * Sets the customer's email
     * 
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
     * Sets the customer's password
     * 
     * @param password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    /**
     * Sets the customer's join date
     * 
     * @param joinDate
     */
    public void setJoinDate(String joinDate)
    {
        this.joinDate = joinDate;
    }
    /**
     * To print out (printData)
     * 
     * @param name
     */
     public void printData()
    {
        System.out.println(name);
    }
}
