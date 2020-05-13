package com.akbarprojec.loginmvp.Model;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("iduser")
    String User;
    @SerializedName("pass")
    String Password;
    @SerializedName("level")
    String level;
    @SerializedName("status")
    String status;


    public User(String email, String password) {
        User = email;
        Password = password;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int isValidated() {
        if (TextUtils.isEmpty(getUser())) {
            return 0;
        } else if (getPassword().length() <= 0) {
            return 2;
        } else {
            return -1;
        }

    }
}
