/**
 * @author Muhammad Koku
 * @version 2020-02-27
 */
public class Invoice
{
   /**
     * The variable for class Invoice
     */
    private int id;
    private int idFood;
    private String date;
    private int totalPrice;
    private Customer customer;
    
    /**
     * Constructor for objects in class Invoice
     * 
     * @param id (invoice's id)
     * @param idFood (invoice's food id)
     * @param date (invoice's date)
     * @param totalprice (invoice's total price)
     * @param customer (invoice's customer)
     */
    public Invoice(int id, int idFood, String date, Customer customer, int totalPrice)
    {
       this.id = id;
       this.idFood = idFood;
       this.date = date;
       this.customer = customer;
       this.totalPrice = totalPrice;
    }

    /**
     * Gets the invoice's id
     *
     * @return id
     */
    public int getId()
    {
        return id;
    }
    /**
     * Gets the invoice's food id
     *
     * @return idFood
     */
    public int getIdFoods()
    {
        return idFood;
    }
    /**
     * Gets the invoice's date
     *
     * @return date
     */
    public String getDate()
    {
        return date;
    }
    /**
     * Gets the invoice's total price
     *
     * @return totalPrice
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }
    /**
     * Gets the invoice's customer
     *
     * @return customer
     */
    public Customer getCustomer()
    {
        return customer;
    }
    /**
     * Sets the invoice's id
     * 
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * Sets the invoice's food id
     * 
     * @param idFood
     */
     public void setIdFood(int idFood)
    {
        this.idFood = idFood;
    }
    /**
     * Sets the invoice's date
     * 
     * @param date
     */
    public void setDate(String date)
    {
        this.date = date;
    }
    /**
     * Sets the invoice's total price
     * 
     * @param totalPrice
     */
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    /**
     * Sets the invoice's customer
     * 
     * @param customer
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
     /**
     * To print out (printData)
     * 
     * @param idFood
     */
    public void printData()
    {
        System.out.println(idFood);
    }
    
}
