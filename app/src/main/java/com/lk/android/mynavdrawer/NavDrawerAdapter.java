package com.lk.android.mynavdrawer;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerAdapter.ViewHolder> {

    private List<NavDrawerItem> mData;
    private NavDrawerCallbacks mNavigationDrawerCallbacks;
    private View mSelectedView;
    private int mSelectedPosition;

    public NavDrawerAdapter(List<NavDrawerItem> data) {
        mData = data;
    }

    public NavDrawerCallbacks getNavigationDrawerCallbacks() {
        return mNavigationDrawerCallbacks;
    }

    public void setNavigationDrawerCallbacks(NavDrawerCallbacks navigationDrawerCallbacks) {
        mNavigationDrawerCallbacks = navigationDrawerCallbacks;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nav_drawer_list_item, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.itemView.setClickable(true);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {
                                                       if (mSelectedView != null) {
                                                           mSelectedView.setSelected(false);
                                                       }
                                                       mSelectedPosition = viewHolder.getAdapterPosition();
                                                       v.setSelected(true);
                                                       mSelectedView = v;
                                                       if (mNavigationDrawerCallbacks != null)
                                                           mNavigationDrawerCallbacks.onNavDrawerItemSelected(viewHolder.getAdapterPosition());
                                                   }
                                               }
        );
        viewHolder.itemView.setBackgroundResource(R.drawable.nav_menu_selector);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.menuTitle.setText(mData.get(i).getTitle());
        viewHolder.menuIcon.setImageResource(mData.get(i).getIcon());
        if (mSelectedPosition == i) {
            if (mSelectedView != null) {
                mSelectedView.setSelected(false);
            }
            mSelectedPosition = i;
            mSelectedView = viewHolder.itemView;
            mSelectedView.setSelected(true);
        }
    }


    public void selectPosition(int position) {
        mSelectedPosition = position;
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView menuTitle;
        public ImageView menuIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            menuTitle = (TextView) itemView.findViewById(R.id.menu_title);
            menuIcon = (ImageView) itemView.findViewById(R.id.menu_icon);
        }
    }
}