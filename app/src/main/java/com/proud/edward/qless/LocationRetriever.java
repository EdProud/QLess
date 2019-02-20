package com.proud.edward.qless;

import java.util.ArrayList;

/**
 * Created by Admin on 30/01/2017.
 */

public interface LocationRetriever<E> {
    ArrayList<LocationModel<E>> getLocations();
}
