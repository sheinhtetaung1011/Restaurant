package com.example.restaurant.daos;

import com.example.restaurant.models.OrderMod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<OrderMod,Integer> {
}
