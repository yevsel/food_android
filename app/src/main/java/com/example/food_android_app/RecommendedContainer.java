package com.example.food_android_app;

public class RecommendedContainer {
    private String imgUrl;
    private String name;
    private String id;

    public RecommendedContainer(String imgUrl, String name, String id) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TopCategoriesContainer{" +
                "imgUrl='" + imgUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
