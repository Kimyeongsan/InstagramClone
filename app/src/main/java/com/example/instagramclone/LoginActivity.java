package com.example.instagramclone;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.instagramclone.ui.basedata.ManagementData;
import com.example.instagramclone.ui.basedata.UserData;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;


public class LoginActivity extends AppCompatActivity {
    public EditText loginEmailId, logInpasswd;
    private Context mContext;
    private Button btn_custom_login, main_login_btn;
    private LoginCallback mLoginCallback;
    private CallbackManager mCallbackManager;

    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        mContext = getApplicationContext();
        mCallbackManager = CallbackManager.Factory.create();
        mLoginCallback = new LoginCallback();

        firebaseAuth = FirebaseAuth.getInstance();

        loginEmailId = findViewById(R.id.main_email);
        logInpasswd = findViewById(R.id.main_pwd);

        btn_custom_login = findViewById(R.id.btn_custom_login);
        main_login_btn = findViewById(R.id.main_login_btn);

        btn_custom_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager loginManager = LoginManager.getInstance();
                loginManager.logInWithReadPermissions(LoginActivity.this,
                        Arrays.asList("public_profile", "email"));
                loginManager.registerCallback(mCallbackManager, mLoginCallback);
            }
        });

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    ManagementData mData;

                    Toast.makeText(LoginActivity.this, "User logged in ", Toast.LENGTH_SHORT).show();

                    // 앱 상에서 전반적인 유저 데이터 저장
                    mData = ManagementData.getInstance();
                    mData.setUserData(new UserData(user.getUid(), user.getDisplayName(), user.getEmail(), null));

                    Intent I = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(I);
                } else {
                    Toast.makeText(LoginActivity.this, "Login to continue", Toast.LENGTH_SHORT).show();
                }
            }
        };

        main_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = loginEmailId.getText().toString();
                String userPaswd = logInpasswd.getText().toString();

                if (userEmail.isEmpty()) {
                    loginEmailId.setError("Provide your Email first!");
                    loginEmailId.requestFocus();
                } else if (userPaswd.isEmpty()) {
                    logInpasswd.setError("Enter Password!");
                    logInpasswd.requestFocus();
                } else if (userEmail.isEmpty() && userPaswd.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(userEmail.isEmpty() && userPaswd.isEmpty())) {
                    firebaseAuth.signInWithEmailAndPassword(userEmail, userPaswd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Not sucessfull", Toast.LENGTH_SHORT).show();
                            } else {
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                ManagementData mData;

                                // 앱 상에서 전반적인 유저 데이터 저장
                                mData = ManagementData.getInstance();
                                mData.setUserData(new UserData(user.getUid(), user.getDisplayName(), user.getEmail(), null));

                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authStateListener != null) {
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);
    }
}
