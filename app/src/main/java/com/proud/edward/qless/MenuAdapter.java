package com.proud.edward.qless;

import android.preference.PreferenceActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 31/01/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<MenuItemModel> items;
    private MenuCallback menuCallback;
    private boolean isEditable;

    public MenuAdapter(ArrayList<MenuItemModel> items, MenuCallback menuCallback, boolean isEditable){
        this.items = items;
        this.menuCallback = menuCallback;
        this.isEditable = isEditable;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == -1) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item, parent, false);
            return new HeaderViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
            return new MenuViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MenuItemModel menuItem = items.get(position);
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder)holder;
            headerViewHolder.headerTextView.setText(menuItem.getName());
        } else {
            MenuViewHolder menuViewHolder = (MenuViewHolder) holder;
            menuViewHolder.menuTextView.setText(menuItem.getName());
            int orders = menuItem.getAmountOrdered();
            String textForOrders;
            if (orders > 0) {
                textForOrders = String.valueOf(orders);
            } else {
                textForOrders = "ORDER";
            }
            menuViewHolder.orderNumbersTextView.setText(textForOrders);
            menuViewHolder.priceTextView.setText("£" + menuItem.getPrice());
        }
    }

    public ArrayList<MenuItemModel> getOrders() {
        ArrayList<MenuItemModel> orders = new ArrayList<>();
        for (MenuItemModel menuItem : items) {
            if (menuItem.getAmountOrdered() > 0) {
                orders.add(menuItem);
            }
        }
        return orders;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getAmountOrdered();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView orderNumbersTextView;
        TextView menuTextView;
        TextView priceTextView;

        public MenuViewHolder(View itemView) {
            super(itemView);
            if (isEditable) {
                itemView.setOnClickListener(this);
                itemView.setOnLongClickListener(this);
            }
            orderNumbersTextView = (TextView)itemView.findViewById(R.id.ordersTextView);
            menuTextView = (TextView) itemView.findViewById(R.id.menuItemTextView);
            priceTextView = (TextView) itemView.findViewById(R.id.priceTextView);

        }

        @Override
        public void onClick(View v) {
            items.get(getAdapterPosition()).incrementOrders();
            notifyItemChanged(getAdapterPosition());
            menuCallback.ordersChanged();
        }

        @Override
        public boolean onLongClick(View v) {
            items.get(getAdapterPosition()).setAmountOrdered(0);
            notifyItemChanged(getAdapterPosition());
            menuCallback.ordersChanged();
            return true;
        }
    }
    class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView headerTextView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerTextView = (TextView)itemView.findViewById(R.id.headerTextView);
        }
    }

    interface MenuCallback {
        void ordersChanged();
    }

}
