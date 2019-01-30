package com.example.myapplication;

public class Country {

    private String name;
    private String info;
    private int image;

    public Country(String name, String info, int image) {
        this.name = name;
        this.info = info;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public int getImage() {
        return image;
    }
}
