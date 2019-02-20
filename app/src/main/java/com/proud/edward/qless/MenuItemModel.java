package com.proud.edward.qless;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 31/01/2017.
 */

public class MenuItemModel implements Parcelable{

    private String name;
    private double price;
    private int id;
    private int amountOrdered;

    public MenuItemModel(String name, double price, int id, int amountOrdered) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.amountOrdered = amountOrdered;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void incrementOrders(){
        amountOrdered++;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public void setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
    }

    protected MenuItemModel(Parcel in) {
        name = in.readString();
        price = in.readDouble();
        id = in.readInt();
        amountOrdered = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeInt(id);
        dest.writeInt(amountOrdered);
    }

    public static final Parcelable.Creator<MenuItemModel> CREATOR = new Parcelable.Creator<MenuItemModel>() {
        @Override
        public MenuItemModel createFromParcel(Parcel in) {
            return new MenuItemModel(in);
        }

        @Override
        public MenuItemModel[] newArray(int size) {
            return new MenuItemModel[size];
        }
    };
}
