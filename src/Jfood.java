import java.util.*; 
import java.util.regex.*;
import java.text.SimpleDateFormat;

public class Jfood {
    public static void main(String[] args) {
     try {
         DatabaseFood.getFoodById(99);
     }
     catch (FoodNotFoundException e){
         System.out.println(e.getExMessage());
     }

     try {
           DatabasePromo.getPromoById(99);
      }
     catch (PromoNotFoundException e){
            System.out.println(e.getExMessage());
       }

     try {
           DatabaseCustomer.getCustomerById(99);
       }
       catch (CustomerNotFoundException e){
           System.out.println(e.getExMessage());
       }

        try {
            DatabaseSeller.getSellerById(99);
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getExMessage());
        }

      try {
          DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Koku", "muhammadkoku@gmail.com", "koku1"));
          DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Koku", "muhammadkoku@gmail.com", "koku123"));
          DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Rama", "mkharismar@gmail.com", "sss12"));
          DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Alwan", "alwan@gmail.com", "sss12"));

      } catch (EmailAlreadyExistsException e) {
          System.out.println(e.getExMessage());
      }


      try {
           DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "ABCD12", 15000, 20000, true));
           DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "ABCD12", 5000, 20000, false));
       } catch (PromoCodeAlreadyExistsException e) {
           System.out.println(e.getExMessage());
       }

      System.out.println("========== YANG MASUK KE DATABASE CUSTOMER ==========");
      for (Customer customer : DatabaseCustomer.getCustomerDatabase()){
          System.out.println(customer);
          System.out.println();
      }

      System.out.println("========== YANG MASUK KE DATABASE PROMO ==========");
       for (Promo promo : DatabasePromo.getPromoDatabase()){
           System.out.println(promo);
           System.out.println();
       }
       System.out.println("========== YANG MASUK KE DATABASE FOOD ==========");
       for (Food food : DatabaseFood.getFoodDatabase()){
           System.out.println(food);
           System.out.println();
       }
    }

    private static class PriceCalculator implements Runnable{
        Invoice input;
        PriceCalculator(Invoice input){
            this.input = input;
        }
        @Override
        public void run(){
            System.out.println("Calculating Invoice ID: "+ input.getId());
            input.setTotalPrice();
            System.out.println("Finish calculating Invoice ID: "+ input.getId());
        }
    }
}

        
        
      
        
        
        
        


   


