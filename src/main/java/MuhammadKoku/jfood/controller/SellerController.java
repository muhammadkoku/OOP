package MuhammadKoku.jfood.controller;

import MuhammadKoku.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@CrossOrigin(origins ="",allowedHeaders="")
@RestController
public class SellerController {

    @RequestMapping(value = "/seller", method = RequestMethod.GET)
    public ArrayList<Seller> getAllSeller() {
        return DatabaseSeller.getSellerDatabase();
    }

    @RequestMapping(value = "/seller/{id}", method = RequestMethod.GET)
    public Seller getSellerById(@PathVariable int id) {
        Seller seller = null;
        try {
            seller = DatabaseSeller.getSellerById(id);
        } catch (SellerNotFoundException e) {
            e.getMessage();
        }
        return seller;
    }

    @RequestMapping(value = "/seller", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value="name") String name,
                            @RequestParam(value="email") String email,
                            @RequestParam(value="phone number") String phoneNumber,
                            @RequestParam(value = "province") String province,
                            @RequestParam(value="description") String description,
                            @RequestParam(value = "city") String city)
    {
        Location temp = new Location(city, province, description);
        Seller seller = new Seller(DatabaseSeller.getLastId()+1, name, email, phoneNumber, temp);
        DatabaseSeller.addSeller(seller);
        return seller;
    }
}