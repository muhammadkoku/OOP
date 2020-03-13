

public class CashInvoice extends Invoice
{
    
     private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
     private int deliveryFee;
     

   
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus)
    {
       super(id, food, date, customer, invoiceStatus);      
    }
    
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, int deliveryFee)
    {
       super(id, food, date, customer, invoiceStatus);
       this.deliveryFee = deliveryFee;
    }
    
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    public int getDeliveryFee()
    {
        return deliveryFee;
    }
    
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }
    
    public void setTotalPrice()
    {
        if (deliveryFee != 0 )
        {super.totalPrice = getFood().getPrice() + deliveryFee;
        }
        else 
        {super.totalPrice = getFood().getPrice();
        }
    }
    
    public void printData()
    {  System.out.println("==========INVOICE==========");
       System.out.println("ID :" + super.getId());
       System.out.println("Food :" + super.getFood().getName());
       System.out.println("Date :" + super.getDate());
       System.out.println("Customer :" + super.getCustomer().getName());
       System.out.println("Delivery Fee:" + deliveryFee);
       System.out.println("Total price :" + super.totalPrice);
       System.out.println("Status :" + super.getInvoiceStatus());
       System.out.println("Payment Type :" + PAYMENT_TYPE);
    }
    
}