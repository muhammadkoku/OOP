import java.util.*; 
import java.util.regex.*;
import java.text.SimpleDateFormat;

public class Jfood {
    public static void main(String[] args) {
        try {
            DatabaseFood.getFoodById(99);
        } catch (FoodNotFoundException e) {
            System.out.println(e.getExMessage());
        }

        try {
            DatabasePromo.getPromoById(99);
        } catch (PromoNotFoundException e) {
            System.out.println(e.getExMessage());
        }

        try {
            DatabaseCustomer.getCustomerById(99);
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getExMessage());
        }

        try {
            DatabaseSeller.getSellerById(99);
        } catch (SellerNotFoundException e) {
            System.out.println(e.getExMessage());
        }

        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Koku", "muhammadkoku@gmail.com", "koku1"));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Koku", "muhammadkoku@gmail.com", "koku123"));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Rama", "mkharismar@gmail.com", "sss12"));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Alwan", "alwan@gmail.com", "sss12"));

        } catch (EmailAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }


        try {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "ABCD12", 15000, 20000, true));
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "ABCD12", 5000, 20000, false));
        } catch (PromoCodeAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }

        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Ayam Goreng", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 15000, FoodCategory.Snacks));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Ayam Bakar", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 15000, FoodCategory.Snacks));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Kopi Luwak", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 20000, FoodCategory.Coffee));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("========== YANG MASUK KE DATABASE CUSTOMER ==========");
        for (Customer customer : DatabaseCustomer.getCustomerDatabase()) {
            System.out.println(customer);
            System.out.println();
        }

        System.out.println("========== YANG MASUK KE DATABASE PROMO ==========");
        for (Promo promo : DatabasePromo.getPromoDatabase()) {
            System.out.println(promo);
            System.out.println();
        }
        System.out.println("========== YANG MASUK KE DATABASE FOOD ==========");
        for (Food food : DatabaseFood.getFoodDatabase()) {
            System.out.println(food);
            System.out.println();
        }
        ArrayList<Food> Food1 = new ArrayList<Food>();
        ArrayList<Food> Food2 = new ArrayList<Food>();
        ArrayList<Food> Food3 = new ArrayList<Food>();

        try {
            Food1.add(DatabaseFood.getFoodById(1));
            Food2.add(DatabaseFood.getFoodById(2));
            Food3.add(DatabaseFood.getFoodById(3));
        } catch (FoodNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, Food1, DatabaseCustomer.getCustomerById(1)));
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, Food2, DatabaseCustomer.getCustomerById(2)));
           // DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, Food3, DatabaseCustomer.getCustomerById(3), 9000));

        } catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        DatabaseInvoice.getInvoiceDatabase().stream().map((invoice) -> new Thread(new PriceCalculator(invoice))).forEachOrdered((calculate) -> {
            calculate.start();
        });



    }

}

        
        
      
        
        
        
        


   


