package com.proud.edward.qless;

import java.util.ArrayList;

/**
 * Created by Admin on 31/01/2017.
 */

public class LocalMenu {

    public ArrayList<MenuItemModel> getMenu(){
        ArrayList<MenuItemModel> menu = new ArrayList<>();
        menu.add(new MenuItemModel("Pies", 0, 0, -1));
        menu.add(new MenuItemModel("Chicken + Mushroom", 3.25, 0, 0));
        menu.add(new MenuItemModel("Steak", 3.45, 0, 0));
        menu.add(new MenuItemModel("Pork", 2.85, 0, 0));

        menu.add(new MenuItemModel("Sides", 0,0,-1));
        menu.add(new MenuItemModel("Chips", 0.99, 0, 0));
        menu.add(new MenuItemModel("Chicken Nuggets", 2.99, 0,0));
        menu.add(new MenuItemModel("Corn on-the-cob", 0.99, 0, 0));

        menu.add(new MenuItemModel("Drinks", 0,0,-1));
        menu.add(new MenuItemModel("Coke", 1.55, 0, 0));
        menu.add(new MenuItemModel("Beer", 2.95,0,0));
        return menu;
    }

}
