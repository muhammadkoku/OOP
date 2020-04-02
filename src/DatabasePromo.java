import java.util.ArrayList;


public class DatabasePromo
{
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<Promo>();
    private static int lastId = 0;

    public static ArrayList<Promo> getPromoDatabase(){
        return PROMO_DATABASE;

    }

    public static int getLastId(){
        return lastId;
    }

    public static Promo getPromoById(int id){
        Promo value=null;
        for(Promo promoDB : PROMO_DATABASE)
        {
            if(promoDB.getId()==id)
            {
                value=promoDB;
            }
        }
        return value;
    }

    public static Promo getPromoByCode(String code){
        Promo value=null;
        for(Promo promoDB : PROMO_DATABASE)
        {
            if(promoDB.getCode()==code)
            {
                value=promoDB;
            }
        }
        return value;
    }


    public static boolean addPromo(Promo promo)
    {
        boolean found = false;
        for(Promo temp : PROMO_DATABASE)
        {
            if(temp.getCode() == promo.getCode())
            {
                return true;
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return false;
    }
    
    public static boolean removePromo(int id)
    {
        boolean value=false;
        for(Promo promoDB1 : PROMO_DATABASE)
        {
            if(promoDB1.getId()==id)
            {
                PROMO_DATABASE.remove(id);
                value=true;
            }
        }
        return value;
    }

    public static boolean activatePromo(int id) {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            promo.setActive(true);
            return true;
        }
        return false;
    }

    public static boolean deactivatePromo(int id) {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            promo.setActive(false);
            return true;
        }
        return false;
    }

}
