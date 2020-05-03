package com.akbarprojec.loginmvp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Value {
    @SerializedName("value")
    String value;
    @SerializedName("message")
    String message;
    @SerializedName("result")
    List<Notif> notifList;

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
