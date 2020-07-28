package com.example.instagramclone.ui.photo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.instagramclone.R;

public class PhotoFragment extends Fragment {

    private PhotoModel photoModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        photoModel =
                ViewModelProviders.of(this).get(PhotoModel.class);
        View root = inflater.inflate(R.layout.fragment_photo, container, false);
        final TextView textView = root.findViewById(R.id.text_photo);
        photoModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
