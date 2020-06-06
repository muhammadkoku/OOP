package MuhammadKoku.jfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JFood {

    public static void main(String[] args) {

        Location locationObj = new Location("Serang", "Banten", "lokasi");

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId() + 1, "Abang", "abang@abang.com", "08172612615", locationObj));

        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Uduk", DatabaseSeller.getSellerById(1), 8000, FoodCategory.Rice));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Nasgor", DatabaseSeller.getSellerById(1), 10000, FoodCategory.Rice));

        } catch (SellerNotFoundException e) {
            System.out.println(e.getMessage());
        }


        SpringApplication.run(JFood.class, args);
    }

}