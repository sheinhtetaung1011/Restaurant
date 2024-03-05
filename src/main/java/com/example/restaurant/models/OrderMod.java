package com.example.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderMod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fname;
    private int fprice;
    private int qty;
    private int total;
    private int payment;
    private int table_id;

    public OrderMod() {
    }


    public OrderMod(int fname, int fprice, int qty, int total, int payment, int table_id) {
        this.fname = fname;
        this.fprice = fprice;
        this.qty = qty;
        this.total = total;
        this.payment = payment;
        this.table_id = table_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFname() {
        return fname;
    }

    public void setFname(int fname) {
        this.fname = fname;
    }

    public int getFprice() {
        return fprice;
    }

    public void setFprice(int fprice) {
        this.fprice = fprice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderMod{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", fprice=" + fprice +
                ", qty=" + qty +
                ", total=" + total +
                ", payment=" + payment +
                ", table_id=" + table_id +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }
}
