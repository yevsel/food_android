package com.example.food_android_app;



public class BasketContainerClass  {
    String basketItemImageUrl;
    String basketItemName;
    String basketItemPrice;

    public BasketContainerClass(String basketItemImageUrl, String basketItemName, String basketItemPrice) {
        this.basketItemImageUrl = basketItemImageUrl;
        this.basketItemName = basketItemName;
        this.basketItemPrice = basketItemPrice;
    }

    public String getBasketItemImageUrl() {
        return basketItemImageUrl;
    }

    public void setBasketItemImageUrl(String basketItemImageUrl) {
        this.basketItemImageUrl = basketItemImageUrl;
    }

    public String getBasketItemName() {
        return basketItemName;
    }

    public void setBasketItemName(String basketItemName) {
        this.basketItemName = basketItemName;
    }

    public String getBasketItemPrice() {
        return basketItemPrice;
    }

    public void setBasketItemPrice(String basketItemPrice) {
        this.basketItemPrice = basketItemPrice;
    }

    @Override
    public String toString() {
        return "BasketContainer{" +
                "basketItemImageUrl='" + basketItemImageUrl + '\'' +
                ", basketItemName='" + basketItemName + '\'' +
                ", basketItemPrice='" + basketItemPrice + '\'' +
                '}';
    }
}
