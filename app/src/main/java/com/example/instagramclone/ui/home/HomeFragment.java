package com.example.instagramclone.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView recycleHome, recycler_circle;
    private HomeAdapter homeAdapter;
    private HomeCircleAdapter homeCircleAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recycleHome = root.findViewById(R.id.home_recycle);
        recycleHome.setHasFixedSize(true);
        recycleHome.setLayoutManager(new LinearLayoutManager(root.getContext()));


        recycler_circle = root.findViewById(R.id.cycle_home_recycle);
        recycler_circle.setHasFixedSize(true);
        recycler_circle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<HomeData> list = new ArrayList<>();  //  임시 data
        ArrayList<HomeCircleData> circle_list = new ArrayList<>();  //  임시 data

        list.add(new HomeData(R.drawable.ic_account_circle_black_24dp, "title", R.drawable.example, "93 Likes", "user_id", "비 맞으면서 출근", "#비오는 날" ));
        list.add(new HomeData(R.drawable.ic_account_circle_black_24dp, "title", R.drawable.example, "93 Likes", "user_id", "비 맞으면서 출근", "#비오는 날" ));
        list.add(new HomeData(R.drawable.ic_account_circle_black_24dp, "title", R.drawable.example, "93 Likes", "user_id", "비 맞으면서 출근", "#비오는 날" ));

        circle_list.add(new HomeCircleData(R.drawable.ic_account_circle_black_24dp));
        circle_list.add(new HomeCircleData(R.drawable.ic_account_circle_black_24dp));
        circle_list.add(new HomeCircleData(R.drawable.ic_account_circle_black_24dp));
        circle_list.add(new HomeCircleData(R.drawable.ic_account_circle_black_24dp));
        circle_list.add(new HomeCircleData(R.drawable.ic_account_circle_black_24dp));
        circle_list.add(new HomeCircleData(R.drawable.ic_account_circle_black_24dp));
        circle_list.add(new HomeCircleData(R.drawable.ic_account_circle_black_24dp));

        homeAdapter = new HomeAdapter(list);
        homeCircleAdapter = new HomeCircleAdapter(circle_list);

        recycler_circle.setAdapter(homeCircleAdapter);
        recycleHome.setAdapter(homeAdapter);

        return root;
    }


}
