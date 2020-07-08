package com.akbarprojec.loginmvp.Api;

import com.akbarprojec.loginmvp.Model.Value;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<Value> login(@Field("iduser") String iduser,
                      @Field("pass") String password);

    @GET("Notifikasi.php")
    Call<Value> getListNotifikasi();

    @GET("Order.php")
    Call<Value> getListOrder();

    @FormUrlEncoded
    @POST("createNotifikasi.php")
    Call<Value> creatNotifkasi(@Field("desc") String desc,
                               @Field("status") String status,
                               @Field("mesin") String mesin,
                               @Field("tgl") String tanggal,
                               @Field("jam") String jam,
                               @Field("plant") String plant,
                               @Field("pelapor") String pelapor,
                               @Field("catatan") String catatan,
                               @Field("created") String created,
                               @Field("crtdate") String creatdate);


}
