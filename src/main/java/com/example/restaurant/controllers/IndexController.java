package com.example.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public  String getIndex(){
        return  "index";
    }

    @GetMapping("/tablelist")
    public  String getTablelist(){

        return  "tablelist";
    }

    @GetMapping("/foodlist")
    public  String getFoodlist(){

        return "foodlist";
    }

    @GetMapping("/orderlist")
    public  String getOrderlist(){

        return  "orderlist";
    }
}
