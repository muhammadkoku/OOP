import java.util.Calendar;
import java.text.SimpleDateFormat;
public class CashlessInvoice extends Invoice
{
        private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
        private Promo promo;
        private Calendar dueDate;
    
    /**
     * Constructor for objects of class CashlessInvoice
     */
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus)
    {
       super(id, food, customer, invoiceStatus);
       
    }
    
       
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
       super(id, food, customer, invoiceStatus);
       this.promo = promo;
       this.dueDate = Calendar.getInstance();
       this.dueDate.add(Calendar.DATE, +1);
    }
    
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    public Promo getPromo()
    {
        return promo;
    }
    
    public void setPromo(Promo promo)
    {
        this.promo = promo;
    }
    
    public void setTotalPrice()
    {
        if (promo != null && getFood().getPrice() >= promo.getMinPrice() && promo.getActive() == true)
        {super.totalPrice = getFood().getPrice() - promo.getDiscount();
        }
        else 
        {super.totalPrice = getFood().getPrice();
        }
    }
    
    
    public String toString()
    {
     SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
     String date = format1.format(getDate().getTime());
     String string = "";
       if ( promo == null || promo.getActive() == false || getFood().getPrice() < promo.getMinPrice())
      {string = "==========INVOICE==========\n"
                +"ID: "+ super.getId()
                +"\nFood: "+ super.getFood().getName()
                +"\nDate: "+ date
                +"\nCustomer: "+ super.getCustomer().getName()
                +"\nTotal Price: "+ super.totalPrice
                +"\nStatus: "+ super.getInvoiceStatus()
                +"\nPayment Type: "+ PAYMENT_TYPE;
       }
       else
       {string = "==========INVOICE==========\n"
                +"ID: "+ super.getId()
                +"\nFood: "+ super.getFood().getName()
                +"\nDate: "+ date
                +"\nCustomer: "+ super.getCustomer().getName()
                +"\nPromo: "+ promo.getCode()
                +"\nTotal Price: "+ super.totalPrice
                +"\nStatus: "+ super.getInvoiceStatus()
                +"\nPayment Type: "+ PAYMENT_TYPE;
       }
       System.out.println(string);
       return string;
    }
}

