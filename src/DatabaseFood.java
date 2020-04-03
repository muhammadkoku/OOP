/**
 * @author Muhammad Koku
 * @version 2020-02-27
 */

import java.util.ArrayList;

public class DatabaseFood
{
    /**
     * The variable for class DatabaseFood
     */

    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<Food>();
    private static int lastId = 0;

    public static ArrayList<Food> getFoodDatabase(){
        return FOOD_DATABASE;

    }

    public static int getLastId(){
        return lastId;
    }
    public static Food getFoodById(int id){
        Food value=null;
        for(Food foodDB : FOOD_DATABASE)
        {
            if(foodDB.getId()==id)
            {
                value=foodDB;
            }
        }
        return value;
    }
    public static ArrayList<Food> getFoodBySeller(Seller seller){
        ArrayList<Food> value=null;
        for(Food foodDB1 : FOOD_DATABASE)
        {
            if(foodDB1.getSeller()== seller)
            {
                value.add(foodDB1);
            }
        }
        return value;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory category){
        ArrayList<Food> filteredByCategory= new ArrayList<Food>(0);;
        for (int i = 0; i < FOOD_DATABASE.size(); i++) {
            if(category==FOOD_DATABASE.get(i).getCategory()){
                filteredByCategory.add(FOOD_DATABASE.get(i));
            }
        }
        return filteredByCategory;
    }

    public static boolean addFood(Food food)
    {
        boolean found = false;
        for(Food temp : FOOD_DATABASE)
        {
            if(temp.getName() == food.getName() && temp.getSeller() == food.getSeller())
            {
                return true;
            }
        }
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return false;
    }


    /**
     * Removing food
     *
     * @return true
     */
    public static boolean removeFood(int id)
    {
        boolean value=false;
        for(Food foodDB1 : FOOD_DATABASE)
        {
            if(foodDB1.getId()==id)
            {
                FOOD_DATABASE.remove(id);
                value=true;
            }
        }
        return value;
    }

}
