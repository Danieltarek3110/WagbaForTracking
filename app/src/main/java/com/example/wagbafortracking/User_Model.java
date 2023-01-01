package com.example.wagbafortracking;

import java.io.Serializable;
import java.util.ArrayList;

public class User_Model implements Serializable {

    ArrayList<Orders_Model> orders;


    public User_Model(ArrayList<Orders_Model> orders) {
        this.orders = orders;
    }

    public User_Model() {
    }

    public ArrayList<Orders_Model> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Orders_Model> orders) {
        this.orders = orders;
    }
}
