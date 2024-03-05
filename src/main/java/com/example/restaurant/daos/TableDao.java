package com.example.restaurant.daos;

import com.example.restaurant.models.TableMod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableDao extends JpaRepository<TableMod,Integer> {
}
