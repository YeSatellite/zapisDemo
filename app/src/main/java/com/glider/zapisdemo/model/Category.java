package com.glider.zapisdemo.model;

import com.google.gson.annotations.Expose;

public class Category {
    @Expose private int id;
    @Expose private String name;

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
}
