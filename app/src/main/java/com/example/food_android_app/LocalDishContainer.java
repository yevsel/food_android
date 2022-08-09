package com.example.food_android_app;

public class LocalDishContainer {
    String name;
    String price;
    String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public LocalDishContainer(String imgUrl,String name, String price) {
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LocalDIshContainer{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
