package com.glider.zapisdemo.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SalonDetail {
    @Expose private Salon salon;
    @Expose private List<Service> services;
    @Expose private List<Category> categories;

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
