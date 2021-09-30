package com.ranzan.mojopizzaclone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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

public class DataActivity extends AppCompatActivity implements CommunicationListener {
private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        fragmentManager= getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().replace(R.id.contaner,new All_in_oneFragment(),"all_In_One").commit();
    }


    @Override
    public void launchBig10Fragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Big10Fragment big10 = new Big10Fragment();
        fragmentTransaction.replace(R.id.contaner,big10,"Big_10").addToBackStack("").commit();
    }

    @Override
    public void launchDessertAndDrinkFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DessertsAndDrinksFragment dessert = new DessertsAndDrinksFragment();
        fragmentTransaction.replace(R.id.contaner,dessert,"dessert").addToBackStack("").commit();
    }

    @Override
    public void launchGarlicFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        GarlicBreadsFragment garlic = new GarlicBreadsFragment();
        fragmentTransaction.replace(R.id.contaner,garlic,"Garlic").addToBackStack("").commit();
    }

    @Override
    public void launchHalfAndHalfFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HalfAndHalfFragment half = new HalfAndHalfFragment();
        fragmentTransaction.replace(R.id.contaner,half,"HAlf").addToBackStack("").commit();
    }

    @Override
    public void launchPartyComboFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PartyComboFragment party = new PartyComboFragment();
        fragmentTransaction.replace(R.id.contaner,party,"Party").addToBackStack("").commit();
    }

    @Override
    public void launchStartersFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StatersFragment starters = new StatersFragment();
        fragmentTransaction.replace(R.id.contaner,starters ,"Starters").addToBackStack("").commit();
    }

    @Override
    public void launchDetailItemFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Detil_ItemFragment detail  = new Detil_ItemFragment();
        fragmentTransaction.add(R.id.contaner,detail,"Detail").addToBackStack("").commit();
    }

}