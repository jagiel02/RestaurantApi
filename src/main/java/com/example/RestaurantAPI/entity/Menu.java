package com.example.RestaurantAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String menuName;
    private String menuDesc;
    private String menuPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Menu(long id, String menuName, String menuDesc, String menuPrice) {
        this.id = id;
        this.menuName = menuName;
        this.menuDesc = menuDesc;
        this.menuPrice = menuPrice;
    }

    public Menu(){
        super();
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", menuDesc='" + menuDesc + '\'' +
                ", menuPrice='" + menuPrice + '\'' +
                '}';
    }
}
