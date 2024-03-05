package com.example.restaurant.controllers;

import com.example.restaurant.daos.FoodDao;
import com.example.restaurant.models.FoodMod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {
    @Autowired
    FoodDao foodDao;

    @GetMapping("/foodlist")
    public String getFlist(Model model) {
        List<FoodMod> foodMods=foodDao.findAll();
        model.addAttribute("fs",foodMods);

        return "foodlist";
    }

    @GetMapping("/createfood")
    public String getClist() {
        return "createfood";
    }

    @GetMapping("/editfood")
    public  String getElist(){
        return  "editfood";
    }

    @PostMapping("/createfood")
    public  String PosFlist(FoodMod flist){
        foodDao.save(flist);
        return "redirect:/food/foodlist";
    }

    @GetMapping("/food_of/{id}")
    public  String getTOF(@PathVariable int id){
        FoodMod foodMod=foodDao.findById(id).orElse(null);
        if (foodMod.getFood_of()==null)foodMod.setFood_of("on");
        else foodMod.setFood_of(null);
        foodDao.save(foodMod);

        return "redirect:/food/foodlist";
    }

    @GetMapping("/deletefood/{id}")
    public  String delList(@PathVariable int id){

        foodDao.deleteById(id);

        return  "redirect:/food/foodlist";
    }


    @GetMapping("/editfood/{id}")
    public  String getEfood(@PathVariable int id,Model model){
        FoodMod foodMod=foodDao.findById(id).orElse(null);
        model.addAttribute("ef",foodMod);


        return "editfood";
    }

    @PostMapping("/editfood/{id}")
    public  String posEfood(FoodMod food){
        foodDao.save(food);

        return "redirect:/food/foodlist";
    }


}
