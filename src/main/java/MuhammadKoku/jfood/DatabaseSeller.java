package MuhammadKoku.jfood;

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

    public static Seller getSellerById(int id) throws SellerNotFoundException{

        for(Seller seller : SELLER_DATABASE)
        {
            if(seller.getId()==id)
            {
                return seller;
            }
        }
        throw new SellerNotFoundException(id);
    }
    
    public static boolean addSeller(Seller seller)
    {
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }
    /**
     * Removing seller
     *
     * @return true
     */
    public static boolean removeSeller(int id) throws SellerNotFoundException
    {
        for(Seller sellerDB : SELLER_DATABASE)
        {
            if(sellerDB.getId() == id)
            {
                SELLER_DATABASE.remove(sellerDB);
                return true;
            }
        }
        throw new SellerNotFoundException(id);
    }
}
