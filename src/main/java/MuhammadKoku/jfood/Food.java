package MuhammadKoku.jfood;

/**
 * @author Muhammad Koku
 * @version 2020-02-27
 */
public class Food
{
    /**
     * The variable for class Food
     */
    private int id;
    private String name;
    private int price;
    private Seller seller;
    private FoodCategory category;
    
    /**
     * Constructor for objects in class Food
     * 
     * @param id (food's id)
     * @param name (food's name)
     * @param seller (food's seller)
     * @param price (food's price)
     * @param category (food's category)
     */
    public Food(int id, String name, Seller seller, int price, FoodCategory category)
    {
       this.id = id ;
       this.name = name;
       this.seller = seller;
       this.price = price;
       this.category = category;       
    }
    /**
     * Gets the food's seller
     *
     * @return seller
     */
    public Seller getSeller()
    {
        return this.seller;
    }
    /**
     * Gets the food's id
     *
     * @return id
     */
    public int getId()
    {
       return id;
    }
    /**
     * Gets the food's name
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }
    /**
     * Gets the food's price
     *
     * @return price
     */
     public int getPrice()
    {
       return price;
    }
    
    /**
     * Gets the food's category
     *
     * @return category
     */
    public FoodCategory getCategory()
    {
        return category;
    }
    /**
     * Sets the food's seller
     * 
     * @param seller
     */
    public void setSeller(Seller seller)
    {
        this.seller = seller;
    }
    /**
     * Sets the food's id
     * 
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * Sets the food's name
     * 
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * Sets the food's price
     * 
     * @param price
     */
    public void setPrice(int price)
    {
        this.price = price;
    }
    /**
     * Sets the food's category
     * 
     * @param category
     */
    public void setCategory(FoodCategory category)
    {
        this.category = category;
    }
 
    public String toString()
    {
        return "==========FOOD==========\nId: "+id+"\nNama: "+name+"\nSeller: "+seller.getName()+"\nCity: "+seller.getLocation().getCity()+"\nPrice: "+price+"\nCategory: "+category;
        
    }
    
}
