package MuhammadKoku.jfood;

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

    public static Customer getCustomerById(int id)throws CustomerNotFoundException {

        for(Customer customer : CUSTOMER_DATABASE)
        {
            if(customer.getId()==id)
            {
                return customer;
            }
        }
        throw new CustomerNotFoundException(id);

    }



    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistsException
    {
        for(Customer customerDB : CUSTOMER_DATABASE)
        {
            if(customer.getEmail()==customerDB.getEmail())
            {
                throw new EmailAlreadyExistsException(customer);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId =customer.getId();
        return true;
    }
    /**
     * Removing customer
     *
     * @return true
     */
    public static boolean removeCustomer(int id)throws CustomerNotFoundException
    {
        for(Customer customerDB : CUSTOMER_DATABASE)
        {
            if(customerDB.getId()==id)
            {
                CUSTOMER_DATABASE.remove(customerDB);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);

    }

    public static Customer getCustomerLogin(String email, String password){
        for (Customer customerPtr : CUSTOMER_DATABASE){
            if (customerPtr.getEmail().equals(email) && customerPtr.getPassword().equals(password))
            {
                return customerPtr;
            }
        }
        return null;
    }

}
