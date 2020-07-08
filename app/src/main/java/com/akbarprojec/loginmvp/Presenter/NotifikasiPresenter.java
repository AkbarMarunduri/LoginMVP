package com.akbarprojec.loginmvp.Presenter;

import com.akbarprojec.loginmvp.Api.ApiClient;
import com.akbarprojec.loginmvp.Api.ApiInterface;
import com.akbarprojec.loginmvp.Model.Notifikasi;
import com.akbarprojec.loginmvp.Model.Value;
import com.akbarprojec.loginmvp.View.AIview.ICreaatedNotifiksaiView;
import com.akbarprojec.loginmvp.View.AIview.INotifikasiView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotifikasiPresenter implements INotifikasiPresenter {

    INotifikasiView iNotifikasiView;
    ICreaatedNotifiksaiView iCreaatedNotifiksaiView;

    public NotifikasiPresenter(INotifikasiView iNotifikasiView) {
        this.iNotifikasiView = iNotifikasiView;
    }

    public NotifikasiPresenter(ICreaatedNotifiksaiView iCreaatedNotifiksaiView) {
        this.iCreaatedNotifiksaiView = iCreaatedNotifiksaiView;
    }

    @Override
    public void listDataNotifikasi() {
        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<Value> valueCall = apiInterface.getListNotifikasi();
        valueCall.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                iNotifikasiView.notifikasiList(response.body().getNotifikasiList());
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void cretedNotifikasi(Notifikasi n) {
        if (n.getDesc().equalsIgnoreCase("")) {
            iCreaatedNotifiksaiView.onCreatedError("Kolom deskripsi tidak boleh kosng..!");
        } else if (n.getMesin().equalsIgnoreCase("")) {
            iCreaatedNotifiksaiView.onCreatedError("Pilih mesin yang akan diperbaiki..!!");
        } else if (n.getTanggal().equalsIgnoreCase("")) {
            iCreaatedNotifiksaiView.onCreatedError("Tanggal lapor tifak boleh kosong..!!");
        } else if (n.getJam().equalsIgnoreCase("")) {
            iCreaatedNotifiksaiView.onCreatedError("Jam laporan tidak boleh kosong..1!");
        } else if (n.getPelapor().equalsIgnoreCase("")) {
            iCreaatedNotifiksaiView.onCreatedError("Nama pelapor tidak boleh kosong..!!");
        } else if (n.getCatatan().equalsIgnoreCase("")) {
            iCreaatedNotifiksaiView.onCreatedError("Catatan tidaak boleh kosong..!!");
        } else {
            ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
            Call<Value> valueCall = apiInterface.creatNotifkasi(n.getDesc(), n.getStatus(), n.getMesin(), n.getTanggal(), n.getJam(), n.getPlant(), n.getPelapor(), n.getCatatan(), n.getCreated(), n.getCreatedDate());
            valueCall.enqueue(new Callback<Value>() {
                @Override
                public void onResponse(Call<Value> call, Response<Value> response) {
                    String value = response.body().getValue();
                    if (value.equals("1")) {
                        iCreaatedNotifiksaiView.onCreatedSucses(response.body().getMessage().toString());
                    } else {
                        iCreaatedNotifiksaiView.onCreatedError(response.body().getMessage().toString());
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
