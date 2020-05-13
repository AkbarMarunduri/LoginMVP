package com.akbarprojec.loginmvp.Presenter;

import com.akbarprojec.loginmvp.Api.ApiClient;
import com.akbarprojec.loginmvp.Api.ApiInterface;
import com.akbarprojec.loginmvp.Model.Value;
import com.akbarprojec.loginmvp.View.AIview.IOrderView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderPresenter implements IOrderPresenter{
    IOrderView iOrderView;

    public OrderPresenter(IOrderView iOrderView) {
        this.iOrderView = iOrderView;
    }

    @Override
    public void listDataOrder() {
        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<Value> valueCall=apiInterface.getListOrder();
        valueCall.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                iOrderView.listOrder(response.body().getOrderList());
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
