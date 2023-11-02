package co.kr.geapan.geapan.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }
    @GetMapping("/pet/blog_details")
    public String blog_details() {
        return "pet/blog-details";
    }
    @GetMapping("/pet/blog")
    public String blog() {
        return "pet/blog";
    }
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

    @GetMapping("/member/login")
    public String login() {
        return "member/login";
    }
}
