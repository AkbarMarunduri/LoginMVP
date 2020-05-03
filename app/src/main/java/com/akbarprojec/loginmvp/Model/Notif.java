package com.akbarprojec.loginmvp.Model;

import com.google.gson.annotations.SerializedName;

public class Notif {
    @SerializedName("no_notifikasi")
    String nomor;
    @SerializedName("desc_notifikasi")
    String desc;
    @SerializedName("no_mesin")
    String mesin;
    @SerializedName("sts_notif")
    String status;

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMesin() {
        return mesin;
    }

    public void setMesin(String mesin) {
        this.mesin = mesin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
