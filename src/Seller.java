/**
 * @author Muhammad Koku
 * @version 2020-02-27
 */
public class Seller
{
    /**
     * The variable for class Location
     */
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    /**
     * Constructor for objects in class Seller
     * 
     * @param id (seller's id)
     * @param name (seller's name)
     * @param email (seller's email address)
     * @param phoneNumber (seller's phone number)
     * @param location (seller's location)
     */
    public Seller(int id, String name, String email, String phoneNumber, Location location)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }
    
     /**
     * Gets the seller's id
     *
     * @return id
     */
    public int getId()
    {
        return 0;
    }
    /**
     * Gets the seller's name
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }
    /**
     * Gets the seller's email
     *
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * Gets the seller's phone number
     *
     * @return phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    /**
     * Gets the seller's location
     *
     * @return location
     */
    public Location getLocation()
    {
        return location;
    }
    /**
     * Sets the seller's id
     * 
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * Sets the seller's name
     * 
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * Sets the seller's email
     * 
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
     * Sets the seller's phone number
     * 
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    /**
     * Sets the seller's location
     * 
     * @param location
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    /**
     * To print out (printData)
     * 
     * @param name
     */
    public String toString()
    {
        return "==========SELLER==========\nId: "+id+"\nNama: "+name+"\nPhone Number: "+phoneNumber+"\nLocation: "+location;
        
    }
    
    
}
