package com.example.instagramclone.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.instagramclone.LoginActivity;
import com.example.instagramclone.R;

import com.example.instagramclone.ui.basedata.ManagementData;
import com.google.firebase.auth.FirebaseAuth;


public class ProfileFragment extends Fragment {
    private FirebaseAuth firebaseAuth;
    private View root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_profile, container, false);
        initialize();

        return root;
    }

    private void initialize() {
        Button btnLogOut, btnSignOut;
        TextView userNameTV;

        btnLogOut = root.findViewById(R.id.btnLogOut);
        btnSignOut = root.findViewById(R.id.btnSignOut);

        userNameTV = root.findViewById(R.id.menu_userNameTV);
        userNameTV.setText(ManagementData.getInstance().getUserData().getUser_Name());

        firebaseAuth = FirebaseAuth.getInstance();

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
                Intent intent = new Intent(
                        getContext(), LoginActivity.class);

                // 데이터 초기화 및 생성
                ManagementData.getInstance().delAllData();

                startActivity(intent);

            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getContext(), LoginActivity.class);

                // 데이터 초기화 및 생성
                ManagementData.getInstance().delAllData();

                startActivity(intent);

                signOut();
            }
        });
    }
    private void logOut () {
        firebaseAuth.getInstance().signOut();
    }

    private void signOut () {
        firebaseAuth.getCurrentUser().delete();
    }

}