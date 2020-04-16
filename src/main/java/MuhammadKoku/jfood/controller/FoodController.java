package MuhammadKoku.jfood.controller;

import MuhammadKoku.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FoodController {

    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood() {
        return DatabaseFood.getFoodDatabase();
    }

    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id) {
        Food food = null;
        try {
            food = DatabaseFood.getFoodById(id);
        } catch (FoodNotFoundException e) {
            e.getMessage();
        }
        return food;
    }

    @RequestMapping(value = "/food/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) {
        ArrayList<Food> food = new ArrayList<Food>(0);
        try {
            food = DatabaseFood.getFoodBySeller(sellerId);
        } catch (SellerNotFoundException e) {
            e.getMessage();
        }
        return food;
    }

    @RequestMapping(value = "/food/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category) {
        ArrayList<Food> filteredByCategory= new ArrayList<Food>(0);
        filteredByCategory = DatabaseFood.getFoodByCategory(category);
        return filteredByCategory;
    }

    @RequestMapping(value = "/food", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value="name") String name,
                            @RequestParam(value="price") int price,
                            @RequestParam(value="category") FoodCategory category,
                            @RequestParam(value = "seller ID") int sellerId) throws SellerNotFoundException {
       Food food = new Food(DatabaseFood.getLastId()+1, name, DatabaseSeller.getSellerById(sellerId), price, category);
       DatabaseFood.addFood(food);
       return food;
    }

}