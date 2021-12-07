package com.ranzan.mojopizzaclone;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ranzan.mojopizzaclone.Menu.All_in_oneFragment;
import com.ranzan.mojopizzaclone.Menu.Detailed_Item_Fragment;
import com.ranzan.mojopizzaclone.communication.FragmentListener;

public class DataActivity extends AppCompatActivity implements FragmentListener {
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
        getSupportFragmentManager().beginTransaction().replace(R.id.contaner, fragment).commit();
    }


    @Override
    public void fragmentListener(Bundle bundle) {
        Detailed_Item_Fragment fragment = new Detailed_Item_Fragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.contaner, fragment).addToBackStack("").commit();
    }
}