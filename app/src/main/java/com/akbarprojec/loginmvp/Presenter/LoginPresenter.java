package com.akbarprojec.loginmvp.Presenter;

import com.akbarprojec.loginmvp.Api.ApiClient;
import com.akbarprojec.loginmvp.Api.ApiInterface;
import com.akbarprojec.loginmvp.Model.User;
import com.akbarprojec.loginmvp.Model.Value;
import com.akbarprojec.loginmvp.View.AIview.ILoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements ILoginPresenter{
    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void onLogin(String user, String pass) {
        User user1=new User(user,pass);
        int validated=user1.isValidated();

        if(validated==0){
            iLoginView.onLoginError("You must enter you Email");
        }else if(validated==1){
            iLoginView.onLoginError("You must enter valid Email");
        }else if(validated==2){
            iLoginView.onLoginError("You leng must be greater than 6");
        }else{
            ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
            Call<Value> valueCall=apiInterface.login(user1.getUser(),user1.getPassword());
            valueCall.enqueue(new Callback<Value>() {
                @Override
                public void onResponse(Call<Value> call, Response<Value> response) {
                    String value=response.body().getValue();
                    if (value.equals("1")){
                        iLoginView.onLoginSucses(response.body().getMessage());
                    }else{
                        iLoginView.onLoginError(response.body().getMessage().toString());
                    }
                }

                @Override
                public void onFailure(Call<Value> call, Throwable t) {

                }
            });
        }
    }




}
