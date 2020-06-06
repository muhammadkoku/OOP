package MuhammadKoku.jfood.controller;

import MuhammadKoku.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@CrossOrigin(origins ="",allowedHeaders="")
@RestController

public class PromoController{

    @RequestMapping(value = "/promo", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo() {
        return DatabasePromo.getPromoDatabase();
    }

    @RequestMapping(value = "/promo/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code) {
        Promo promo = null;
        promo = DatabasePromo.getPromoByCode(code);

        return promo;
    }

    @RequestMapping(value = "/promo", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value="code") String code,
                            @RequestParam(value="discount") int discount,
                            @RequestParam(value="min price") int minPrice,
                            @RequestParam(value = "active") boolean active)
    {

       Promo promo = new Promo (DatabasePromo.getLastId()+1, code, discount, minPrice, active);

        try {
            DatabasePromo.addPromo(promo);
        } catch (PromoCodeAlreadyExistsException e) {
            e.getMessage();
        }
        return promo;
    }
}