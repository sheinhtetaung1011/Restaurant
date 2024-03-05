package com.example.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TableMod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private  String tablename;
    private  String table_of;
    private  String active_of;

    public TableMod() {
    }

    public TableMod(String tablename, String table_of, String active_of) {
        this.tablename = tablename;
        this.table_of = table_of;
        this.active_of = active_of;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getTable_of() {
        return table_of;
    }

    public void setTable_of(String table_of) {
        this.table_of = table_of;
    }

    public String getActive_of() {
        return active_of;
    }

    public void setActive_of(String active_of) {
        this.active_of = active_of;
    }

    @Override
    public String toString() {
        return "TableMod{" +
                "id=" + id +
                ", tablename='" + tablename + '\'' +
                ", table_of='" + table_of + '\'' +
                ", active_of='" + active_of + '\'' +
                '}';
    }
}
