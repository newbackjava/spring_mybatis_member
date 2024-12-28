package com.example.demo.cart.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Log4j2
@Slf4j
@Controller
@RequestMapping("cart")
public class CartController {

    @GetMapping("cart")
    public String cart(){
        return "cart/cart";
    }


}
