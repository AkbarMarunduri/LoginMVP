package com.akbarprojec.loginmvp.View.AIview;

import com.akbarprojec.loginmvp.Model.User;

import java.util.ArrayList;
import java.util.List;

public interface ILoginView {
    void onLoginError(String pesan);
    void onLoginSucses(String pesan, List<User> users);
}

