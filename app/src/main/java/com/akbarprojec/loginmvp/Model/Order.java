package com.akbarprojec.loginmvp.Model;

import com.google.gson.annotations.SerializedName;

public class Order {
    @SerializedName("no_order")
    public String noOrder;
    @SerializedName("desc_order")
    public String descOrder;
    @SerializedName("sts_order")
    public String stsOrder;
    @SerializedName("release_by")
    public String releaseBy;
    @SerializedName("created_by")
    public String createdBy;

    public String getNoOrder() {
        return noOrder;
    }

    public void setNoOrder(String noOrder) {
        this.noOrder = noOrder;
    }

    public String getDescOrder() {
        return descOrder;
    }

    public void setDescOrder(String descOrder) {
        this.descOrder = descOrder;
    }

    public String getStsOrder() {
        return stsOrder;
    }

    public void setStsOrder(String stsOrder) {
        this.stsOrder = stsOrder;
    }

    public String getReleaseBy() {
        return releaseBy;
    }

    public void setReleaseBy(String releaseBy) {
        this.releaseBy = releaseBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
