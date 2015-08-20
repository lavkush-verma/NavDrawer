package com.lk.android.mynavdrawer;
/**
 * Created by lavakush.v on 14-07-2015.
 */
public class NavDrawerItem {

    private String mTitle;
    private int mIcon;

    public NavDrawerItem(String title) {
        this.mTitle = title;
        this.mIcon = 0;
    }

    public NavDrawerItem(String title, int icon) {
        this.mTitle = title;
        this.mIcon = icon;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getIcon() {
        return this.mIcon;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setIcon(int icon) {
        this.mIcon = icon;
    }
}
