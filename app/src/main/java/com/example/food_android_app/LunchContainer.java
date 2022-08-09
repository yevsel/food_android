package com.example.food_android_app;

public class LunchContainer {
    private String lunchName;
    private String lunchPrice;
    private String lunchImage;

    public LunchContainer(String lunchImage, String lunchName, String lunchPrice) {
        this.lunchName = lunchName;
        this.lunchPrice = lunchPrice;
        this.lunchImage = lunchImage;
    }

    public String getLunchName() {
        return lunchName;
    }

    public void setLunchName(String lunchName) {
        this.lunchName = lunchName;
    }

    public String getLunchPrice() {
        return lunchPrice;
    }

    public void setLunchPrice(String lunchPrice) {
        this.lunchPrice = lunchPrice;
    }

    public String getLunchImage() {
        return lunchImage;
    }

    public void setLunchImage(String lunchImage) {
        this.lunchImage = lunchImage;
    }

    @Override
    public String toString() {
        return "LunchContainer{" +
                "lunchName='" + lunchName + '\'' +
                ", lunchPrice='" + lunchPrice + '\'' +
                ", lunchImage='" + lunchImage + '\'' +
                '}';
    }
}
