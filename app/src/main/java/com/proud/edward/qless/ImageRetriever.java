package com.proud.edward.qless;

import android.widget.ImageView;

/**
 * Created by Admin on 30/01/2017.
 */

public interface ImageRetriever<E> {
    E getImageResource();
    void setImageResource(ImageView imageView, E imageResource);
}
