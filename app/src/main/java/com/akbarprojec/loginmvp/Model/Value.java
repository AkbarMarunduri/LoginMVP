package com.akbarprojec.loginmvp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Value {
    @SerializedName("value")
    String value;
    @SerializedName("message")
    String message;
    @SerializedName("resultUser")
    List<User> userData;
    @SerializedName("resultNotifikasi")
    List<Notif> notifList;
    @SerializedName("resultOrder")
    List<Order> orderList;

    public List<User> getUserData() {
        return userData;
    }

    public void setUserData(List<User> userData) {
        this.userData = userData;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Notif> getNotifList() {
        return notifList;
    }

    public void setNotifList(List<Notif> notifList) {
        this.notifList = notifList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
