
public class Food
{
    
    private int id;
    private String name;
    private int price;
    private String category;
    private Seller seller; 
    
    public Food(int id, String name, Seller seller, int price, String category)
    {
       this.id = id ;
       this.name = name;
       this.seller = seller;
       this.price = price;
       this.category = category;       
    }

    public Seller getSeller()
    {
        return this.seller;
    }
    
        public int getId()
    {
       return id;
    }
    
    public String getName()
    {
        return name;
    }
     public int getPrice()
    {
       return price;
    }
    public String getCategory()
    {
        return category;
    }
    
    public void setSeller(Seller seller)
    {
        this.seller = seller;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }
    
    public void printData()
    {
    }
    
}
