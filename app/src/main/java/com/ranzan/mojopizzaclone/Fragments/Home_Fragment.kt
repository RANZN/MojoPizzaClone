package com.ranzan.mojopizzaclone.Fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.ranzan.mojopizzaclone.Adapter.HomeAdapter
import com.ranzan.mojopizzaclone.Adapter.HomeModel
import com.ranzan.mojopizzaclone.DataActivity
import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderAdapter
import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderClass
import com.ranzan.mojopizzaclone.R
import com.ranzan.mojopizzaclone.communication.OnClickListener
import java.util.*

class Home_Fragment : Fragment(), OnClickListener {
    private val imageButtons = ArrayList<HomeModel>()
    private val imageSliderClassList: MutableList<ImageSliderClass> = ArrayList()
    private var recyclerView: RecyclerView? = null
    private var textView: TextView? = null
    private lateinit var viewPager2: ViewPager2
    private val slideHandler = Handler()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        buildList()
        setRecyclerView()
        viewPager2!!.adapter = ImageSliderAdapter(imageSliderClassList, viewPager2)
        viewPager2!!.clipToPadding = false
        viewPager2!!.clipChildren = false
        viewPager2!!.offscreenPageLimit = 3
        viewPager2!!.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            page.translationX = -position * page.width
            page.alpha = 1 - Math.abs(position)
        }
        viewPager2!!.setPageTransformer(compositePageTransformer)
    }

    private fun buildList() {
        imageButtons.add(HomeModel(R.drawable.d))
        imageButtons.add(HomeModel(R.drawable.e))
        imageButtons.add(HomeModel(R.drawable.f))
        imageButtons.add(HomeModel(R.drawable.g))
        imageButtons.add(HomeModel(R.drawable.h))
        imageButtons.add(HomeModel(R.drawable.i))
        imageButtons.add(HomeModel(R.drawable.j))
        imageButtons.add(HomeModel(R.drawable.k))
        imageButtons.add(HomeModel(R.drawable.l))
        imageButtons.add(HomeModel(R.drawable.m))
        imageSliderClassList.add(ImageSliderClass(R.drawable.a))
        imageSliderClassList.add(ImageSliderClass(R.drawable.b))
        imageSliderClassList.add(ImageSliderClass(R.drawable.c))
    }

    private fun setRecyclerView() {
        val adapter = HomeAdapter(imageButtons, this)
        val gridLayoutManager = GridLayoutManager(this.context, 2)
        recyclerView!!.layoutManager = gridLayoutManager
        recyclerView!!.adapter = adapter
    }

    private fun initViews(view: View) {
        viewPager2 = view.findViewById(R.id.Slider)
        recyclerView = view.findViewById(R.id.recycler1)
        textView = view.findViewById(R.id.tvCategory)
    }

    override fun onClickRecyclerView(pos: Int) {
        val intent = Intent(context, DataActivity::class.java)
        intent.putExtra("pos", pos)
        startActivity(intent)
    }
}