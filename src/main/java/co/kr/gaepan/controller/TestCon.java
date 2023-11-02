package co.kr.gaepan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestCon {

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }

    @GetMapping("/shop_details")
    public String shop_details() {
        return "shop-details";
    }

    @GetMapping("/shop_grid")
    public String shop_grid() {
        return "shop-grid";
    }
    @GetMapping("/shoping_cart")
    public String shoping_cart() {
        return "shoping-cart";
    }
}
