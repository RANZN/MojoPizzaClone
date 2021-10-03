package com.ranzan.mojopizzaclone.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ranzan.mojopizzaclone.Login.LoginActivity;
import com.ranzan.mojopizzaclone.R;


public class AccountFragment extends Fragment {

    private Button loginButton;
    private FirebaseAuth mAuth;
    private TextView accountName, accountEmail, signOut;
    private View profileView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mAuth = FirebaseAuth.getInstance();
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            accountName.setText(currentUser.getDisplayName());
            accountEmail.setText(currentUser.getEmail());
            loginButton.setVisibility(View.GONE);
            profileView.setVisibility(View.VISIBLE);
        } else {
            signOut.setVisibility(View.GONE);
            loginButton.setVisibility(View.VISIBLE);
            profileView.setVisibility(View.GONE);
        }
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                accountName.setText("Your Account");
                accountEmail.setText("Login to manage your account");
                profileView.setVisibility(View.GONE);
                signOut.setVisibility(View.GONE);
                loginButton.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), "SignOut..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews(View v) {
        loginButton = v.findViewById(R.id.loginBtn);
        accountEmail = v.findViewById(R.id.accountEmail);
        accountName = v.findViewById(R.id.accountName);
        signOut = v.findViewById(R.id.signOutBtn);
        profileView = v.findViewById(R.id.profile);
    }

}