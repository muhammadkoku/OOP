import java.util.*; 
import java.util.regex.*;
import java.text.SimpleDateFormat;

public class Jfood {
    public static void main(String[] args) {
        Location locationObj = new Location("Serang", "Banten", "lokasi");
        DatabaseSeller.addSeller(new Seller(1, "Muhammad Koku", "muhammad.koku@ui.ac.id", "082292307525", locationObj));
        Calendar calendar = new GregorianCalendar(2020, 4, 2);

        DatabaseCustomer.addCustomer(new Customer(1, "Koku", "muhammadkoku@gmail.com", "koku1", calendar));
        DatabaseCustomer.addCustomer(new Customer(2, "Koku", "muhammadkoku@gmail.com", "koku123", 2020, 4, 2));
        DatabaseCustomer.addCustomer(new Customer(3, "Rama", "mkharismar@gmail.com", "sss12"));

        System.out.println("Daftar Customer: ");
        for (Customer customer : DatabaseCustomer.getCustomerDatabase()) {
            System.out.println(customer.getName());
        }

        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "XVGTAKL29", 20000, 50000, false));
        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "XVGTAKL29", 15000, 70000, true));

        for(Promo promo : DatabasePromo.getPromoDatabase()) {
            System.out.println(promo);
        }

        DatabaseFood.addFood(new Food(101, "Ayam Bakar", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 30000, FoodCategory.Snacks));
        DatabaseFood.addFood(new Food(102, "Ayam Goreng", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 30000, FoodCategory.Snacks));
        DatabaseFood.addFood(new Food(103, "Cappucino", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 10000, FoodCategory.Coffee));

        System.out.println("Daftar Food Category Snacks: ");
        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Snacks)) {
            System.out.println(food.getName());
        }

    }
}

        
        
      
        
        
        
        


   


