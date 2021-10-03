package com.ranzan.mojopizzaclone.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.ranzan.mojopizzaclone.MainActivity;
import com.ranzan.mojopizzaclone.R;

public class LoginActivity extends AppCompatActivity {
    private EditText email, password;
    private Button loginBtn, signUpBtn;
    private FirebaseAuth mAuth;
    private FragmentManager fragmentManager;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        fragmentManager = getSupportFragmentManager();
        initViews();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginBtn.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                login();
            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SignUpFragment fragment = new SignUpFragment();
                fragmentTransaction.replace(R.id.frameLayout, fragment, "performance").commit();
            }
        });

    }

    private void initViews() {
        email = findViewById(R.id.etLoginEmail);
        password = findViewById(R.id.etLoginPassword);
        loginBtn = findViewById(R.id.btnLogin);
        signUpBtn = findViewById(R.id.signUp);
        progressBar = findViewById(R.id.progressBar);
    }

    private void login() {
        String e = email.getText().toString();
        String p = password.getText().toString();
        if (isValidDetails(e, p)) {
            mAuth.signInWithEmailAndPassword(e, p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        loginBtn.setVisibility(View.VISIBLE);
                    }
                }
            });
        }else{
            progressBar.setVisibility(View.GONE);
            loginBtn.setVisibility(View.VISIBLE);
        }

    }

    private boolean isValidDetails(String emailText, String passwordText) {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches() && emailText.length()==0) {
            email.setError("Enter Valid Email");
            return false;
        } else if (passwordText.length() < 6) {
            password.setError("Password Too short");
            return false;
        }
        return true;
    }

}