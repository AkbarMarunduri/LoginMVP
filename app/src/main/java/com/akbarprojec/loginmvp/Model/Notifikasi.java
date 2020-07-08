package com.akbarprojec.loginmvp.Model;

import com.google.gson.annotations.SerializedName;

public class Notifikasi {
    @SerializedName("no_notifikasi")
    String nomor;
    @SerializedName("desc_notifikasi")
    String desc;
    @SerializedName("no_mesin")
    String mesin;
    @SerializedName("sts_notif")
    String status;
    @SerializedName("tgl")
    String tanggal;
    @SerializedName("jam")
    String jam;
    @SerializedName("plant")
    String plant;
    @SerializedName("pelapor")
    String pelapor;
    @SerializedName("catatan")
    String catatan;
    @SerializedName("created")
    String created;
    @SerializedName("crtdate")
    String createdDate;

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

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getPelapor() {
        return pelapor;
    }

    public void setPelapor(String pelapor) {
        this.pelapor = pelapor;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
