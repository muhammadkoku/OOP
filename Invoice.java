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
    private PaymentType paymentType;
    private InvoiceStatus status;
    
    /**
     * Constructor for objects in class Invoice
     * 
     * @param id (invoice's id)
     * @param idFood (invoice's food id)
     * @param date (invoice's date)
     * @param totalprice (invoice's total price)
     * @param customer (invoice's customer)
     */
    public Invoice(int id, int idFood, String date, Customer customer, int totalPrice, InvoiceStatus status)
    {
       this.id = id;
       this.idFood = idFood;
       this.date = date;
       this.customer = customer;
       this.totalPrice = totalPrice;
       this.status = status;
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
     * Gets the invoice's payment type
     *
     * @return paymenType
     */
    public PaymentType getPaymentType()
    {
        return paymentType;
    }
    /**
     * Gets the invoice's status
     *
     * @return status
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return status;
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
     * Sets the invoice's payment type
     * 
     * @param paymentType
     */
    public void setPaymentType(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
    /**
     * Sets the invoice's status
     * 
     * @param status
     */
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.status = status;
    }
     /**
     * To print out (printData)
     * 
     * @param idFood
     * @param totalPrice
     */
    public void printData()
    {
        System.out.println("============INVOICE============");
        System.out.println("ID:"+id);
        System.out.println("Date:"+ date);
        System.out.println("Customer:"+customer.getName());
        System.out.println("Total Price:"+totalPrice);
        System.out.println("Status:"+status);
    }
    
}
