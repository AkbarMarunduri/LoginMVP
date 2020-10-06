package com.akbarprojec.loginmvp.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {
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

    protected User(Parcel in) {
        User = in.readString();
        Password = in.readString();
        level = in.readString();
        status = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(User);
        parcel.writeString(Password);
        parcel.writeString(level);
        parcel.writeString(status);
    }
}
