package com.example.restaurant.controllers;

import com.example.restaurant.daos.TableDao;
import com.example.restaurant.models.TableMod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/table")
public class TableController {
    @Autowired
    TableDao tableDao;

    @GetMapping("/tablelist")
    public String getTlist(Model model) {
        List<TableMod> tlist=tableDao.findAll();
        model.addAttribute("tlist",tlist);
        return "tablelist";
    }


    @GetMapping("/createtable")
    public  String getCList(){

        return "createtable";
    }

    @PostMapping("/createtable")
    public String posClist(TableMod tableMod){
        tableDao.save(tableMod);

        return "redirect:/table/tablelist";
    }


    @GetMapping("/edittable/{id}")
    public  String getElist(@PathVariable int id,Model model){
        TableMod tm=tableDao.findById(id).orElse(null);
        model.addAttribute("tm",tm);

        return  "edittable";
    }

    @PostMapping("/edittable/{id}")
    public  String posElist(TableMod et){


        tableDao.save(et);

        return "redirect:/table/tablelist";
    }

    @GetMapping("/deletetable/{id}")
    public  String delList(@PathVariable int id){

        tableDao.deleteById(id);

        return  "redirect:/table/tablelist";
    }

    @GetMapping("/table_of/{id}")
    public  String getTable_of(@PathVariable int id){
        TableMod tableMod=tableDao.findById(id).orElse(null);
        if(tableMod.getTable_of()==null){
            tableMod.setTable_of("on");
        }else tableMod.setTable_of(null);
        tableDao.save(tableMod);

        return "redirect:/table/tablelist";
    }
}
