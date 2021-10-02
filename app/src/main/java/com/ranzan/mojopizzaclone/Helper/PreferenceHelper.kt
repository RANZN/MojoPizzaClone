package com.ranzan.mojopizzaclone.Helper

import android.content.Context
import com.ranzan.mojopizzaclone.communication.FragmentListener.fragmentListener
import com.ranzan.mojopizzaclone.Adapter.All_Model.posterImage
import com.ranzan.mojopizzaclone.Adapter.All_Model.nameOfItem
import com.ranzan.mojopizzaclone.Adapter.All_Model.price
import com.ranzan.mojopizzaclone.Adapter.All_Model.detailOfItem
import com.ranzan.mojopizzaclone.Adapter.HomeModel
import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderClass
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.ranzan.mojopizzaclone.R
import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderAdapter
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.ranzan.mojopizzaclone.Adapter.HomeAdapter
import androidx.recyclerview.widget.GridLayoutManager
import android.content.Intent
import com.ranzan.mojopizzaclone.DataActivity
import android.content.SharedPreferences
import com.ranzan.mojopizzaclone.Helper.PreferenceHelper
import com.ranzan.mojopizzaclone.communication.ItemClickListener
import com.ranzan.mojopizzaclone.Adapter.All_Model
import androidx.navigation.NavController
import com.ranzan.mojopizzaclone.communication.FragmentListener
import com.ranzan.mojopizzaclone.Menu.All_in_oneFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ranzan.mojopizzaclone.Menu.Detil_ItemFragment
import com.ranzan.mojopizzaclone.Adapter.CartModel
import android.widget.Toast
import com.google.gson.Gson
import androidx.appcompat.app.AppCompatActivity
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.etebarian.meowbottomnavigation.MeowBottomNavigation.ShowListener
import com.ranzan.mojopizzaclone.Fragments.Home_Fragment
import com.ranzan.mojopizzaclone.Fragments.ClubFragment
import com.ranzan.mojopizzaclone.Fragments.CartFragment
import com.ranzan.mojopizzaclone.Fragments.FreeFragment
import com.ranzan.mojopizzaclone.Fragments.AccountFragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation.ClickListener
import com.airbnb.lottie.LottieAnimationView
import android.view.animation.Animation
import com.ranzan.mojopizzaclone.MainActivity

object PreferenceHelper {
    const val PREFERENCE_DB = "music.player"
    fun getDataPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCE_DB, Context.MODE_PRIVATE)
    }

    fun writeStringToPreference(context: Context, key: String?, value: String?) {
        val editor = getDataPreference(context).edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getStringFromPreference(context: Context, key: String?): String? {
        return getDataPreference(context).getString(key, null)
    }

    fun writeIntToPreference(context: Context, key: String?, value: Int) {
        val editor = getDataPreference(context).edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getIntFromPreference(context: Context, key: String?): Int {
        return getDataPreference(context).getInt(key, 0)
    }
}