/**
 * @author Muhammad Koku
 * @version 2020-02-27
 */

public class Location
{
    /**
     * The variable for class Location
     */
    private String province;
    private String description;
    private String city;
   
    /**
     * Constructor for objects in class Location
     * 
     * @param province
     * @param description
     * @param city
     */
    
    public Location(String city, String province, String description)
    {
     this.city = city;
     this.description = description;
     this.province = province;
    }
    /**
     * Gets the province of location
     *
     * @return province
     */
    public String getProvince()
    {
        return province;
    }
    /**
     * Gets the city of location
     *
     * @return city
     */
    public String getCity()
    {
        return city;
    }
    /**
     * Gets the description of location
     *
     * @return description
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * Sets the province of the location
     * 
     * @param province
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    /**
     * Sets the city of the location
     * 
     * @param city
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    /**
     * Sets the description of the location
     * 
     * @param province
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    /**
     * To print out (printData)
     * 
     * @param province
     */
    public void printData()
    {
        System.out.println(province);
    }
    
    public String toString()
    {
        return "==========LOCATION==========\nProvince: "+province+"\nCity: "+city+"\nDescription: "+description;
        
    }
    
}
