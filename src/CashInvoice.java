
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class CashInvoice extends Invoice
{
    
     private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
     private int deliveryFee;
     

   
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer )
    {
       super(id, foods, customer);
    }
    
    public CashInvoice(int id, ArrayList<Food> foods, String date, Customer customer,  int deliveryFee)
    {
       super(id, foods, customer);
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
        int foodPrice=0;
        if (deliveryFee != 0 )
        {
            for(int i = 0; i < super.getFoods().size(); i++)
            {
                foodPrice+=super.getFoods().get(i).getPrice();
            }
            super.totalPrice = foodPrice + deliveryFee;
        }
        else {
            for (int i = 0; i < super.getFoods().size(); i++) {
                foodPrice += super.getFoods().get(i).getPrice();
            }
            super.totalPrice = foodPrice;
        }
    }
    
    
    public String toString()
    {   
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String date = format1.format(getDate().getTime());
        
        String string = "";
        string = "==========INVOICE=========="
                 +"\nID :" + super.getId()
                 +"\nFood :" + super.getFoods()
                 +"\nDate :" + date
                 +"\nCustomer :" + super.getCustomer().getName()
                 +"\nDelivery Fee:" + deliveryFee
                 +"\nTotal price :" + super.totalPrice
                 +"\nStatus :" + super.getInvoiceStatus()
                 +"\nPayment Type :" + PAYMENT_TYPE;
        System.out.println(string);
        return string;
    }
}