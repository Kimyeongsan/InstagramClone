package com.example.instagramclone.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.R;

import java.util.ArrayList;

class HomeCircleAdapter extends RecyclerView.Adapter<HomeCircleAdapter.MyViewHolder> {
    private ArrayList<HomeCircleData> circle_list;

    public HomeCircleAdapter(ArrayList<HomeCircleData> circle_list){
        this.circle_list = circle_list;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public ImageView circle_image;

        public MyViewHolder(View v) {
            super(v);
            view = v;

            circle_image = v.findViewById(R.id.cycle_home);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_cycle, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        MyViewHolder mv = (MyViewHolder) holder ;

        mv.circle_image.setImageResource(circle_list.get(position).circle_image);
    }

    @Override
    public int getItemCount() {
        return circle_list.size();
    }
}