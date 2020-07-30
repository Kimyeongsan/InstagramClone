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
    private RecyclerView recycleHome;

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

        ArrayList<String> testData = new ArrayList<>();  //  임시 data
        testData.add("With Study Together");
        testData.add("With Study Together");


//        recycleHome.setAdapter(new HomeAdapter(testData));

        return root;
    }

}
