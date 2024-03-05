package com.example.restaurant.controllers;

import com.example.restaurant.daos.FoodDao;
import com.example.restaurant.daos.OrderDao;
import com.example.restaurant.daos.TableDao;
import com.example.restaurant.models.FoodMod;
import com.example.restaurant.models.OrderMod;
import com.example.restaurant.models.TableMod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    TableDao tableDao;

    @Autowired
    FoodDao foodDao;

    @Autowired
    OrderDao orderDao;

    @GetMapping("/ordertablelist")
    public  String getOTlist(Model model){
        List<TableMod> tableMods=tableDao.findAll();
        model.addAttribute("tl",tableMods);
        return "ordertablelist";
    }

    @GetMapping("/orderlist/{id}")
    public String getOlist(@PathVariable int id,Model model) {
        model.addAttribute("tb_id",id);
        List<OrderMod> orders=orderDao.findAll();
        model.addAttribute("olist",orders);
        List<FoodMod> foodMods= foodDao.findAll();
        model.addAttribute("fl",foodMods);

        return "orderlist";
    }

    @GetMapping("/createorder/{id}")
    public String getClist(@PathVariable int id,Model model) {
        List<FoodMod> flist=foodDao.findAll();
        model.addAttribute("flist",flist);

        return "createorder";
    }

    @PostMapping("/createorder/{id}")
    public  String posOlist(@PathVariable int id, HttpServletRequest request){

        int food_id=Integer.parseInt(request.getParameter("fname"));
        int qty=Integer.parseInt(request.getParameter("qty"));

        FoodMod fm=foodDao.findById(food_id).orElse(null);

        int price=fm.getPrice();
        int total=qty*price;

        orderDao.save(new OrderMod(food_id,price,qty,total,0,id));

        TableMod tableMod=tableDao.findById(id).orElse(null);
        if(tableMod.getActive_of()==null)
        tableMod.setActive_of("active");
        tableDao.save(tableMod);

        return "redirect:/order/orderlist/{id}";
    }

    @GetMapping("/editorder")
    public  String getElist(){
        return  "editorder";
    }


    @GetMapping("/payment/{id}")
    public  String getPayment(@PathVariable int id){
        List<OrderMod> lom= orderDao.findAll();
        for (OrderMod om:lom ) {
            if(om.getTable_id()==id && om.getPayment()==0){
                om.setPayment(1);
                orderDao.save(om);
            }
        }
        TableMod tableMod=tableDao.findById(id).orElse(null);
        tableMod.setActive_of(null);
        tableDao.save(tableMod);
        return "redirect:/order/ordertablelist";
    }
}
