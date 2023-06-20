package com.cybersoft.cozastore_java21.payload.response;

public class ProductRespone {
    private int id;
    private int categoryId;
    private String name;
    private double prices;
    private String img;
    private String imgList;

    public ProductRespone() {
    }

    public ProductRespone(int id, int categoryId, String name, double prices, String img, String imgList) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.prices = prices;
        this.img = img;
        this.imgList = imgList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgList() {
        return imgList;
    }

    public void setImgList(String imgList) {
        this.imgList = imgList;
    }
}
