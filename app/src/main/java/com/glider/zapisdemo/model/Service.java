package com.glider.zapisdemo.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;

public class Service implements Parcelable {
    @Expose private int id;
    @Expose private String name;
    @Expose private int duration;
    @Expose private String description;
    @Expose private String priceStr;
    @Expose private int categoryId;

    public Service(){}

    public Service(String name) {
        this.name = name;
    }

    private Service(@NonNull Parcel in) {
        id = in.readInt();
        name = in.readString();
        duration = in.readInt();
        description = in.readString();
        priceStr = in.readString();
        categoryId = in.readInt();
    }

    public static final Creator<Service> CREATOR = new Creator<Service>() {
        @Override
        public Service createFromParcel(Parcel in) {
            return new Service(in);
        }

        @Override
        public Service[] newArray(int size) {
            return new Service[size];
        }
    };

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(duration);
        dest.writeString(description);
        dest.writeString(priceStr);
        dest.writeInt(categoryId);
    }
}
