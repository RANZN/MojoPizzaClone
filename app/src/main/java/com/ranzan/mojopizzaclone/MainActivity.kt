package com.ranzan.mojopizzaclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.etebarian.meowbottomnavigation.MeowBottomNavigation.ClickListener
import com.etebarian.meowbottomnavigation.MeowBottomNavigation.ShowListener
import com.ranzan.mojopizzaclone.Fragments.*

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation: MeowBottomNavigation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.home))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.group))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.cart))
        bottomNavigation.add(MeowBottomNavigation.Model(4, R.drawable.offer))
        bottomNavigation.add(MeowBottomNavigation.Model(5, R.drawable.account))
        bottomNavigation.setOnShowListener(ShowListener { item ->
            var fragment: Fragment? = null
            when (item.id) {
                1 -> fragment = Home_Fragment()
                2 -> fragment = ClubFragment()
                3 -> fragment = CartFragment()
                4 -> fragment = FreeFragment()
                5 -> fragment = AccountFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.frame, fragment!!).commit()
        })
        bottomNavigation.show(1, true)
        bottomNavigation.setOnClickMenuListener(ClickListener { })
    }
}