/**
 * @author Muhammad Koku
 * @version 2020-02-27
 */
import java.util.*; 
import java.util.regex.*;
import java.text.SimpleDateFormat;
public class Customer
{
    /**
     * The variable for class Customer
     */
    private int id;
    private String name;
    private String email;
    private Calendar joinDate;
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
    public Customer(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id =  id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    
    public Customer(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        this.id =  id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = new GregorianCalendar(year, month-1, dayOfMonth);
    }
    
    public Customer(int id, String name, String email, String password)
    {
        this.id =  id;
        this.name = name;
        this.email = email;
        this.password = password;
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
    public Calendar getJoinDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        String joinString = sdf.format(joinDate.getTime());
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
        String pattern =  "^[a-zA-Z0-9_+&*-]+(?:\\."+  
                            "[a-zA-Z0-9_+&*-]+)*@" +  
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +  
                            "A-Z]{2,7}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        if (m.find()) {
            System.out.println("Email : " + m.group());
            this.email = email;
        } else {
            System.out.println("Email : NULL");
            this.email = "NULL";
        }
    }
    
    
    /**
     * Sets the customer's password
     * 
     * @param password
     */
    public void setPassword(String password)
    {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        if(m.find()){
            System.out.println("Password: " + m.group());
            this.password = password;
        }else{
            System.out.println("Password: NULL");
            this.password = "NULL";
        }
    }
    /**
     * Sets the customer's join date
     * 
     * @param joinDate
     */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }
    
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        this.joinDate = new GregorianCalendar(year, month-1, dayOfMonth);
    }
    
    public String toString()
    {
        return "==========CUSTOMER==========\nId: "+id+"\nNama: "+name+"\nEmail: "+email+"\nPassword: "+password+"nJoin Date: "+joinDate;
        
    }
}
