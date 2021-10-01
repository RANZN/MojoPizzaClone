package com.ranzan.mojopizzaclone;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ranzan.mojopizzaclone.Menu.All_in_oneFragment;
import com.ranzan.mojopizzaclone.Menu.Big10Fragment;
import com.ranzan.mojopizzaclone.Menu.DessertsAndDrinksFragment;
import com.ranzan.mojopizzaclone.Menu.Detil_ItemFragment;
import com.ranzan.mojopizzaclone.Menu.GarlicBreadsFragment;
import com.ranzan.mojopizzaclone.Menu.HalfAndHalfFragment;
import com.ranzan.mojopizzaclone.Menu.PartyComboFragment;
import com.ranzan.mojopizzaclone.Menu.StatersFragment;
import com.ranzan.mojopizzaclone.communication.CommunicationListener;

public class DataActivity extends AppCompatActivity {
private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        fragmentManager= getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().replace(R.id.contaner,new All_in_oneFragment(),"all_In_One").commit();

    }

}