import java.util.ArrayList;
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
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
       super(id, foods, customer);
       
    }
    
       
    public CashlessInvoice(int id, ArrayList<Food> foods, String date, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
       super(id, foods, customer);
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
        int foodPrice=0;
        for(int i = 0; i < super.getFoods().size(); i++){
            foodPrice+=super.getFoods().get(i).getPrice();
        }
        if(promo!=null&&promo.getActive()==true&&foodPrice>promo.getMinPrice())
        {
            super.totalPrice=foodPrice-promo.getDiscount();
        }
        else super.totalPrice=foodPrice;
    }


    public String toString()
    {
        int tempPrice = 0;
        String foodName = "";
        for (Food food : getFoods())
        {
            tempPrice += food.getPrice();
            foodName += food.getName() + ", ";
        }
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String date = format1.format(getDate().getTime());
        if (getPromo() != null && getPromo().getActive() == true && tempPrice > getPromo().getMinPrice())
        {

            return "\n================Invoice================" + "\n" +
                    "ID: " + getId() + "\n" +
                    "Name: " + foodName + "\n" +
                    "Date: " + date + "\n" +
                    "Customer: " + getCustomer().getName() + "\n" +
                    "Promo: " + getPromo().getCode() + "\n" +
                    "Total Price: " + totalPrice + "\n" +
                    "Status: " + getInvoiceStatus() + "\n" +
                    "Payment Type: " + getPaymentType() + "\n";


        }
        else
        {

            return "\n================Invoice================" + "\n" +
                    "ID: " + getId() + "\n" +
                    "Name: " + foodName + "\n" +
                    "Date: " + date + "\n" +
                    "Customer: " + getCustomer().getName() + "\n" +
                    "Total Price: " + totalPrice + "\n" +
                    "Status: " + getInvoiceStatus() + "\n" +
                    "Payment Type: " + getPaymentType() + "\n";

        }

    }
}

