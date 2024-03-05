package com.example.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodMod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String foodname;
    private  int price;
    private  String food_of;

    public FoodMod() {
    }

    public FoodMod(String foodname, int price, String food_of) {
        this.foodname = foodname;
        this.price = price;
        this.food_of = food_of;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFood_of() {
        return food_of;
    }

    public void setFood_of(String food_of) {
        this.food_of = food_of;
    }

    @Override
    public String toString() {
        return "FoodMod{" +
                "id=" + id +
                ", foodname='" + foodname + '\'' +
                ", price=" + price +
                ", food_of='" + food_of + '\'' +
                '}';
    }
}
