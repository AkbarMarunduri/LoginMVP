package com.akbarprojec.loginmvp.Presenter;

import com.akbarprojec.loginmvp.Api.ApiClient;
import com.akbarprojec.loginmvp.Api.ApiInterface;
import com.akbarprojec.loginmvp.Model.Value;
import com.akbarprojec.loginmvp.View.AIview.INotifikasiView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotifikasiPresenter implements INotifikasiPresenter{

    INotifikasiView iNotifikasiView;

    public NotifikasiPresenter(INotifikasiView iNotifikasiView) {
        this.iNotifikasiView = iNotifikasiView;
    }

    @Override
    public void listDataNotifikasi() {
        ApiInterface apiInterface= ApiClient.getRetrofit().create(ApiInterface.class);
        Call<Value> valueCall=apiInterface.getListNotifikasi();
        valueCall.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                iNotifikasiView.notifikasiList(response.body().getNotifList());
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
