package MuhammadKoku.jfood;

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
    
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer,  int deliveryFee)
    {
       super(id, foods, customer);
       this.deliveryFee = deliveryFee;

    }
    @Override
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

    @Override
    public void setTotalPrice()
    {
        super.totalPrice=0;
        for(Food foodList : getFoods())
        {
            super.totalPrice=super.totalPrice+foodList.getPrice();
        }
        super.totalPrice=super.totalPrice+deliveryFee;
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
        return "==========INVOICE=========="
                 +"\nID :" + super.getId()
                 +"\nFood :" + foods
                 +"\nDate :" + sdf.format(super.getDate().getTime())
                 +"\nCustomer :" + super.getCustomer().getName()
                 +"\nDelivery Fee:" + getDeliveryFee()
                 +"\nTotal price :" + totalPrice
                 +"\nStatus :" + super.getInvoiceStatus()
                 +"\nPayment Type :" + getPaymentType();
    }
}