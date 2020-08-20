package com.example.instagramclone.ui.searh;

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

public class SearchFragment extends Fragment {
    private RecyclerView recycleSearch;
    private SearchAdapter searchAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_search, container, false);

        recycleSearch = root.findViewById(R.id.search_recycle);
        recycleSearch.setHasFixedSize(true);
        recycleSearch.setLayoutManager(new LinearLayoutManager(root.getContext()));

        ArrayList<SearchData> list = new ArrayList<>();  //  임시 data

        list.add(new SearchData(0, R.drawable.example1));
        list.add(new SearchData(0, R.drawable.example2));

        searchAdapter = new SearchAdapter(list);
        recycleSearch.setAdapter(searchAdapter);

        return root;
    }
}