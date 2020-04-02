import java.util.ArrayList;

public class DatabaseSeller
{

    private static ArrayList<Seller> SELLER_DATABASE= new ArrayList<Seller>();
    private static int lastId=0 ;
    /**
     * Constructor for objects of class DatabaseSeller
     */
   public static ArrayList<Seller> getSellerDatabase(){
       return SELLER_DATABASE;
   }
    public static int getLastId(){
       return lastId;
    }

    public static Seller getSellerById(int id){
       Seller value = null ;
        for(Seller seller : SELLER_DATABASE)
        {
            if(seller.getId()==id)
            {
                value=seller;
            }
        }
        return value;
    }
    
    public static boolean addSeller(Seller seller)
    {
        boolean found = false;
        for(Seller temp : SELLER_DATABASE)
        {
            if(temp.getName() == seller.getName() && temp.getEmail()
                    == seller.getEmail())
            {
                return false;
            }
        }
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }
    /**
     * Removing seller
     *
     * @return true
     */
    public static boolean removeSeller(int id)
    {
        for(Seller temp : SELLER_DATABASE)
        {
            if(temp.getId() == id)
            {
                SELLER_DATABASE.remove(temp);
                return true;
            }
        }
        return false;
    }
    //return seller passed to the constructor
    public static Seller getSeller()
    {
       return null;
    }
    /**
     * Gets the seller list 
     *
     * @return listSeller
     */
    public static String[] getListSeller()
    {
        return null;
    }
}
