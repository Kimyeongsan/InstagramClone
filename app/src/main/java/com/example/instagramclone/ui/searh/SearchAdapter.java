package com.example.instagramclone.ui.searh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.R;
import com.example.instagramclone.ui.home.HomeData;

import java.util.ArrayList;

class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    private ArrayList<SearchData> list;

    public SearchAdapter(ArrayList<SearchData> list){
        this.list = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public ImageView search_image1;
        public ImageView search_image2;
        public ImageView search_image3;
        public ImageView search_image4;
        public ImageView search_image5;
        public ImageView search_image6;
        public ImageView search_image7;
        public ImageView search_image8;
        public ImageView search_image9;


        public MyViewHolder(View v) {
            super(v);
            view = v;

            search_image1 = v.findViewById(R.id.image1);
            search_image2 = v.findViewById(R.id.image2);
            search_image3 = v.findViewById(R.id.image3);
            search_image4 = v.findViewById(R.id.image4);
            search_image5 = v.findViewById(R.id.image5);
            search_image6 = v.findViewById(R.id.image6);
            search_image7 = v.findViewById(R.id.image7);
            search_image8 = v.findViewById(R.id.image8);
            search_image9 = v.findViewById(R.id.image9);

        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search_image, parent, false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        MyViewHolder mv = holder;

        mv.search_image1.setImageResource(list.get(position).search_image);
        mv.search_image2.setImageResource(list.get(position).search_image);
        mv.search_image3.setImageResource(list.get(position).search_image);
        mv.search_image4.setImageResource(list.get(position).search_image);
        mv.search_image5.setImageResource(list.get(position).search_image);
        mv.search_image6.setImageResource(list.get(position).search_image);
        mv.search_image7.setImageResource(list.get(position).search_image);
        mv.search_image8.setImageResource(list.get(position).search_image);
        mv.search_image9.setImageResource(list.get(position).search_image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}