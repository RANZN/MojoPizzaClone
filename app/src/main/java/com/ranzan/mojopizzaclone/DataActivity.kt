package com.ranzan.mojopizzaclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.ranzan.mojopizzaclone.Menu.All_in_oneFragment
import com.ranzan.mojopizzaclone.Menu.Detil_ItemFragment
import com.ranzan.mojopizzaclone.communication.FragmentListener

class DataActivity : AppCompatActivity(), FragmentListener {
    private var fragmentManager: FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        val intent = intent
        val n = intent.getIntExtra("pos", 0)
        val bundle = Bundle()
        bundle.putInt("pos", n)
        val fragment = All_in_oneFragment()
        fragment.setFragmentListener(this)
        fragment.arguments = bundle
        fragmentManager = supportFragmentManager
        fragmentManager!!.beginTransaction().add(R.id.contaner, fragment, bundle.toString())
            .commit()
    }

    override fun fragmentListener(bundle: Bundle?) {
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        val fragment = Detil_ItemFragment()
        fragment.arguments = bundle
        fragmentTransaction.add(R.id.contaner, fragment).addToBackStack("").commit()
    }
}