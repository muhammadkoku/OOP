
public class Jfood 
{

    public static void main (String []args)
    {
        Location locationObj = new Location("Serang", "Banten", "lokasi");
        Seller sellerObj = new Seller(1, "a", "b", "c", locationObj);
        Food foodObj =  new Food(12, "e", sellerObj, 20, "f");
        Customer customerObj = new Customer (10, "g", "h", "i", "k");
        Invoice invoiceObj = new Invoice (14, 14, "l", customerObj, 20); 
               
        locationObj.printData();
        sellerObj.printData();
        foodObj.printData();
        customerObj.printData();
        invoiceObj.printData();
      
        
        
        
        
    }

   
    }

