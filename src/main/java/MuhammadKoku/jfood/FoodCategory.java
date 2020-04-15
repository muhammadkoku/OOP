package MuhammadKoku.jfood;

public enum FoodCategory
{
    
    Beverages("Beverage"),
    Coffee("Coffee"),
    Western("Western"),
    Snacks("Snacks"),
    Rice("Rice"),
    Noodles("Noodles"),
    Bakery("Bakery"), 
    Japanese("Japanese");
    
    private String category;
    
    FoodCategory(String category){
        this.category = category;
    }
    private String category(){
        return category;
    }
}


