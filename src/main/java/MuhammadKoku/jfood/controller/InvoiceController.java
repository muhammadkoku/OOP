package MuhammadKoku.jfood.controller;

import MuhammadKoku.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/invoice")
@CrossOrigin(origins ="",allowedHeaders="")
@RestController
public class InvoiceController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
        return invoice;
    }

    @RequestMapping("/customer/{customerId}")
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
        ArrayList<Invoice> invoice = new ArrayList<Invoice>(0);
        try {
            invoice = DatabaseInvoice.getInvoiceByCustomer(customerId);
        } catch (CustomerNotFoundException e) {
            e.getMessage();
            return null;
        }
        return invoice;
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value="status") InvoiceStatus status)
    {
        boolean check = DatabaseInvoice.changeInvoiceStatus(id,status);
        if (check)
            try {
                return DatabaseInvoice.getInvoiceById(id);
            }
            catch (InvoiceNotFoundException e){
                System.out.println(e.getMessage());
            }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeInvoice(@PathVariable int id){
        try{
            if (DatabaseInvoice.removeInvoice(id)){
                return true;
            }
        }
        catch (InvoiceNotFoundException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value = "customerId") int customerId,
                                  @RequestParam(value = "deliveryFee") int deliveryFee) throws CustomerNotFoundException {

        ArrayList<Food> foodList = new ArrayList<>();
        Customer customer = null;
        for (Integer temp: foodIdList) {
            try {
                foodList.add(DatabaseFood.getFoodById(temp));
            } catch (FoodNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            customer = DatabaseCustomer.getCustomerById(customerId);
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
        Invoice input = new CashInvoice(DatabaseInvoice.getLastId() + 1, foodList, customer, deliveryFee);
        DatabaseInvoice.addInvoice(input);
        input.setTotalPrice();
        return input;

        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList,
                                      @RequestParam(value = "customerId") int customerId,
                                      @RequestParam(value = "promoCode") String promoCode){

        ArrayList<Food> foodList = new ArrayList<>();
        Customer customer = null;
        for (Integer temp: foodIdList) {
            try {
                foodList.add(DatabaseFood.getFoodById(temp));
            } catch (FoodNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            customer = DatabaseCustomer.getCustomerById(customerId);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
        try {
        Invoice input = new CashlessInvoice( DatabaseInvoice.getLastId() + 1, foodList, customer, DatabasePromo.getPromoByCode(promoCode));
        DatabaseInvoice.addInvoice(input);
        input.setTotalPrice();
        return input;

        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
            return null;
        }

    }

}
