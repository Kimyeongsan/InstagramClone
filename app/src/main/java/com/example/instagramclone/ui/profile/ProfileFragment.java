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
import androidx.viewpager.widget.ViewPager;

import com.example.instagramclone.LoginActivity;
import com.example.instagramclone.R;

import com.example.instagramclone.ui.basedata.ManagementData;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;


public class ProfileFragment extends Fragment {
    private FirebaseAuth firebaseAuth;
    ProfileViewAdapter profile_ViewAdapter;
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

        profile_ViewAdapter = new ProfileViewAdapter(getParentFragmentManager());

        ViewPager mViewPager = root.findViewById(R.id.profile_viewpager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = root.findViewById(R.id.profile_tabs);
        tabLayout.setupWithViewPager(mViewPager);


        initialize();

        return root;
    }

    public void setupViewPager(ViewPager viewPager) {
        profile_ViewAdapter.addFragment(new Upload_Profile(), "달력");
        profile_ViewAdapter.addFragment(new Tag_Profile(), "시간표");
        viewPager.setAdapter(profile_ViewAdapter);

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