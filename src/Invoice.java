/**
 * @author Muhammad Koku
 * @version 2020-02-27
 */
import java.util.Calendar;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class Invoice
{
   /**
     * The variable for class Invoice
     */
    private int id;
    private ArrayList<Food> foods=new ArrayList<Food>();
    private Calendar date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoiceStatus;
    
    /**
     * Constructor for objects in class Invoice
     * 
     * @param id (invoice's id)
     * @param customer (invoice's customer)
     */

    public Invoice(int id, ArrayList<Food> foods, Customer customer)
    {
       this.id = id;
       this.foods = foods;
       this.date = Calendar.getInstance();
       this.customer = customer;

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
    public ArrayList<Food> getFoods()
    {
        return foods;
    }
    /**
     * Gets the invoice's date
     *
     * @return date
     */
    public Calendar getDate()
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
     * Gets the invoice's payment type
     *
     * @return paymenType
     */
    public abstract PaymentType getPaymentType();
    
    /**
     * Gets the invoice's status
     *
     * @return status
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
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
     *
     */
     public void setFoods(ArrayList<Food> foods)
    {
        this.foods = foods;
    }

    public void setDate(int year, int month, int dayOfMonth)
    {
        this.date = new GregorianCalendar(year, month-1, dayOfMonth);
    }
    /**
     * Sets the invoice's total price
     * 
     *
     */
    public abstract void setTotalPrice();
    
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
     * Sets the invoice's status
     * 
     *
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }
     /**
     * To print out (printData)
     * 
     *
     */
    public abstract String toString();
    
    
   
    
}
