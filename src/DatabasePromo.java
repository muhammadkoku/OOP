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

    public static Promo getPromoById(int id) throws PromoNotFoundException{

        for(Promo promoDB : PROMO_DATABASE)
        {
            if(promoDB.getId()==id)
            {
                return promoDB;
            }
        }
        throw new PromoNotFoundException(id);
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


    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException
    {

        for(Promo temp : PROMO_DATABASE)
        {
            if(temp.getCode() == promo.getCode())
            {
                throw new PromoCodeAlreadyExistsException(promo);
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return true;
    }
    
    public static boolean removePromo(int id) throws PromoNotFoundException
    {

        for(Promo promoDB1 : PROMO_DATABASE)
        {
            if(promoDB1.getId()==id)
            {
                PROMO_DATABASE.remove(promoDB1);
                return true;
            }
        }
        throw new PromoNotFoundException(id);
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
