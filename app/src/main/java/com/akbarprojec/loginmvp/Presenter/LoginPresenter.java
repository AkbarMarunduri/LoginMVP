package com.akbarprojec.loginmvp.Presenter;

import com.akbarprojec.loginmvp.Api.ApiClient;
import com.akbarprojec.loginmvp.Api.ApiInterface;
import com.akbarprojec.loginmvp.Model.User;
import com.akbarprojec.loginmvp.Model.Value;
import com.akbarprojec.loginmvp.View.AIview.ILoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    public void onLogin(String user, String pass) {
        User us = new User(user, pass);
        int validated = us.isValidated();

        if (validated == 0) {
            iLoginView.onLoginError("You must enter you Email");
        } else if (validated == 1) {
            iLoginView.onLoginError("You must enter valid Email");
        } else if (validated == 2) {
            iLoginView.onLoginError("You leng must be greater than 6");
        } else {
            ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
            Call<Value> valueCall = apiInterface.login(us.getUser(), us.getPassword());
            valueCall.enqueue(new Callback<Value>() {
                @Override
                public void onResponse(Call<Value> call, Response<Value> response) {
                    String value = response.body().getValue();
                    if (value.equals("1")) {
                        iLoginView.onLoginSucses(response.body().getMessage(),response.body().getUserData());
                    } else {
                        iLoginView.onLoginError(response.body().getMessage().toString());
                    }
                }

                @Override
                public void onFailure(Call<Value> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }
}
