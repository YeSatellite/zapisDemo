package com.glider.zapisdemo.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SalonObject {
    @Expose private List<Salon> salons;

    public List<Salon> getSalons() {
        return salons;
    }

    public void setSalons(List<Salon> salons) {
        this.salons = salons;
    }
}
