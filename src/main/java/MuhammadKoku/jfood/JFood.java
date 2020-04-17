package MuhammadKoku.jfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JFood {

    public static void main(String[] args) {

        Location locationObj = new Location("Serang", "Banten", "lokasi");
        Location locationObj1 = new Location("Cilegon", "Banten", "lokasi 1");
        Location locationObj2 = new Location("Depok", "Jawa Barat", "lokasi 2");

        //Seller seller = new Seller(DatabaseSeller.getLastId() + 1, "Abang", "abang@abang.com", "08172612615", locationObj);
        //Seller seller2 = new Seller(DatabaseSeller.getLastId() + 1, "Eneng", "eneng@eneng.com", "08172612615", locationObj1);
        //Seller seller3 = new Seller(DatabaseSeller.getLastId() + 1, "Abah", "abah@abah.com", "08172612615", locationObj2);

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId() + 1, "Abang", "abang@abang.com", "08172612615", locationObj));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId() + 1, "Eneng", "eneng@eneng.com", "08172612615", locationObj1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId() + 1, "Abah", "abah@abah.com", "08172612615", locationObj2));

        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Uduk", DatabaseSeller.getSellerById(1), 8000, FoodCategory.Rice));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Nasgor", DatabaseSeller.getSellerById(1), 10000, FoodCategory.Rice));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Nasi Putih", DatabaseSeller.getSellerById(1), 4000, FoodCategory.Rice));
        } catch (SellerNotFoundException e) {
            System.out.println(e.getMessage());
        }


        SpringApplication.run(JFood.class, args);
    }

}