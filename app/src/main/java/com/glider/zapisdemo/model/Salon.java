package com.glider.zapisdemo.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Salon {
    @Expose private int id;
    @Expose private String name;
    @Expose private String address;
    @Expose private String description;
    @Expose private String type;
    @Expose private String pictureUrl;
    @Expose private List<String> pictures;

    public Salon(String asdf) {
        this.name = asdf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}
