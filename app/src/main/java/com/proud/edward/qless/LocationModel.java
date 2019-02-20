package com.proud.edward.qless;

/**
 * Created by Admin on 30/01/2017.
 */

public class LocationModel<E> {

    private String locationName;
    private int id;
    private E imageResource;

    public LocationModel(String name, int id, E imageResource) {
        locationName = name;
        this.id = id;
        this.imageResource = imageResource;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public E getImageResource() {
        return imageResource;
    }

    public void setImageResource(E imageResource) {
        this.imageResource = imageResource;
    }
}
