package com.example.mad_project;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Item implements Parcelable {
    private String imageResource;
    private String name;
    private String price;

    public Item(String imageResource, String name, String price) {
        this.imageResource = imageResource;
        this.name = name;
        this.price = price;
    }

    protected Item(Parcel in) {
        imageResource = in.readString();
        name = in.readString();
        price = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(imageResource);
        parcel.writeString(name);
        parcel.writeString(price);
    }
}

