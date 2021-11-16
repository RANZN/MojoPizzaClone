package com.ranzan.mojopizzaclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {
    private CheckBox checkBox;
    private EditText customAddress, phoneNumber;
    private Button orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initViews();
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderNow();
            }
        });
    }

    private void orderNow() {
        if (checkBox.isChecked() && phoneNumber.getText().length() == 10) {
            Toast.makeText(OrderActivity.this, "ORDER DONE", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(OrderActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else if(!checkBox.isChecked() && phoneNumber.getText().length()==10 && customAddress.getText().length()>5){
            Toast.makeText(OrderActivity.this, "ORDER DONE", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(OrderActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else Toast.makeText(OrderActivity.this, "Enter valid Details", Toast.LENGTH_SHORT).show();

    }

    private void initViews() {
        checkBox = findViewById(R.id.checkbox);
        customAddress = findViewById(R.id.customLocation);
        phoneNumber = findViewById(R.id.orderPhoneNumber);
        orderBtn = findViewById(R.id.orderNow);

        Intent intent = new Intent(OrderActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("a", 1);
        intent.putExtra("data", bundle);
    }
}