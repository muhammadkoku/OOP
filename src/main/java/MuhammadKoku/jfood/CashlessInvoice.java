package MuhammadKoku.jfood;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
public class CashlessInvoice extends Invoice
{
        private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
        private Promo promo;


    /**
     * Constructor for objects of class CashlessInvoice
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
       super(id, foods, customer);
       
    }
    
       
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo)
    {
       super(id, foods, customer);
       this.promo = promo;
    }
    @Override
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
    @Override
    public void setTotalPrice()
    {
        super.totalPrice=0;
        for(Food foodList : getFoods())
        {
            super.totalPrice=super.totalPrice+foodList.getPrice();
        }
        if(promo!=null&&promo.getActive()==true&&super.totalPrice>=promo.getMinPrice())
        {
            super.totalPrice=super.totalPrice-promo.getDiscount();
        }
        else super.totalPrice=super.totalPrice;
    }

    @Override
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String foods = "";
        for(Food foodList : getFoods())
        {
            foods = foods + foodList.getName() + ", ";
        }
        foods = foods.substring(0, foods.length() - 2);
        String date = sdf.format(getDate().getTime());
        if (getPromo() != null && getPromo().getActive() == true)
        {

            return "\n================Invoice================" + "\n" +
                    "ID: " + super.getId() + "\n" +
                    "Name: " + foods + "\n" +
                    "Date: " + date + "\n" +
                    "Customer: " + super.getCustomer().getName() + "\n" +
                    "Promo: " + getPromo().getCode() + "\n" +
                    "Total Price: " + totalPrice + "\n" +
                    "Status: " + super.getInvoiceStatus() + "\n" +
                    "Payment Type: " + getPaymentType() + "\n";


        }
        else
        {

            return "\n================Invoice================" + "\n" +
                    "ID: " + super.getId() + "\n" +
                    "Name: " + foods + "\n" +
                    "Date: " + date + "\n" +
                    "Customer: " + super.getCustomer().getName() + "\n" +
                    "Total Price: " + totalPrice + "\n" +
                    "Status: " + super.getInvoiceStatus() + "\n" +
                    "Payment Type: " + getPaymentType() + "\n";

        }

    }
}

