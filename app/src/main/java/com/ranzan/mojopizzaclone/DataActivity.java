package com.ranzan.mojopizzaclone;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ranzan.mojopizzaclone.Fragments.CartFragment;
import com.ranzan.mojopizzaclone.Menu.All_in_oneFragment;
import com.ranzan.mojopizzaclone.Menu.Detil_ItemFragment;
import com.ranzan.mojopizzaclone.communication.FragmentListener;

public class DataActivity extends AppCompatActivity implements FragmentListener {
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
        fragment.setFragmentListener(this);
        fragment.setArguments(bundle);
        fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.contaner,fragment, String.valueOf(bundle)).commit();
    }


    @Override
    public void fragmentListener(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Detil_ItemFragment fragment=new Detil_ItemFragment();
        fragment.setArguments(bundle);
        fragmentTransaction.add(R.id.contaner,fragment).addToBackStack("").commit();
    }
}