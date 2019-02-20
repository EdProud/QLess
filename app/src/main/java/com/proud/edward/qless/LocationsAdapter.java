package com.proud.edward.qless;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 30/01/2017.
 */

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.LocationViewHolder> {
    private ArrayList<LocationModel<Integer>> locationModels;
    private Context context;
    private LocationCallback locationCallback;

    public LocationsAdapter(ArrayList<LocationModel<Integer>> locationModels, Context context, LocationCallback locationCallback){
        this.locationModels = locationModels;
        this.context = context;
        this.locationCallback = locationCallback;
    }
    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_entry, parent, false);
        return new LocationViewHolder(view);

    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
        LocationModel<Integer> locationModel = locationModels.get(position);
        holder.textView.setText(locationModel.getLocationName());
        Picasso.with(context).load(locationModel.getImageResource()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return locationModels.size();
    }



    class LocationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;

        public LocationViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.locationName);

        }

        @Override
        public void onClick(View v) {

            Log.d("clicked", "onClick: " + getAdapterPosition());
            locationCallback.entryClicked(locationModels.get(getAdapterPosition()).getId());
        }
    }

    interface LocationCallback {
        void entryClicked(int id);
    }
}
