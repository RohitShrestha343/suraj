package com.onlineauction.onlineauctionsale.model;

public class ProductsData {
private String prodName;
private String prodType;
private String prodTime;
private int imageId;


    public ProductsData(String prodName, String prodType, String prodTime, int imageId) {
        this.prodName = prodName;
        this.prodType = prodType;
        this.prodTime = prodTime;
        this.imageId = imageId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdTime() {
        return prodTime;
    }

    public void setProdTime(String prodTime) {
        this.prodTime = prodTime;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
