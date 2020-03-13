
public class Jfood 
{
    public static void main (String []args)
    {
        Location locationObj = new Location("Serang", "Banten", "lokasi");
        Seller sellerObj = new Seller(1, "Muhammad Koku", "muhammad.koku@ui.ac.id", "082292307525", locationObj);
        Food foodObj =  new Food(101, "Ayam Bakar", sellerObj, 30000, FoodCategory.Snacks);
        Food foodObj1 =  new Food(102, "Cappucino", sellerObj, 10000, FoodCategory.Coffee);
        
        Customer customerObj = new Customer (432, "Alwan", "alwan.fadhil@gmail.com", "alwan123", "20-02-2020");
        CashInvoice cashObj = new CashInvoice (1,foodObj, "12,03,2020", customerObj, InvoiceStatus.Ongoing);
        CashInvoice cashObj1 = new CashInvoice (2,foodObj1, "12,03,2020", customerObj, InvoiceStatus.Ongoing, 10000);
         
        
        cashObj.setTotalPrice();
        cashObj1.setTotalPrice();
        
        
        cashObj.printData();
        cashObj1.printData();
        
        
      
        
        
        
        
    }

   
    }

