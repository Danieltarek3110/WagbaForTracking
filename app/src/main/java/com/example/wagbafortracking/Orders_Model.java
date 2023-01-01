package com.example.wagbafortracking;

import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class Orders_Model implements Serializable {


    String TrackingNumber;
    String State;
    String Price;
    String OrderId; String UserID;



    public Orders_Model() {
    }

    public Orders_Model(String trackingNumber, String state, String price, ArrayList<Orders_Model> orders_models) {
        TrackingNumber = trackingNumber;
        State = state;
        Price = price;

    }

    public Orders_Model(String trackingNumber, String state, String price) {
        TrackingNumber = trackingNumber;
        State = state;
        Price = price;
    }

    public Orders_Model(String trackingNumber, String state, String price, String orderId, String userID) {
        TrackingNumber = trackingNumber;
        State = state;
        Price = price;
        OrderId = orderId;
        UserID = userID;

    }


    public String getTrackingNumber() {
        return TrackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        TrackingNumber = trackingNumber;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }


    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
}
