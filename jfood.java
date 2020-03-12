
public class Jfood 
{
    public static void main (String []args)
    {
        Location locationObj = new Location("Serang", "Banten", "lokasi");
        Seller sellerObj = new Seller(1, "Muhammad Koku", "muhammad.koku@ui.ac.id", "082292307525", locationObj);
        Food foodObj =  new Food(12, "Ayam Bakar", sellerObj, 10000, FoodCategory.Snacks);
        Customer customerObj = new Customer (10, "Alwan", "alwan.fadhil@gmail.com", "alwan123", "20-02-2020");
        Promo promoObj = new Promo (99, "yuhuu", 5000, 9000, true);
        CashlessInvoice cashlessObj = new CashlessInvoice (
         
               
        
        invoiceObj.printData();
        
      
        
        
        
        
    }

   
    }

