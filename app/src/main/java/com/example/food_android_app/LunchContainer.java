package com.example.food_android_app;

public class LunchContainer {
    private String id;
    private String lunchName;
    private String lunchPrice;
    private String lunchImage;

    public LunchContainer(String lunchImage, String lunchName, String lunchPrice, String id) {
        this.id = id;
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

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LunchContainer{" +
                "id='" + id + '\'' +
                ", lunchName='" + lunchName + '\'' +
                ", lunchPrice='" + lunchPrice + '\'' +
                ", lunchImage='" + lunchImage + '\'' +
                '}';
    }

}
