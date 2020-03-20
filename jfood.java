import java.util.*; 
import java.util.regex.*;
import java.text.SimpleDateFormat;

public class Jfood 
{
    public static void main (String []args)
    {
        Location locationObj = new Location("Serang", "Banten", "lokasi");
        Seller sellerObj = new Seller(1, "Muhammad Koku", "muhammad.koku@ui.ac.id", "082292307525", locationObj);
        Food foodObj =  new Food(101, "Ayam Bakar", sellerObj, 30000, FoodCategory.Snacks);
        Food foodObj1 =  new Food(102, "Cappucino", sellerObj, 10000, FoodCategory.Coffee);
        
        
        Customer customerObj = new Customer (432, "Alwan", ".alwan.fadhil@gmail.com", "alwan1", new  GregorianCalendar(2020,3,19));
        Customer customerObj1 = new Customer(433, "Ukok", "Alfiyansyah76@ui.ac.id", "Alfin123", 12,3,2020 );
        Customer customerObj2 = new Customer(434, "alwan", "Alfiyansyah1@yahoo.com", "sss12");
        
        
        customerObj.toString();
        customerObj1.toString();
        customerObj2.toString();
        
        
        
      
        
        
        
        
    }

   
    }

