
import java.util.Calendar;
public class CashInvoice extends Invoice
{
    
     private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
     private int deliveryFee;
     

   
    public CashInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus)
    {
       super(id, food, customer, invoiceStatus);      
    }
    
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, int deliveryFee)
    {
       super(id, food, customer, invoiceStatus);
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
    
    
    public String toString()
    {
        String string = "";
        string = "==========INVOICE=========="
                 +"\nID :" + super.getId()
                 +"\nFood :" + super.getFood().getName()
                 +"\nDate :" + super.getDate()
                 +"\nCustomer :" + super.getCustomer().getName()
                 +"\nDelivery Fee:" + deliveryFee
                 +"\nTotal price :" + super.totalPrice
                 +"\nStatus :" + super.getInvoiceStatus()
                 +"\nPayment Type :" + PAYMENT_TYPE;
        return string;
    }
}