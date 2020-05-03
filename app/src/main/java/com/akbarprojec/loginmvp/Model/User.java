package com.akbarprojec.loginmvp.Model;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

public class User implements IUser {
    @SerializedName("iduser")
    String User;
    @SerializedName("pass")
    String Password;

    public User(String email, String password) {
        User = email;
        Password = password;
    }


    public String getUser() {
        return User;
    }

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
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
