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

class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private ArrayList<HomeData> list;

    public HomeAdapter(ArrayList<HomeData> list){
        this.list = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public ImageView user_profile;
        public TextView title;
        public ImageView direct;

        public ImageView upload_image;

        public ImageView comment;
        public ImageView comment_direct;
        public ImageView share;

        public TextView user_id;
        public TextView comment_like;
        public TextView comment_context;
        public TextView hash_tag;


        public MyViewHolder(View v) {
            super(v);
            view = v;

            user_profile = v.findViewById(R.id.user_profile);
            title = v.findViewById(R.id.title);
//            direct = v.findViewById(R.id.direct);

            upload_image = v.findViewById(R.id.Upload_image);

//            comment = v.findViewById(R.id.user_profile);
//            comment_direct = v.findViewById(R.id.user_profile);
//            share = v.findViewById(R.id.user_profile);

            user_id = v.findViewById(R.id.user_id);
            comment_like = v.findViewById(R.id.liking);
            comment_context = v.findViewById(R.id.comment_context);
            hash_tag = v.findViewById(R.id.hash_tag);

        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home, parent, false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        MyViewHolder mv = (MyViewHolder) holder ;

        mv.user_profile.setImageResource(list.get(position).user_profile);
        mv.title.setText(list.get(position).upload_title);
        mv.upload_image.setImageResource(list.get(position).upload_image);
        mv.comment_context.setText(list.get(position).comment_context);
        mv.comment_like.setText(list.get(position).liking);
        mv.user_id.setText(list.get(position).user_id);
        mv.hash_tag.setText(list.get(position).hash_tag);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}