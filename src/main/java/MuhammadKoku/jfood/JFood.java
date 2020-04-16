package MuhammadKoku.jfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JFood {

    public static void main(String[] args) {

        Location locationObj = new Location("Serang", "Banten", "lokasi");
        Location locationObj1 = new Location("Cilegon", "Banten", "lokasi 1");
        Location locationObj2 = new Location("Depok", "Jawa Barat", "lokasi 2");

        Seller seller = new Seller(DatabaseSeller.getLastId() + 1, "Abang", "abang@abang.com", "08172612615", locationObj);
        Seller seller2 = new Seller(DatabaseSeller.getLastId() + 1, "Eneng", "eneng@eneng.com", "08172612615", locationObj1);
        Seller seller3 = new Seller(DatabaseSeller.getLastId() + 1, "Abah", "abah@abah.com", "08172612615", locationObj2);

        DatabaseSeller.addSeller(seller);
        DatabaseSeller.addSeller(seller2);
        DatabaseSeller.addSeller(seller3);

        DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Uduk", seller, 8000, FoodCategory.Rice));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Nasgor", seller, 10000, FoodCategory.Rice));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Nasi Putih", seller, 4000, FoodCategory.Rice));

        SpringApplication.run(JFood.class, args);
    }

}