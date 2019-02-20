package com.proud.edward.qless;

import java.util.ArrayList;

/**
 * Created by Admin on 30/01/2017.
 */

public class RetrieveLocalLocations implements LocationRetriever {

    @Override
    public ArrayList<LocationModel<Integer>> getLocations() {
        ArrayList<LocationModel<Integer>> list = new ArrayList<>();
        list.add(new LocationModel<Integer>("St. James' Park", 1, R.drawable.stjames));
        list.add(new LocationModel<Integer>("Shark Bar", 2, R.drawable.sharkbar));

        return list;
    }
}
