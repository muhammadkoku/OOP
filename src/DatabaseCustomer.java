import java.util.ArrayList;

public class DatabaseCustomer
{
    // instance variables - replace the example below with your own
    private static ArrayList<Customer> CUSTOMER_DATABASE= new ArrayList<Customer>();
    private static int lastId = 0;

    public static ArrayList<Customer> getCustomerDatabase(){
        //return customer;
        return CUSTOMER_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Customer getCustomerById(int id){
        Customer value=null;
        for(Customer customer : CUSTOMER_DATABASE)
        {
            if(customer.getId()==id)
            {
                value=customer;
            }
        }
        return value;

    }



    public static boolean addCustomer(Customer customer)
    {
        boolean found = false;
        for(Customer temp : CUSTOMER_DATABASE)
        {
            if(temp.getName() == customer.getName() && temp.getEmail()
                    == customer.getEmail())
            {
                return false;
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;
    }
    /**
     * Removing customer
     *
     * @return true
     */
    public static boolean removeCustomer(int id)
    {
        for(Customer temp : CUSTOMER_DATABASE)
        {
            if(temp.getId() == id)
            {
                CUSTOMER_DATABASE.remove(temp);
                return true;
            }
        }
        return false;

    }

}
