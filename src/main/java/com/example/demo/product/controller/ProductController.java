package com.example.demo.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Log4j2
@Slf4j
@Controller
@RequestMapping("product")
public class ProductController {

    @GetMapping("product")
    public String product(){
        return "product/product";
    }


}
