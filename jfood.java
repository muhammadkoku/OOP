
public class Jfood 
{
    public static void main (String []args)
    {
        Location locationObj = new Location("Serang", "Banten", "lokasi");
        Seller sellerObj = new Seller(1, "Muhammad Koku", "muhammad.koku@ui.ac.id", "082292307525", locationObj);
        Food foodObj =  new Food(101, "Ayam Bakar", sellerObj, 30000, FoodCategory.Snacks);
        Food foodObj1 =  new Food(102, "Cappucino", sellerObj, 10000, FoodCategory.Coffee);
        Food foodObj2 =  new Food(103, "Fanta", sellerObj, 15000, FoodCategory.Beverages);
        Customer customerObj = new Customer (432, "Alwan", "alwan.fadhil@gmail.com", "alwan123", "20-02-2020");
        Promo promoObj = new Promo (99, "GFJKT", 5000, 15000, true);
        CashlessInvoice cashlessObj = new CashlessInvoice (1,foodObj, "12,03,2020", customerObj, InvoiceStatus.Ongoing);
        CashlessInvoice cashlessObj1 = new CashlessInvoice (2,foodObj1, "12,03,2020", customerObj, InvoiceStatus.Ongoing, promoObj);
        CashlessInvoice cashlessObj2 = new CashlessInvoice (3,foodObj2, "12,03,2020", customerObj, InvoiceStatus.Ongoing, promoObj); 
        
        cashlessObj.setTotalPrice();
        cashlessObj1.setTotalPrice();
        cashlessObj2.setTotalPrice();
        
        cashlessObj.printData();
        cashlessObj1.printData();
        cashlessObj2.printData();
        
      
        
        
        
        
    }

   
    }

