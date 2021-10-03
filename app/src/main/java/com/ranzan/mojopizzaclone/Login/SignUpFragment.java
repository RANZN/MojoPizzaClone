package com.ranzan.mojopizzaclone.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ranzan.mojopizzaclone.MainActivity;
import com.ranzan.mojopizzaclone.R;

public class SignUpFragment extends Fragment {
    private EditText name, email, password;
    private Button continueBtn;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private DatabaseReference myRef;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mAuth = FirebaseAuth.getInstance();
        myRef = FirebaseDatabase.getInstance().getReference("users");
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                continueBtn.setVisibility(View.GONE);
                signUp();
            }
        });

    }

    private void saveDataToFireBase() {
        if (mAuth.getCurrentUser().getUid() != null) {
            myRef.child(mAuth.getCurrentUser().getUid()).setValue(name.getText().toString());
        }
    }

    private void signUp() {
        String n = name.getText().toString();
        String e = email.getText().toString();
        String p = password.getText().toString();
        if (n.length() > 3 && e.length() != 0 && android.util.Patterns.EMAIL_ADDRESS.matcher(e).matches() && p.length() > 6) {
            mAuth.createUserWithEmailAndPassword(e, p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        saveDataToFireBase();
                        Toast.makeText(getContext(), "SignUp Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        continueBtn.setVisibility(View.VISIBLE);
                    }
                }
            });
        } else {
            Toast.makeText(getContext(), "Invalid", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            continueBtn.setVisibility(View.VISIBLE);
        }
    }


    private void initViews(View v) {
        name = v.findViewById(R.id.signupName);
        email = v.findViewById(R.id.signUpEmail);
        password = v.findViewById(R.id.signUpPassword);
        continueBtn = v.findViewById(R.id.btnSignUP);
        progressBar = v.findViewById(R.id.progressBar);
    }
}