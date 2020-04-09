import java.util.*; 
import java.util.regex.*;
import java.text.SimpleDateFormat;

public class Jfood {
    public static void main(String[] args) {
        Location locationObj = new Location("Serang", "Banten", "lokasi");
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Muhammad Koku", "muhammad.koku@ui.ac.id", "082292307525", locationObj));


        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Koku", "muhammadkoku@gmail.com", "koku1"));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Koku", "muhammadkoku@gmail.com", "koku123"));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Rama", "mkharismar@gmail.com", "sss12"));

        System.out.println("Daftar Customer: ");
        for (Customer customer : DatabaseCustomer.getCustomerDatabase()) {
            System.out.println(customer.getName());
        }

        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Ayam Goreng", DatabaseSeller.getSellerById(1), 12000, FoodCategory.Snacks));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Ayam Bakar", DatabaseSeller.getSellerById(1), 15000, FoodCategory.Snacks));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Cappucino", DatabaseSeller.getSellerById(1), 10000, FoodCategory.Coffee));

        System.out.println("Daftar Food Category Snacks: ");
        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Snacks)) {
            System.out.println(food.getName());
        }


        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "ABCD12", 5000, 20000, false));
        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "EFGH34", 15000, 20000, true));

        for (Promo promo : DatabasePromo.getPromoDatabase()) {
            System.out.println(promo);
        }

        ArrayList<Food> foodsobj = new ArrayList<Food>();
        foodsobj.add(DatabaseFood.getFoodById(1));
        foodsobj.add(DatabaseFood.getFoodById(1));
        foodsobj.add(DatabaseFood.getFoodById(1));

        ArrayList<Food> foodsobj1 = DatabaseFood.getFoodDatabase();

        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1, foodsobj, DatabaseCustomer.getCustomerById(1),10000));
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setTotalPrice();

        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, foodsobj1, DatabaseCustomer.getCustomerById(1)));
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setTotalPrice();

        System.out.println("INVOICE 1 :");
        for(Invoice invoice : DatabaseInvoice.getInvoiceDatabase()) {
            System.out.println(invoice);
            System.out.println();
        }

        DatabaseInvoice.changeInvoiceStatus(DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).getId(),InvoiceStatus.Finished);

        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, foodsobj1, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoByCode("ABCD12")));
        DatabasePromo.activatePromo(1);

        System.out.println("INVOICE 2 :");
        for(Invoice invoice : DatabaseInvoice.getInvoiceDatabase()) {
            System.out.println(invoice);
            System.out.println();
        }


    }
}

        
        
      
        
        
        
        


   


