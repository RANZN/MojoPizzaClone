package com.ranzan.mojopizzaclone;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.ranzan.mojopizzaclone.Fragments.CartFragment;
import com.ranzan.mojopizzaclone.Menu.All_in_oneFragment;

public class DataActivity extends AppCompatActivity{
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Intent intent = getIntent();
        int n = intent.getIntExtra("pos", 0);
        Bundle bundle=new Bundle();
        bundle.putInt("pos",n);
        All_in_oneFragment fragment = new All_in_oneFragment();
        fragment.setArguments(bundle);
        fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.contaner,fragment, String.valueOf(bundle)).commit();
    }

    @Override
    public void launchCartItemFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CartFragment cartFragment = new CartFragment();
        fragmentTransaction.add(R.id.contaner,cartFragment,"Cart").addToBackStack("").commit();
    }

}