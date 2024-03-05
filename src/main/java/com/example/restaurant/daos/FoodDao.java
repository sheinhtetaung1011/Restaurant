package com.example.restaurant.daos;

import com.example.restaurant.models.FoodMod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodDao extends JpaRepository<FoodMod,Integer> {
}
