package com.ranzan.mojopizzaclone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ranzan.mojopizzaclone.Fragments.AccountFragment;
import com.ranzan.mojopizzaclone.Fragments.CartFragment;
import com.ranzan.mojopizzaclone.Fragments.ClubFragment;
import com.ranzan.mojopizzaclone.Fragments.FreeFragment;
import com.ranzan.mojopizzaclone.Fragments.Home_Fragment;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation=findViewById(R.id.bottom_navigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.group));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.cart));
        bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.offer));
        bottomNavigation.add(new MeowBottomNavigation.Model(5,R.drawable.account));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment=null;
                switch (item.getId()) {
                    case 1:
                        fragment = new Home_Fragment();
                        break;
                    case 2:
                        fragment = new CartFragment();
                        break;
                    case 3:
                        fragment = new ClubFragment();
                        break;
                    case 4:
                        fragment = new FreeFragment();
                        break;
                    case 5:
                        fragment = new AccountFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, fragment).commit();
            }
        });
        bottomNavigation.show(1,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });
    }
}